package Study032

/**
  * 基于模式匹配的List排序算法
  * Created by liguodong on 2015/11/23.
  */
object Demo {
  def main(args: Array[String]) {
    val bigData = List("Hadoop","Spark")
    val data = List(1,2,3,4)

    //右结合 可以不加括号
    val bigData_core = "Hadoop"::("Spark"::Nil)

    val data_Int = 1 :: 2 :: 3 :: 4:: Nil

    println(data.isEmpty)
    println(data.head)
    //1 （2，3,4）
    println(data.tail)
    println(data.tail.head)

    val List(a,b) = bigData
    println("a:"+a+" b:"+b)
    val x::y::rest = data
    println("x:"+x+" y:"+y+" rest:"+rest)

    val shuffleData = List(4,3,2,4,1,5,9,6)
    println(sortList(shuffleData))

    def sortList(list:List[Int]): List[Int] = list match {
      case List() => List()  //list为空，不排序
        ////list不为空,分为两部分
      case head :: tail => compute(head,sortList(tail))
    }

    //采用递归方式
    def compute (data:Int, dataSet : List[Int]) : List[Int]
    = dataSet match {
      case List() => List(data)
      //head为dataSet的第一个元素
      case head :: tail =>
        if(data <= head ) data :: dataSet
        else head :: compute(data, tail)
    }

  }
}
