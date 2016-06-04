package Study037

/**
 * List的foldLeft foldRight sort操作
 * Created by liguodong on 2015/11/30.
 */
object Demo {
  def main(args: Array[String]) {
    //从左往右
    println((1 to 100).foldLeft(0)(_+_))

    //初始值类型和集合中的元素一致
    println( (0 /: (1 to 100) )(_+_) )

    //从右往左
    //5-100  4-(-95) 3-99 2-(-96) 1-98
    println((1 to 5).foldRight(100)(_-_))
    println(((1 to 5) :\ 100)(_-_))

    println((1 to 100).foldRight(100)(_+_))

    //排序的复杂度是线性的，比较高效。
    println(List(1,-3,4,2,6) sortWith (_ < _))
    println(List(1,-3,4,2,6) sortWith (_ > _))
  }
}
