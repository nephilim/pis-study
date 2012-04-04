package misc.specialization

class SpecializedBox[@specialized(Double) T] {
	private var _value: T = _
	
	def value: T = _value
	def value_=(x:T) = 
	  _value = x
}

object SpecializedBox{
	def apply[T]():SpecializedBox[T] = {
	  new SpecializedBox[T]();
	}
}

object Main extends Application {
	val box:SpecializedBox[Int] = SpecializedBox()  
}