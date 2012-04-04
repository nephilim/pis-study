package misc.blog
import org.scalatest.Spec

class TrueScalaComplexity extends Spec{
  class Array
  class Seq { def head = 0 }
  class WrappedArray(xs: Array) extends Seq
  
  implicit def array2seq(xs:Array):Seq = 
    new WrappedArray(xs)
  implicit def seq2richseq(xs: Seq) = 
    new { def ident = xs }
  describe("") {
    it("") {
      
    }
  }
}