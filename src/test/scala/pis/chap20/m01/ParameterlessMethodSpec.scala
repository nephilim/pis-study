package pis.chap20.m01
import org.scalatest.Spec

class VariousMethod {
	def parameterless:String = {
	  "Paremeterless"
	}
	def voidParam():String = {
	  "Void"
	}
}

class ParameterlessMethodSpec extends Spec {
	describe("HI") {
	  it("") {
	   val vm = new VariousMethod();
	   Console.println(vm.parameterless);
	   Console.println(vm.voidParam);
	  }
	}
}