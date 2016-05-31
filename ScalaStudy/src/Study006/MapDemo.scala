package Study006

/**
  * 1、Map
  * Created by liguodong on 2015/11/14.
  */
object MapDemo {
  def main(args: Array[String]) {
    //构建的不可变的Map（默认是不可修改的）
    val map = Map("book"->10,"gun"->18,"ipad"->1000)

    for((k, v)<- map) yield (k, v*0.9)

    //构建可变的Map
    val scores = scala.collection.mutable.Map("Scala"->7,"Hadoop"->8,"Akka"->9)

    //scores有"Hadoop"这个key的值，则返回value值，如果没有，则返回第二个参数的值
    val hadoopScore = scores.getOrElse("Hadoop",0)

    //增加元素
    scores += ("R"->9)
    //删除元素
    scores -= "Hadoop"

    //按照key值进行排序
    val scoreSort = scala.collection.immutable.SortedMap("Scala"->7,"Hadoop"->8,"Akka"->9)

    for((k,v)<-scoreSort){
      println("[k:"+k+",v:"+v+"]")
    }


  }
}
