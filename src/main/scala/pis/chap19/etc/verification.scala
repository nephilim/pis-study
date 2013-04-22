package pis.chap19.etc

class Verified[+A](assertion: (A) => Boolean, value: A) {
  
  def a = value
  //def a_=[B>:A <:T](a:B) = new Verified[B,T]( assertion, a )
  
}