package Study038

/**
 * List的伴生对象的操作方法
 * apply make range
 * unzip flatten contact map2
 * Created by liguodong on 2015/11/30.
 */
object Demo {
  def main(args: Array[String]) {
    println(List.apply(1,2,3))
    //第一个参数是次数，第二个参数是重复的元素
    println(List.fill(5)(3))

    println(List.fill(2,5)(3))

    println(List.range(1,5))
    //（9~1）步长是-3
    println(List.range(9,1,-3))

    val zipped = "abcde".toList zip List(1,2,3,4,5)
    println(zipped)
    println(zipped.unzip)

    //集合的组拼
    println(List(List('a','b'),List('c'),List('d','e')).flatten)

    println(List.concat(List(),List('b'),List('c')))

    //@deprecated("use `(xs, ys).zipped.map(f)` instead of `List.map2(xs, ys)(f)`", "2.8.0")
    //println(List.map2(List(10,20),List(10,10))(_ * _))  //List(100,200)
    println( (List(10,20),List(10,10)).zipped.map(_*_) )

  }
}
