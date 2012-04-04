package pis.chap19.m06

trait OutputChannel[-T] {
	def write(x:T)
}

//OutputChannel[String]은 OutputChannel[AnyRef]로 대체 가능
class OutputChannelImpl[T] 
extends OutputChannel[T] {
	def write(x:T) = println(x.toString())
}
