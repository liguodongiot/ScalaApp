package Study064

/**
 * 隐式对象
 * Created by liguodong on 2015/12/9.
 */
abstract class Template[T]{
  def add(x:T,y:T):T
}

abstract class SubTemplate[T] extends Template[T]{
  def unit:T //返回T类型
}




object Demo {
  def main(args: Array[String]) {
    implicit object StringAdd extends SubTemplate[String]{
      def add(x: String,y:String):String = x concat y
      def unit: String = ""
    }

    implicit object IntAdd extends SubTemplate[Int]{
      def add(x:Int,y:Int):Int = x+y
      def unit:Int = 0
    }

    def sum[T](xs:List[T])(implicit m:SubTemplate[T]):T =
    if(xs.isEmpty) m.unit   //m是隐式对象
    else m.add(xs.head,sum(xs.tail))

    println(sum(List(1,2,3)))
    println(sum(List("a","b","c")))

    println(sum(List("Scala","Kafka","Spark")))
  }
}
