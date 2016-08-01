package Study082

/**
 * List的ListBuffer是如何高效的遍历计算的
 * Created by liguodong on 2015/12/15.
 */
object Main {
  def main(args: Array[String]) {
    val list = List(1,2,3,4,5,6,7,8,9)
    increment(list)
    println(increment_MoreEffective(list))
    println(increment_MostEffective(list))
  }

  def increment(list:List[Int]):List[Int] = list match {
    case List() => List() //如果为空，返回空。
    case head::tail => head + 1:: increment(tail)
  }

  def increment_MoreEffective(list:List[Int]):List[Int] = {
    var result = List[Int]()
    for(element <- list) result = result ::: List(element + 1)
    result
  }

  def increment_MostEffective(list:List[Int]):List[Int] = {
    import  scala.collection.mutable.ListBuffer
    var buffer = new ListBuffer[Int]
    for(element <- list) buffer += element + 1
    buffer.toList
  }

}
