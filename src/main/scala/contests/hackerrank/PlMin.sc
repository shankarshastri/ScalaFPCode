val l1 = List(2, 1, 5, 8)

//(2,5),()

def powerSet[A](t: Set[A]): Set[Set[A]] = {
  @annotation.tailrec
  def pwr(t: Set[A], ps: Set[Set[A]]): Set[Set[A]] = {
    println(t)
    println(ps)
    if (t.isEmpty) ps
    else pwr(t.tail, ps ++ (ps map (_ + t.head)))
  }
  
  pwr(t, Set(Set.empty[A]))
}



powerSet(l1.toSet)
