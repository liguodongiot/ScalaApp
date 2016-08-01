package Study023

import scala.math._

/**
  * 高阶函数(****)
  * Created by liguodong on 2015/11/19.
  */

object Demo {
  def main(args: Array[String]) {
    (1 to 9).map("*" * _).foreach(println _)
    //打印偶数
    (1 to 9).filter(_ % 2 == 0).foreach(println)

    //求和
    println((1 to 5).reduceLeft(_ + _))

    //1~9相乘
    println((1 to 5).reduceLeft(_ * _))

    //分割单词，然后按照单词长度排序，并且依次打印出来。
    "Spark is the most exciting things happening in big data today"
      .split(" ").sortWith( _.length < _.length).foreach(println)

    //高阶函数一个很重要的特征就是将函数作为一个函数的参数

    //函数的参数是函数是因为在Scala中函数是一等公民，他可以向变量和常量一样，
    //作为参数传递给我们的函数



    val fun = Math.ceil _ //向上取整

    val temp = ceil _

    val num = 3.14

    println("fun:"+fun(num))
    
    //函数作为参数
    Array(3.14, 1.42, 2.0).map(fun).foreach(println)
    Array(3.14, 1.42, 2.0).map(fun).foreach(x => print(x+" "))
    Array(3.14, 1.42, 2.0).map(fun).foreach(x => print(x + 1))
    println("\n------")

    //匿名函数
    val triple = (x: Double) => 3 * x

    Array(3.14, 1.42, 2.0).map( (x: Double) => 3 * x).foreach(x => print(x+" "))
    println("\n------")
    Array(3.14, 1.42, 2.0).map{ (x: Double) => 3 * x }.foreach(x => print(x+" "))
    println("\n------")

    Array(3.14, 1.42, 2.0).map( (x: Double) => 3 * x).map(fun).filter(_%2==0).foreach(x => print(x+" "))
    println("\n------")

    //高阶函数
    def high_order_functions( f:(Double) => Double ) = f(0.25)

    println(high_order_functions(Math.ceil _))

    println(high_order_functions(Math.sqrt _))

    def mulBy(factor : Double) = (x: Double)=> factor * x

    val quintuple = mulBy(5) //5 * x

    println(quintuple(20)) //5 * 20

    //0.25*3
    println( high_order_functions( (x: Double) => 3*x) )

    high_order_functions((x) => 3*x)
    high_order_functions(x => 3*x)
    high_order_functions( 3 * _ )

    val fun2 = 3 * ( _ : Double )

    val fun3:( (Double) => Double ) = 3 * _

    val fun4:(Double) => Double = 3 * _

    println(fun2(5))
    println(fun3(3))
    println(fun4(3))

  }
}
