package Study009

/**
  * 内部类
  * Created by liguodong on 2015/11/15.
  */
object OOPInScala {
  def main(args: Array[String]) {
    val outer1 = new Outer("Spark")
    val outer2 = new Outer("Scala")

    //Java中，内部类从属于外部类
    //Scala中，内部类从属于外部类的对象
    val inner1 = new outer1.Inner("liguodong")

    val inner2 = new outer2.Inner("likexin")

    inner1.foo(inner1)
    inner2.foo(inner2)

    val inner3 = new outer1.Inner2("么么哒")
    inner3.foo(inner3)

  }
}
