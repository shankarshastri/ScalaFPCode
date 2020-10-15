package algorithm

import zio._

object RabinKarp extends App {

//  [(104 × 256 ) % 101  + 105] % 101  =  65
//  (ASCII of 'h' is 104 and of 'i' is 105)
//  hash("bra") =     [ ( 4   + 101         -  97 * [(256%101)*256] % 101 ) * 256         +    97 ] % 101              =  30
//  hash'("bra") =  [ ( [ ( [ ( 98 × 256) %101  + 114] % 101 ) × 256 ] % 101) + 97 ] % 101 = 30



  def polynomialHash(s: String): Long = {
    s.hashCode
  }

  def rKStringMatch(s: String, searchS: String)(fingerPrintHashFn: String => Long): Int = {
    val calculatedFingerPrintOfSearchS = fingerPrintHashFn(searchS)
    def rKStringMatchHelper(s: String, searchS: String, i: Int = 0)
                           (fingerPrintHashFn: String => Long, fPSearchS: Long): Int = {
      if(fingerPrintHashFn(s.substring(i, searchS.length)) == fPSearchS)
        i
      else {
        rKStringMatchHelper(s,searchS, i+1)(fingerPrintHashFn, fPSearchS)
      }
    }
    rKStringMatchHelper(s, searchS)(fingerPrintHashFn, calculatedFingerPrintOfSearchS)
  }

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, Int] = {
    import zio.console._
    (for {
        res <-  ZIO.effect(polynomialHash("bra"))
        _ <- putStrLn(res.toString)
      } yield ()).fold(_ => 0, _ => 1)
  }
}
