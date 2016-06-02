package Study021

/**
  * 偏函数
  * Created by liguodong on 2015/11/19.
  */
object Demo {
  def main(args: Array[String]) {

    val data = List(1,2,3,4,5,6)

    //循环遍历集合中的每一个元素
    data.foreach(print _)
    println

    data.foreach(x => print(x+" "))
    println

    def sum(a: Int, b:Int, c:Int) = a+b+c

    println("sum is:"+sum(1,2,3))

    val fp_a = sum _
    println("sum is:"+fp_a(1, 2, 3))
    println("sum is:"+fp_a.apply(1, 2, 3))

    //偏函数
    val fp_b = sum(1, _: Int, 3)
    println("sum is:"+fp_b(2))
    println("sum is:"+fp_b(10))

    data.foreach(print _)
    println
    data.foreach(print)  //更加简明

  }
}
