package pis.chap27.tailrec

import org.junit.runner.RunWith
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ReadAndSaySpec extends Spec {
  
  describe("개미수열을 제대로 읽는지 확인한다.") {
    it ("tail recursion은 일어나지 않는다.") {
    	val result = AntSeq.lookAndSay(List(1,1,2,2,2,3));
    	Console.println(result);
    }
  }
}