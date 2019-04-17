package contests.codeforces.cf_1154

import scala.annotation.tailrec
import scala.io.StdIn._

object GourmetCat {
  
  @tailrec
  def gormetCat(m: Map[Int, Int], mToWeekD: Map[Int, Int], index: Int = 0, result: Int = 0): Int = {
    val i = mToWeekD.getOrElse(index % 7, 0)
    if(m.getOrElse(i, 0) == 0) {
      result
    } else {
      gormetCat(m.updated(i, m.getOrElse(i, 0) - 1), mToWeekD, index+1, result+1)
    }
  }
  
  @tailrec
  def reduceCatFood(fishFood: Int, rabbitStew: Int, chickenStake: Int, result: Int = 0): (Int, Int, Int, Int) = {
    if(fishFood > 3 && rabbitStew > 3  && chickenStake > 3) {
      reduceCatFood(fishFood - 3, rabbitStew - 2, chickenStake - 2, result + 7)
    } else (fishFood, rabbitStew, chickenStake, result)
  }
  
  
  def main(args: Array[String]): Unit = {
    val Array(fishFood, rabbitStew, chickenStake) = readLine.split(" ").map(_.toInt)
    
    
    val (reducedFishFood, reducedRabbitStew, reducedChickenStake, prelimResult) =
      reduceCatFood(fishFood, rabbitStew, chickenStake)
    val m = Map[Int, Int]().updated(0, reducedFishFood).
      updated(1, reducedRabbitStew).updated(2, reducedChickenStake)
    val mToWeekD = Map[Int, Int]((0, 0), (1, 1), (2, 2),
      (3, 0), (4,2), (5,1),(6,0))
    
    
    println((0 to 6).map(gormetCat(m, mToWeekD, _, prelimResult)).max)
  }
}
