package pis.chap27.tailrec

import scala.annotation.tailrec

// co-ons operator (~:)
// ex) List(1,1,1,2,3) == 1 ~: List(2,3) == 1 ~: 2 ~: 3
object ~: {
  def unapply(list:List[Int]):Option[(Int, List[Int])] = 
  list match {
      case Nil => None;
      case x::xs => Some((x, xs.dropWhile( _ == x )));
  }
}

object AntSeq {
  def lookAndSay(list:List[Int]):List[Int] = {
    list match {
      case Nil => Nil;
      case x~:xs => x::(list.size-xs.size)::lookAndSay(xs)     //co-ons
    }
  }
}

