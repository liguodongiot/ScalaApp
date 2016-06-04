package study001

/**
 * 表达式和值
 * Created by liguodong on 2016/6/4.
 */
object Demo {
  def main(args: Array[String]) {


    //可以通过val定义一个常量，亦可以通过var定义一个变量。推荐多使用常量。
    var helloWorld = "hello" + " world"
    println(helloWorld)

    val again = " again"
    helloWorld = helloWorld + again

    println(helloWorld)
  }
}
