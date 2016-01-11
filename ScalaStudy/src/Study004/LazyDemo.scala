package Study004

import scala.io.Source

/**
  * 2、延时加载
  * Created by liguodong on 2015/11/14.
  */
object LazyDemo {
  def main(args: Array[String]) {
    //变量或者常量加上lazy修饰之后，只有在第一次被使用时，才会被实例化
    lazy val file = Source.fromFile("E:/baby.txt")
    println("Over...")
    //for(line <- file.getLines()) println(line)
  }
}
