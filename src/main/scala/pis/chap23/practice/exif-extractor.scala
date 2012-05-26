package pis.chap23.practice

import java.io.File
import scala.sys.process.stringToProcess

import com.drew.imaging.jpeg.JpegMetadataReader
import com.drew.metadata.Metadata

object main extends App {
	val extractor = new ExifExtractor("/Users/skplanet/images")
	
}

case class ExifExtractor(val dirname:String) {
  type ExifData = Map[String,String]
  
  val metadatas = extractFromDir(dirname);  
  
  private def extractFromDir(dirname:String):Stream[Metadata] = {
    import sys.process._
	val filenames = "find %s -name *.jpg".format(dirname).lines_!
	
	Console.println("size %d".format(filenames.size))
	filenames.map( (filename) => {
	  extractFile( new File(filename) ); 
	})
  }
  
  def extractFile(file: File):Metadata = {
	JpegMetadataReader.readMetadata(file)
  }
  
  def printTag(metadata:Metadata):Unit = {
    Console.println("%d directories".format(metadata.getDirectoryCount()))
    import scala.collection.JavaConversions._
    metadata.getDirectories().foreach( (directory) =>
      for (tag <- directory.getTags ) {
        Console.println(tag)
      }
    )
  }  
}

