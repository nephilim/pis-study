package misc.continuation
import scala.util.continuations.reset
import scala.util.continuations.shift

import org.scalatest.Spec

/**
 * continuation plugin을 enabled 시키고 진행해야 함
 * -P:continuations:enable
 */
class DelimitedContinuationSpec extends Spec{
	 
  describe("Delimited Continuation") {
    it("Basic reset-shift control") {
    	reset {
	      shift{ k:(Unit =>Unit) => 2 }
	    }
	    assert(1 === 1)
    }
  }
}