package pis.chap19

trait Queue[T] {
  def head: T
  def tail: Queue[T]
  def enqueue(x:T):Queue[T]
}


