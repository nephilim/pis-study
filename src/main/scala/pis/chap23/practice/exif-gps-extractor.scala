package pis.chap23.practice

import java.io.File
import scala.sys.process.stringToProcess
import com.drew.imaging.jpeg.JpegMetadataReader
import com.drew.metadata.Metadata
import com.drew.metadata.exif.ExifSubIFDDirectory
import com.drew.metadata.exif.ExifSubIFDDescriptor
import com.drew.metadata.exif.GpsDirectory
import com.drew.metadata.exif.GpsDescriptor

case class ExifGifExtractor(val dirname:String )
 {
  type ExifData = Map[String,String]
  
  val metadatas = extractFromDir();  
  
  private[practice] def extractFromDir():Stream[Metadata] = {
    import sys.process._
	val filenames = "find %s -name *.jpg".format(dirname).lines_!
	
	filenames.map( (filename) => {
	  JpegMetadataReader.readMetadata( new File(filename) ); 
	})
  }
 
  def extractGpsPos(metadata:Metadata):(String,String) = {
    //import scala.collection.JavaConversions._
    val directory = metadata.getDirectory(classOf[GpsDirectory])
    val descriptor = new GpsDescriptor(directory)
    (descriptor.getGpsLatitudeDescription, descriptor.getGpsLongitudeDescription)
  }
  
  def foreach(f:(Tuple2[String,String]) => Unit):Unit = {
    metadatas.foreach((metadata) => f(extractGpsPos( metadata )))
  }
  def map(f:(ExifGifExtractor) => Tuple2[String,String]) = {
    metadatas.map( extractGpsPos( _ ))
  }
  def filter(p:Tuple2[String,String] => Boolean) = {
    metadatas.filter( (metadata) => p(extractGpsPos( metadata )) )
  }
  
}

