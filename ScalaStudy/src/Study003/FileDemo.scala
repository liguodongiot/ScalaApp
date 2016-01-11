package Study003

import scala.io.Source

/**
  * 4、文件操作
  * Created by liguodong on 2015/11/14.
  */
object FileDemo {
  def main(args: Array[String]) {
    //val file = Source.fromFile("F:\\Log\\ccc.txt")
    //val file = Source.fromFile("F:/Log/ccc.txt")

    val file = Source.fromURL("http://spark.apache.org/")
    for(line <- file.getLines()) println(line)

  }
}
