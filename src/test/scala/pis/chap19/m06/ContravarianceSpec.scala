package pis.chap1
import org.scalatest.Spec
import org.scalatest.BeforeAndAfter
import pis.chap19.m06.OutputChannel

/*
class ContravarianceSpec 
extends Spec with BeforeAndAfter {
  
  describe("OutputChannel을 통해 Contravariance 감잡기") {

    it("Contravariance가 OutputChannel에게는 자연스러운 Position이다") {
    	val stringOut:OutputChannel[String] = new OutputChannel[AnyRef] {
    	  //o를 이용하는 입장에서 "보다 기능이 많은 객체"를 인자로 받는 것은 문제가 없다
    	  def write(o:AnyRef) = Console.println(o) 
    	} 	
    	stringOut.write("HELLO SCALA");
    }
    
  }
  
 
} */