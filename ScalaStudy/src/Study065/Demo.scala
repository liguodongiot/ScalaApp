package Study065

import java.io.File

import scala.io.Source

/**
 * 隐式转换操作规则
 * Created by liguodong on 2015/12/9.
 */
class RicherFile(val file:File){
  def read = Source.fromFile(file.getPath()).mkString
}

class File_Implicits(path:String) extends File(path)

//伴生对象中隐式转换
object File_Implicits{
  implicit def file2RichFile(file:File) = new RicherFile(file)
}


object Demo {
  def main(args: Array[String]) {
    //没有import是因为类可以访问伴生对象里面的所有内容
    println(new File_Implicits("D:\\temp.txt").read)
  }
}
