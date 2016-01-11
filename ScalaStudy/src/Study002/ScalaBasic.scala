package Study002

import java.io.File

import scala.io.StdIn

/**
  * Created by liguodong on 2015/11/13.
  */
object ScalaBasic {

  def dowhile(): Unit ={
    var line = ""
    do {
      //line = readLine()
      line = StdIn.readLine()
      if(line!="") println("Read:" + line)
    } while (line != "")
  }

  def max(x:Int,y:Int):Int = {
    if(x>y) x
    else y
  }

  def Test01(arg: Array[String]): Unit ={
    val file = if(!arg.isEmpty) arg(0) else "spark.txt"
    println(file)
  }

  def TestFor(): Unit ={
    for(i <-1 to 10){
      print(i+" ")
    }
    println()
    for(i <-1.to(10)) print(i+"-")

    //增强for循环
    println()
    val files = new File(".").listFiles()
    for(file <- files)
      println(file)

  }

  def TestException(): Unit ={
    val n = 99
    try{
      val half = if(n%2 == 0) n/2 else
        throw  new RuntimeException("TestException @=@=@")
    }catch {
      case e :Exception => println("The Exception is:"+e.getMessage);
    }finally {
      println("总是会被执行")
    }

  }

  def main(args: Array[String]): Unit = {
    //dowhile() //无参数的话，可以不用加括号

    //println(max(100,200))

    //Test01(args)

    //TestFor

    TestException

  }
}
