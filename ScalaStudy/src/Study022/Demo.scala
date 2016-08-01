package Study022

/**
  * 闭包
  * Created by liguodong on 2015/11/19.
  */
object Demo {

  def main(args: Array[String]) {
    val data = List(1,2,3,4,5,6)
    var sum = 0
    data.foreach(sum += _)

    println(sum)

    def add(more: Int) = (x: Int) => x + more
    val a = add(1)  //(x: Int) => x + 1
    val b = add(9999) //(x: Int) => x + 9999
    println(a(10)) //11
    println(b(10)) //10009

  }

}
