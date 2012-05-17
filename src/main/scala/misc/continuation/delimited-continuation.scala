package misc.continuation
import scala.util.continuations.reset
import scala.util.continuations.shift

/**
 * continuation plugin을 enabled 시키고 진행해야 함
 * -P:continuations:enable
 */
object DelimitedContinuationApp extends App{
	var result = reset {
	  shift{ k:(Int => Int) =>
	    k(k(0));
	  } + 1
	}
	Console.println(result)
}

/*
When you look at a shift block and see its return value 
being used in an expression, as in the "shift + 1" examples above, remember that, due to code transformation, that "return" from the shift block never actually happens as a return. Instead, once execution reaches the shift block, the code after that block gets passed to it as a continuation; if the code in the shift block calls the continuation, the value which is passed as an argument to the continuation appears as the value being returned from the shift block. Thus the type of the argument passed to the shift block's continuation function is the same as the type of the return value of the shift in the source code, and the type of the return value of that continuation function is the same as the type of the return value of the original last value in the reset block that encloses the shift block. 
*/