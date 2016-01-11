package Study080


/**
 * List泛型分析以及::类和Nil对象
 * Created by liguodong on 2015/12/15.
 */
object Main {
  def main(args: Array[String]) {

    //List

    //List的两个子类

    //The empty list.
    /*
    case object Nil extends List[Nothing] {
      override def isEmpty = true

      override def head: Nothing =
        throw new NoSuchElementException("head of empty list")

      override def tail: List[Nothing] =
        throw new UnsupportedOperationException("tail of empty list")

      // Removal of equals method here might lead to an infinite recursion similar to IntMap.equals.
      override def equals(that: Any) = that match {
        case that1: scala.collection.GenSeq[_] => that1.isEmpty
        case _ => false
      }
    }
    */

    //A non empty list characterized by a head and a tail.
    /*
    final case class ::[B](override val head: B, private[scala] var tl: List[B]) extends List[B] {
      override def tail : List[B] = tl

      override def isEmpty: Boolean = false
    }
    */
  }
}
