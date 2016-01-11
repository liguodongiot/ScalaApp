package Study059


import java.io.File

import scala.io.Source


/**
 * 隐式转换和隐式参数
 * Created by liguodong on 2015/12/9.
 */

class RichFile(val file:File){
  def read = Source.fromFile(file.getPath()).mkString
}

object Context{
  //隐式转换
  implicit def file2RichFile(file:File) = new RichFile(file)  //File->RichFile
}

object Demo {
  def main(args: Array[String]) {
    import Context.file2RichFile
    println(new File("D:\\temp.txt").read)//File类没有read方法，将File隐式转换RichFile

    //1 to 3
  }
}
