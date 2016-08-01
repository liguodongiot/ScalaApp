package Study042

import scala.reflect.ClassTag

/**
  * Scala泛型类与泛型函数
  * Created by liguodong on 2015/12/5.
  */

object Demo {
  def main(args: Array[String]) {
    val triple = new Triple("Spark",3.15,3)
    val bigData = new Triple[String,String,Char]("Spark","Hadoop",'R')

    def getData[T](list:List[T]) = list(list.length/2)

    println(getData(List("Spark","Hadoop",'R')))      //1
    println(getData(List("Spark","Hadoop",'R',"Scala")))  //2

    val f = getData[Int] _ //只能输入整数了
    println(f(List(1,2,3,4,5,6,7,8)))

    def buildArray[T:ClassTag](len:Int) = new Array[T](len)
    println(buildArray[Int](5).toList)

      def foo[A,B](f: A => List[A],b:A) = f(b)


  }
}

class Triple[F,S,T](val first:F,val second:S,val third:T)
