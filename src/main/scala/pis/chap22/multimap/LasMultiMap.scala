package pis.chap22.multimap
import scala.collection.mutable.HashMap
import scala.collection.mutable.ListBuffer

class LasMultiMap[K, V] {
  
  type Values = List[V]
    
  private[this] val _map= new HashMap[K, ListBuffer[V]]()

  def update(key: K, valueToAdd: V): Unit = {
    put(key, valueToAdd)
  }

  def put(key: K, valueToAdd: V): Unit = {
    val listOpt: Option[ListBuffer[V]] = _map.get(key)
    listOpt match {
      case None =>
        val list: ListBuffer[V] = new ListBuffer()
        list += valueToAdd
        _map(key) = list
      case Some(prevList: ListBuffer[V]) =>
        prevList += valueToAdd
    }
  }
  
  def apply(key:K):Values = {
    _map(key).toList
  }

  def keySet() = {
    _map.keySet
  }
  
  override def toString(): String = {
    _map.toString()
  }
}