package Study063

import java.io.File

import scala.io.Source

/**
 * 隐式类
 * Created by liguodong on 2015/12/9.
 */
object Context_Helper{

  implicit class FileEnhancer(file:File){
    def read = Source.fromFile(file.getPath()).mkString
  }

  implicit class Op(x:Int){
    def add(second:Int) = x + second
  }
}


object Demo {
  def main(args: Array[String]) {
    import Context_Helper._
    println(1.add(2))
    println(new File("D:\\temp.txt").read)
  }
}
