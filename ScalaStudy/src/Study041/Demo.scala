package Study041

/**
 * List继承体系实现内幕和方法操作
 * Created by liguodong on 2015/11/30.
 */
object Demo {
  def main(args: Array[String]) {
    val list:List[Int] = List(1,2,3,4,5)
    val ListAny : List[Any] = list
    println(list.isEmpty)
    println(list.head)
    println(list.tail)
    println(list.length)
    println(list.drop(3))
    println(list.map(_*2))


  }
}
