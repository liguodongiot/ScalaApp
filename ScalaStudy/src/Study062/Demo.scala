package Study062

/**
 * 上下文界定
 * Created by liguodong on 2015/12/9.
 */

//主构造器有两个参数
class Pair_Implicits[T:Ordering](val first:T,val second:T){

  def bigger(implicit ordered:Ordering[T]) =
    if(ordered.compare(first,second)>0) first else second
}

class Pair_Implicitly[T:Ordering](val first:T,val second:T){

  def bigger = if(implicitly[Ordering[T]].compare(first,second)>0) first else second
}

class Pair_Implicity_Ordered[T:Ordering](val first:T,val second:T){
  def bigger = {
    import  Ordered._
    if(first > second) first else second
  }
}

object Demo {
  def main(args: Array[String]) {

    println(new Pair_Implicits(7,9).bigger)
    println(new Pair_Implicitly(7,9).bigger)

    println(new Pair_Implicity_Ordered(7,9).bigger)
  }
}
