package Study040



/**
 * Set Map TreeSet TreeMap
 * Created by liguodong on 2015/11/30.
 */
object Demo {
  def main(args: Array[String]) {

    import scala.collection.mutable.Set
    val data = Set.empty[Int]
    data ++= List(1,2,3)
    data += 4
    data --= List(2,3)
    println(data)

    data += 1
    println(data)

    data.clear
    println(data)

    import scala.collection.mutable

    val map = mutable.Map.empty[String,String]
    map("Java") = "Hadoop"
    map("Scala") = "Spark"
    println(map)
    println(map("Scala"))

    //打印时已经排序了
    val treeSet = mutable.TreeSet(9,4,2,1,23,4,11,5,6,7,8)
    println(treeSet)

    import scala.collection.immutable.TreeMap
    val treeMap = TreeMap("Scala"->"Spark","Java"->"Hadoop","C++"->"Qt")
    println(treeMap)



  }
}
