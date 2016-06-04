package Study025

/**
  * 柯里化（Currying）
  * 柯里化指的是将原来接受两个参数的函数变成新的接受一个参数的函数的过程。
  * 新的函数 返回一个以 原有第二个参数 作为参数的函数。
  *
  * 柯里化常见的用途：进行参数的推导
  * Created by liguodong on 2015/11/20.
  */
object Demo {
  def main(args: Array[String]) {

    def multiple(x:Int, y: Int) = x * y

    def multipleOne(x:Int) = (y: Int) => x * y

    println(multipleOne(6)(7))

    //柯里化
    def curring(x: Int)(y: Int) = x * y  //同上的效果一样
    println(curring(6)(7))

    //柯里化常见的用途：进行参数的推导
    val a = Array("Hello","Spark")
    val b = Array("hello","spark")

    println( a.corresponds(b)(_.equalsIgnoreCase(_)) ) //看源码
  }
}
