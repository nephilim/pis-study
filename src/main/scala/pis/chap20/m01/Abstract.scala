package pis.chap20.m01

trait Abstract[T] {
	def transformTo[U](x:U):T 
	val initialState: T
}

class Concrete extends Abstract[String] {
	def transformTo[U](x:U):String = {
		"transformToString";
	}
	
	val initialState:String = "initialState";
}

