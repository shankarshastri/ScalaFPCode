

import scala.collection.immutable._

case class Expr(att: String, op: String, value: String)
def fetchAttrFromCharge(s: String, att: String): Option[String] = {
  val indexOf = s.indexOf(att)
  if(indexOf == -1)
    None
  else {
    if(s.indexOf("&", indexOf) != -1) {
      Some(s.substring(indexOf, s.indexOf("&", indexOf)).trim)
    }
    else
      Some(s.substring(indexOf).trim)
  }
}

def attrToExpr(s: String, splitBy: String): Option[Expr] = {
  val indexOfExpr = s.indexOf(splitBy)
  if(indexOfExpr == -1) None
  else {
    val (att, value) = s.splitAt(indexOfExpr)
    Some(Expr(att.trim, splitBy, value.splitAt(value.indexOf(splitBy) + splitBy.length)._2.trim))
  }
}

def exprOp(s: String): String = {
  if(s.contains("==")) "=="
  else if(s.contains("!=")) "!="
  else "="
}


def fetchChargeAttr(charge: String, att: String): Option[Expr] = {
  for {
    j <- fetchAttrFromCharge(charge, att)
    k <- attrToExpr(j, exprOp(j))
  } yield k
}

def constExprForAllow(s: String): Option[Expr] = {
  val tS = s.trim
  attrToExpr(tS, exprOp(tS))
}

def fetchAttrFromAllowAndBlock(s: String, att: String, allowOrBlock: String): Option[Expr] = {
  if(s.contains(allowOrBlock) && s.contains(att)) {
     if(s.contains("AND")) {
       val index = s.indexOf(att)
       val subS = s.substring(index)
       if(subS.contains("AND"))
         constExprForAllow(s.substring(index, s.indexOf("AND", index)))
       else
         constExprForAllow(s.substring(index))
     } else if(s.contains("OR")) {
       val index = s.indexOf(att)
       val subS = s.substring(index)
       if(subS.contains("OR"))
         constExprForAllow(s.substring(index, s.indexOf("OR", index)))
       else
         constExprForAllow(s.substring(index))
     } else {
       val index = s.indexOf(att)
       constExprForAllow(s.substring(index))
     }
  } else {
    None
  }
}

def performOp(aOrB: Boolean, a: String, b: String, op: String): Option[Boolean] = {
  aOrB match {
    case true =>
      op match {
        case "==" => Some(a == b)
        case "!=" => Some(a != b)
        case _ => None
      }
    case false =>
      op match {
        case "==" => Some(a != b)
        case "!=" => Some(a == b)
        case _ => None
      }
  }
}


def verifyQuery(aOrB: String, op: String, m: Map[String, Option[Expr]], charge: Map[String, Option[Expr]]): Boolean = {

  aOrB match {
  case "ALLOW" =>
    op match {
      case "AND" =>
        List("amount", "card_country", "currency", "ip_country").map(e => {
          (for {
            aOrB <- m.get(e)
            charge <- charge.get(e)
            aOrBV <- aOrB
            chargeV <- charge
            _ = println(aOrBV, chargeV)
            res <-  performOp(true, chargeV.value, aOrBV.value, aOrBV.op)
            _ = println(res)
          } yield res)
        }).filter(_.isDefined).map(_.get).reduce(_ || _)
      case "OR" =>
        List("amount", "card_country", "currency", "ip_country").map(e => {
          (for {
            aOrB <- m.get(e)
            charge <- charge.get(e)
            aOrBV <- aOrB
            chargeV <- charge
            _ = println(aOrBV, chargeV)
            res <-  performOp(true, chargeV.value, aOrBV.value, aOrBV.op)
            _ = println(res)
          } yield res)
        }).filter(_.isDefined).map(_.get).reduce(_ || _)
      case "" =>
        List("amount", "card_country", "currency", "ip_country").map(e => {
          (for {
            aOrB <- m.get(e)
            charge <- charge.get(e)
            aOrBV <- aOrB
            chargeV <- charge
            _ = println(aOrBV, chargeV)
            res <-  performOp(true, chargeV.value, aOrBV.value, aOrBV.op)
            _ = println(res)
          } yield res)
        }).filter(_.isDefined).map(_.get).head

    }

  case "BLOCK" =>
    op match {
      case "AND" =>
        List("amount", "card_country", "currency", "ip_country").map(e => {
          (for {
            aOrB <- m.get(e)
            charge <- charge.get(e)
            aOrBV <- aOrB
            chargeV <- charge
            _ = println(aOrBV, chargeV)
            res <-  performOp(false, chargeV.value, aOrBV.value, aOrBV.op)
            _ = println(res)
          } yield res)
        }).filter(_.isDefined).map(_.get).reduce(_ && _)
      case "OR" =>
        List("amount", "card_country", "currency", "ip_country").map(e => {
          (for {
            aOrB <- m.get(e)
            charge <- charge.get(e)
            aOrBV <- aOrB
            chargeV <- charge
            _ = println(aOrBV, chargeV)
            res <-  performOp(false,chargeV.value, aOrBV.value, aOrBV.op)
            _ = println(res)
          } yield res)
        }).filter(_.isDefined).map(_.get).reduce(_ || _)
      case "" =>
        List("amount", "card_country", "currency", "ip_country").map(e => {
          (for {
            aOrB <- m.get(e)
            charge <- charge.get(e)
            aOrBV <- aOrB
            chargeV <- charge
            _ = println(aOrBV, chargeV)
            res <-  performOp(false, chargeV.value, aOrBV.value, aOrBV.op)
            _ = println(res)
          } yield res)
        }).filter(_.isDefined).map(_.get).head
    }
}
}


def should_allow_charge(charge_and_rules: Array[String]): Boolean = {
  val chargeQ = charge_and_rules.filter(_.contains("CHARGE")).head
  val allowQ = charge_and_rules.filter(_.contains("ALLOW"))
  val blockQ = charge_and_rules.filter(_.contains("BLOCK"))

  val mapOfChargeAttr = Map[String, Option[Expr]](
    "amount" -> fetchChargeAttr(chargeQ, "amount"),
  "card_country" -> fetchChargeAttr(chargeQ, "card_country"),
  "currency" -> fetchChargeAttr(chargeQ, "currency"),
  "ip_country" -> fetchChargeAttr(chargeQ, "ip_country"))


  if(allowQ.length == 0 && blockQ.length == 0) true
  else {
    val resAllowQ = allowQ.map {
      e => {
        Map[String, Option[Expr]](
          "amount" -> fetchAttrFromAllowAndBlock(e, "amount", "ALLOW"),
          "card_country" -> fetchAttrFromAllowAndBlock(e, "card_country", "ALLOW"),
          "currency" -> fetchAttrFromAllowAndBlock(e, "currency", "ALLOW"),
          "ip_country" -> fetchAttrFromAllowAndBlock(e, "ip_country", "ALLOW"))
      }
    }

    val resBlockQ = blockQ.map {
      e => {
        Map[String, Option[Expr]](
          "amount" -> fetchAttrFromAllowAndBlock(e, "amount", "BLOCK"),
          "card_country" -> fetchAttrFromAllowAndBlock(e, "card_country", "BLOCK"),
          "currency" -> fetchAttrFromAllowAndBlock(e, "currency", "BLOCK"),
          "ip_country" -> fetchAttrFromAllowAndBlock(e, "ip_country", "BLOCK"))
      }
    }

    val resAllow = (allowQ zip resAllowQ).map {
      e => {
        if(e._1.contains("AND")) {
          verifyQuery("ALLOW", "AND", e._2, mapOfChargeAttr)
        } else if(e._1.contains("OR")) {
          verifyQuery("ALLOW", "OR", e._2, mapOfChargeAttr)
        } else {
          verifyQuery("ALLOW", "", e._2, mapOfChargeAttr)
        }
      }
    }

    val resBlock = (blockQ zip resBlockQ).map {
      e => {
        if(e._1.contains("AND")) {
          verifyQuery("BLOCK", "AND", e._2, mapOfChargeAttr)
        } else if(e._1.contains("OR")) {
          verifyQuery("BLOCK", "OR", e._2, mapOfChargeAttr)
        } else {
          verifyQuery("BLOCK", "", e._2, mapOfChargeAttr)
        }
      }
    }

    (resAllow.isEmpty || resAllow.toList.reduce(_ && _)) && (resBlock.isEmpty || resBlock.toList.reduce(_ && _))
  }
}


val arr = Array[String]("CHARGE: card_country=SG&currency=SGD&amount=1510&ip_country=CA",
  "BLOCK: amount != 1510 AND card_country != SG", "ALLOW: ip_country == CA")

should_allow_charge(arr)



//fetchAttrFromCharge("CHARGE: card_country=SG&currency=SGD&amount=150&ip_country=CA", "ip_country")
