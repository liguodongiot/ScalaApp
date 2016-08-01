package Study018

import java.io.{File, PrintWriter}

import scala.io.{/*StdIn,*/ Source}

/**
  * 文件的读取写入操作
  * Created by liguodong on 2015/11/18.
  */
object Demo {
  def main(args: Array[String]) {
    //读取
   /* val file = Source.fromFile("D:\\lilili.txt")
    for(line <- file.getLines()){ println(line)}
    file.close()*/

    ///////////
   val webFile = Source.fromURL("https://www.baidu.com/")
    webFile.foreach(print(_))
    webFile.close()

    //写入
    //没有指明表示当前路径
    val writer = new PrintWriter(new File("test.txt"))
    for(i <- 1 to 100) writer.println(i)
    writer.close()

    //打印到控制台
   /* println("请说出你的心里话：")
    val line = Console.readLine() //过时了
    //val line = StdIn.readLine
    println("谢谢你哟，么么哒。" + line)*/

  }
}
