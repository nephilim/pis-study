package pis.chap19.m06

class Publication(val title:String) 
class Book(title:String) extends Publication(title)

object Library {
  val books:Set[Book] = Set(
      new Book("Linux Programming Interface"),
      new Book(""))
      
  def printBookList(extractInfo:Book => AnyRef) {
    for(book <- books) println(extractInfo(book))
  }
}

object Customer extends Application {
  def getTitle(p:Publication):String = p.title
  Library.printBookList(getTitle)
}
