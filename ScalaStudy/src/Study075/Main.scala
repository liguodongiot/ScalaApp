package Study075

/**
 * 模式匹配下的for循环
 * Created by liguodong on 2015/12/15.
 */
object Main {
  def main(args: Array[String]) {
    for(i <- List(1,2,3,4,5)) {print(i+" ")}
    println
    //别名
    for(index@"Flink" <- List("Hadoop","Strom","Spark")){ println(index) }
    //元组
    for((language,"Hadoop") <- Set("Scala"->"Spark","Java"->"Hadoop")) println(language)
    //要求第二个元素是整数
    for((k,v:Int) <- List(("Spark"->5),("Hadoop"->"Big Data"))) { println(k) }
  }
}
