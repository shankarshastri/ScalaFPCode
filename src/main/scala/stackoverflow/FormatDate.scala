/**
  * @author ShankarShastri
  *         Algorithm: FormatDate
  */

package stackoverflow
import java.time.format.DateTimeFormatter
object SetSuite {
  def main(args: Array[String]) {
    val date = "3/22/2018 12:24:29 PM"

    var formatter = DateTimeFormatter.ofPattern( "M/dd/yyyy h:mm:ss a" )
    println(formatter.parse(date))
  }
}
