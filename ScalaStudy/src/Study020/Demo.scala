package Study020

import scala.io.Source

/**
  * 本地函数
  * 作为一等公民的函数
  * Created by liguodong on 2015/11/19.
  */
object Demo {


  def processData(filename:String,width:Int): Unit ={
    //本地函数：外部不可以访问，同时本地函数可以访问外部传进来的数据
    def processLine(line:String): Unit ={
      if(line.length > width) println(filename+": "+line)
    }

    val source = Source.fromFile(filename)
    for(line <- source.getLines()) processLine(line)
  }

  def main(args: Array[String]) {
    val width = args(0).toInt
    for(arg <- args.drop(1))
      processData(arg,width)

    //函数作为Scala中的一等公民,把函数当做一个变量
    var increase = (x:Int)=>x+1 //匿名函数
    println("one:"+increase(10))
    //当函数作为一个变量是，可以被赋与其它的值
    increase = (x:Int) =>x+999
    println("two:"+increase(10))

    val someNumbers = List(-11,-10,2,-5,0,52,10)
    //对集合中的每个元素进行迭代
    someNumbers.foreach((x:Int) => print(x+" "))
    println()
    //过滤出大于0的元素
    val num = someNumbers.filter((x:Int) => x>0)
    someNumbers.filter((x) => x>0) //可以省略掉类型
    someNumbers.filter(x => x>0)
    someNumbers.filter(_ > 0)     //如果只有一个参数可以用占位符

    num.foreach((x:Int) => print(x+" "))
    println()


    val f = (_ : Int) + (_ : Int)
    println(f(5,10))

  }


}
