package pis.chap23.practice

import java.io.File

import scala.sys.process.stringToProcess

import com.drew.imaging.jpeg.JpegMetadataReader
import com.drew.metadata.Metadata

object Main extends App {	
  val exifs = ExifExtractor();
}

case class ExifExtractor() {
  type ExifData = Map[String,String]
  
  def extractFromDir(dirname:String):Stream[Metadata] = {
    import sys.process._
	val filenames = "find %s -name *.jpg".format(dirname).lines_!
	
	Console.println("size %d".format(filenames.size))
	filenames.map( (filename) => {
	  extractFile( filename ) 
	})
  }
  
  def extractFile(filename:String):Metadata = {
	import java.io.File
	JpegMetadataReader.readMetadata(new File(filename))
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

