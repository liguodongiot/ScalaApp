package Study003

/**
  * 1、
  * Created by liguodong on 2015/11/14.
  */
object TupleDemo {
  def main(args: Array[String]): Unit = {
    val triple = (100,"Scala","Spark")
    println(triple._1)
    println(triple._2)
    println(triple._3)
  }
}
