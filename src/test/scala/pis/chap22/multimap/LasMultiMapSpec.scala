package pis.chap22.multimap
import org.junit.runner.RunWith
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class LasMultiMapSpec extends Spec {
  
  describe("정의한 LasDan MultiMap의 기본 동작을 확인한다") {
    it ("기본 동작") {
      val mmap = new LasMultiMap[String,String]();
      val key = "a-Key"
      //mmap.put(key,"A");
      mmap(key) = "A";
      assert( mmap(key)(0) == "A" )

      mmap(key) = "B"
      assert( mmap(key)(1) == "B")
      
      assert( mmap(key) == List("A","B"))
      
      mmap(key) = "B"
      assert( mmap(key) == List("A","B","B"))
      
      assert( mmap.keySet == Set(key))
    }
  }
}