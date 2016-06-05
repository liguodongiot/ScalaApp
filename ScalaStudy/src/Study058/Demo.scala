package Study058

import scala.io.{Source, BufferedSource}

/**
 * Abstract Type 抽象类型
 * Created by liguodong on 2015/12/9.
 */

trait Reader{
  //抽象类型可以有很多
  type In <: java.io.Serializable  //可以对抽象类型进行复杂的限制
  type Contents
  def read(in:In):Contents
}

class FileReader extends Reader{
  type In = String
  type Contents = BufferedSource
  def read(name:In) = Source.fromFile(name)
}


object Demo {
  def main(args: Array[String]) {
    val fileReader = new FileReader
    val content = fileReader.read("D:\\temp.txt")
    for (line <- content.getLines()) println(line)

    //java.nio.charset.MalformedInputException: Input length = 1
    //原因：编码不对
  }
}
