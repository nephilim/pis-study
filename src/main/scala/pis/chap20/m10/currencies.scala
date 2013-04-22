package pis.chap20.m10

abstract class Currency {
	val amount: Long 
	def designation: String
	override def toString = amount + " " + designation
	def + (that:Currency):Currency 
	def * (x:Double):Currency
}