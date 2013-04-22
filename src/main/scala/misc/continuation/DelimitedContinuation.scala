package misc.continuation
import scala.util.continuations.reset
import scala.util.continuations.shift

/**
 * continuation plugin을 enabled 시키고 진행해야 함
 * -P:continuations:enable
 */
object DelimitedContinuationApp {

  /*
  def main(args: Array[String]) {
    var result = reset {
      shift { k: (Int => Int) => {println(k(10)); println(k(k(10))); k(10)} }
    } + 1
    
  }
  */
}

/*
object DelimitedContinuationApp3 {
  def func1():Int = {
    shift { k: (Int => Int) =>
      k(10)
    }
  }
  
  def main(args: Array[String]) {
	  println( reset(2*func1()) )
  }
}

object DelimitedContinuationApp2 {
  def foo() = {
    println("Once here.")
    shift{ (k: Int => Int) => println(k(k(7)));println(k(7)); k(k(k(7))) }
  }
  def bar() = {
    1 + foo()
  }
  def baz() = {
    reset(bar() * 2)
  }
 
  def main(args: Array[String]) {
   
    println( baz()) // result 70)
  }
}
*/
