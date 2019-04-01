class Par[V]

object Par {
  def get[V](a: Par[V]): V = ???
  def unit[V](a: V): Par[V] = ???
  
  def map2[A, B, C](a: Par[A], b: Par[B])
                   (f: (A, B) => C): Par[C] = {
    unit(f(get(a), get(b)))
  }
  
  def sequence[A](ps: List[Par[A]]): Par[List[A]] = {
    unit(ps.map(get(_)))
  }
}

