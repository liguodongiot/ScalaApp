package Study061

/**
 * 隐式参数与隐式转换联合使用
 * Created by liguodong on 2015/12/9.
 */
object Demo {
  def main(args: Array[String]) {
    // bigger是一个泛型函数，并且是柯里化的，
    // 后面的的ordered隐式参数是一个函数，这个函数的参数是T，返回的类型是Ordered[T]
    def bigger[T](a:T,b:T)(implicit ordered:T => Ordered[T]) = if (ordered(a)>b) a else b

    println(bigger(4,2))
    println(bigger("Spark","Storm"))
  }
}
