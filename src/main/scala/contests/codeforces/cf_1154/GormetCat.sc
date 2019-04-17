//on Mondays, Thursdays and Sundays he eats fish food;
//on Tuesdays and Saturdays he eats rabbit stew;
//on other days of week he eats chicken stake.
//  Polycarp plans to go on a trip and already packed his backpack. His backpack contains:
//
//𝑎 daily rations of fish food;
//𝑏 daily rations of rabbit stew;
//𝑐 daily rations of chicken stakes.

val fishFood = 30
val rabbitStew = 20
val chickenStake = 10



val m = Map[Int, Int]().updated(0, fishFood).
  updated(1, rabbitStew).updated(2, chickenStake)

val mToWeekD = Map[Int, Int]((0, 0), (1, 1), (2, 2),
  (3, 0), (4,2), (5,1),(6,0))


def gormetCat(m: Map[Int, Int], mToWeekD: Map[Int, Int], index: Int = 0, result: Int = 0): Int = {
  val i = mToWeekD.getOrElse(index % 7, 0)
 if(m.getOrElse(i, 0) == 0) {
   result
 } else {
   gormetCat(m.updated(i, m.getOrElse(i, 0) - 1), mToWeekD, index+1, result+1)
 }
}

(0 to 6).map(gormetCat(m, mToWeekD, _))