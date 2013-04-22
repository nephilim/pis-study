package pis.chap19.m01
import pis.chap19.Queue

/*
 * 내용을 추가 순서대로 저장하는 Q
 */
class SlowAppendQueue1[T](elems: List[T]) {
  
  def head = elems.head  
  
  // immutable한데 tail을 요구할 때마다 매번 생성해서 줘야하다니 실망이다.
  def tail = new SlowAppendQueue1(elems.tail) 
  
  def enqueue(elem:T) = new SlowAppendQueue1(elems ::: List(elem)) 
}

/*
 * 내용을 추가 순서의 역순으로 저장하는 Q 
 */
class SlowAppendQueue2[T](reversed: List[T]) 
extends Queue[T] {
  
  def head = reversed.last
  
  // immutable한데 tail을 요구할 때마다 매번 생성해서 줘야하다니 두번봐도 실망이다.
  def tail = new SlowAppendQueue2(reversed.init) 
  
  def enqueue(elem:T) = new SlowAppendQueue2(elem::reversed) 
}

// private[m01] 로 패키지 접근: 괜히 이래 봤음
private[m01] class QueueImpl[T] (
    val leading:List[T], 
    val trailing:List[T]) 
extends Queue[T] {
  
  def mirror = 
    if (leading.isEmpty) new QueueImpl(trailing.reverse, Nil)
    else this
    
  def head = mirror.leading.head
  def tail = {
    val q = mirror
    new QueueImpl(q.leading.tail, q.trailing)
  }
  def enqueue(elem:T) = 
    new QueueImpl(leading, elem:: trailing)
}

object Queue {
  def apply[T]( xs: T*) = new QueueImpl[T](xs.toList, Nil)
}

// javap 결과 비교:
// class Queue2[T] private (val leading:List[T], val trailing:List[T]) { }