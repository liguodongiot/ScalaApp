package Study043

/**
  * 类型变量Bounds
  * 类型变量的上界和类型变量的下界
  * Created by liguodong on 2015/12/5.
  */
object Demo {
  def main(args: Array[String]) {
    val pair = new Pair("Spark","Hadoop")
    println(pair.bigger)
  }
}


//class Pair[T](val first:T,val second:T)
//指定了上界   子类
class Pair[ T <: Comparable[T] ](val first:T,val second:T){
  def bigger = if(first.compareTo(second)>0) first else second
}

//制定了下界   R是T的父类
class Pair_Lower_Bound[T](val first:T,val second:T){
  def replaceFirst[R >: T](newFirst:R) = new Pair_Lower_Bound[R](newFirst,second)
}


