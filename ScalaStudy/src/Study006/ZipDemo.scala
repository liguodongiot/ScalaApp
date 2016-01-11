package Study006

/**
  * 3、zip/zipAll
  * Created by liguodong on 2015/11/14.
  */
object ZipDemo {
  def main(args: Array[String]) {
    val symbols = Array("[","-","]")
    val counts = Array(2,5,2)
    //拉链操作
    val pairs = symbols.zip(counts)

    for((x,y) <- pairs) print(x*y+" ")
    println

    //会舍弃多余的数据
    val numbers = Seq(0,1,2,3,4)
    val service = List(0,1,2,3,4,5)
    println(numbers zip service)
    val temp = numbers zip service
    for((x,y)<-temp) print(x*y+" ")
    println

    //会对没有的数据进行补全操作
    val A = List(1,2,3)
    val B = List('a','b')
    val C = List(2)
    val fullA = 0
    val fullB = '_'
    val fullC = 0
    print(A.zipAll(B,fullA,fullB))
    println()
    print(B.zipAll(C,fullB,fullC))
    println()

  }
}
