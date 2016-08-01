package Study052

/**
 * 路径依赖
 * Created by liguodong on 2015/12/8.
 */
object Demo {
  def main(args: Array[String]): Unit = {
    val outer = new Outer
    val inner = new outer.Inner
    val inner2: outer.Inner = new outer.Inner

    val o1 = new Outer
    val o2 = new Outer
    //val i:o2.Inner = new o1.Inner

    //类型投影o1.Inner和o2.Inner公用的父类Outer#Inner
    //o1.Inner 是 Outer#Inner 的子类
    val i:Outer#Inner = new o1.Inner

  }
}


//内部类
//内部类隐含持有外部类的实例，所以可以访问外部类的private
class Outer{
  private val x = 10
  class Inner{
    private val y = x + 10
  }
}