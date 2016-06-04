package Study035

/**
 * 对List的map，flatMap实战
 * 对List的foreach，filter实战
 * Created by liguodong on 2015/11/30.
 */
object Demo {

  def main(args: Array[String]) {
    println(List(1,2,3,4,5) map (_ +1))
    val data = List("Scala","Hadoop","Spark")
    println(data map (_.length))
    println(data.map(_.toList))
    println(data map (_.toList.reverse.mkString))

    println(data.flatMap(_.toList))


    println(List.range(1,10)) //1~9
    println(List.range(1,1))  //()
    println(List.range(1,2))  //(1)

    //                               1                 1
    //                               2                 2       1     2 1
    println(List.range(1,10) flatMap(i => List.range(1,i) map (j => (i,j)) ) )

    var sum = 0
    List(1,2,3,4,5) foreach (sum += _)
    println("Sum: " + sum)

    println(List(1,2,3,4,5,6,7,8,9,10) filter (_ % 2 == 0))
    println(data filter(_.length==5))
  }

}
