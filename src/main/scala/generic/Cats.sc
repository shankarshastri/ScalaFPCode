import cats.data.Reader
import cats.data.State


case class Db(userNames: Map[Int, String], passwords: Map[String, String])


type DbReader[T]  = Reader[Db, T]

def findUsername(userId: Int): DbReader[Option[String]] = {
  val dbReader: DbReader[Option[String]] = Reader[Db, Option[String]](db => db.userNames.get(userId))
  dbReader
}

def checkPassword(
                    username: String,
                    password: String): DbReader[Boolean] = {
  Reader[Db, Boolean](db => db.passwords.get(username).contains(password))
}


def checkLogin(
                 userId: Int,
                 password: String): DbReader[Boolean] = {
  Reader[Db, Boolean](db => db.passwords.get(db.userNames.getOrElse(userId, "")).contains(password))
}


val users = Map(
  1 -> "dade",
  2 -> "kate",
  3 -> "margo"
)

val passwords = Map("dade"  -> "zerocool",
  "kate"  -> "acidburn",
  "margo" -> "secret"
  )
  val db = Db(users, passwords)
  checkLogin(1, "zerocool").run(db)
  checkLogin(4, "davinci").run(db)


class State[S, A]
object State {
  def apply[S, A](a: S => (S,A)): S => (S,A) = a
}




val step1 = State[Int, String] { num =>
  val ans = num + 1
  (ans, s"Result of step1: $ans")
}

val step2 = State[Int, String] { num =>
  val ans = num * 2
  (ans, s"Result of step2: $ans")
}


val both = for {
  a <- step1
  b <- step2
} yield (a , b)

both(20)

































