package contests.codeforces.cf_379

object CF_379_Wrong_Subtraction extends App {

  val Array(num: Int, times: Int) =
    scala.io.StdIn.readLine.split(" ").map(_.toInt)

  def subtractTanya(num: Int, times: Int) = {
    (1 to times).foldLeft(num)((a, _) => {
      if (a % 10 == 0) a / 10
      else a - 1
    })
  }

  println(subtractTanya(num, times))
}
