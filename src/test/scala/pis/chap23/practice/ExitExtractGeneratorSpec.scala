package pis.chap23.practice
import org.junit.runner.RunWith
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExifExtractorGeneratorSpec extends Spec {
  val DIR_NAME = "images"

  describe("Metadata 추출") {
    it("상속 관계 확인") {
      val extractor = new ExifGifExtractor(DIR_NAME)
      assert( extractor.metadatas.size == 3)  	// image 파일 3개 
    }
    it("GPS 정보(위도, 경도) 추출") {
      val extractor = new ExifGifExtractor(DIR_NAME)
      val metadata = extractor.metadatas(0)
      assert(
          extractor.extractGpsPos(metadata).toString ==  
          "(37.0° 32.0\' 5.399999999993383\",126.0° 59.0\' 39.59999999998786\")")
    }
    it("Generator 동작확인") {
      val extractor = new ExifGifExtractor(DIR_NAME)
      for( position:(String,String) <- extractor ) {
        
      }
    }
  }

}