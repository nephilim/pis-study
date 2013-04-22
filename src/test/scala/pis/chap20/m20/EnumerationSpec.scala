package pis.chap20.m20
import org.scalatest.Spec

object TrinitronColor extends Enumeration {
	val Red, Green, Blue = Value	// Value는 parameterless method
									// Value method의 return type은 Enumeration.Value
}

object Direction extends Enumeration {
	val North = Value("North")
	val East = Value("East")
	val South = Value("South")
	val West = Value("West")
}

class EnumerationSpec extends Spec {
	describe("HI") {
	  it("") {
	   assert(TrinitronColor.Blue.id == 2)
	  }
	}
}