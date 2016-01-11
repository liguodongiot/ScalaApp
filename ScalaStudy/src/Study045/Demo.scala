package Study045

/**
  * Context Bounds
  * Created by liguodong on 2015/12/6.
  */
object Demo {
  def main(args: Array[String]) {
    val pair = new Pair_Ordering("Spark","Hadoop")
    println(pair.bigger)

    val pairInt = new Pair_Ordering(3,4)
    println(pairInt.bigger)

  }
}

class Pair_Ordering[T:Ordering](val first:T,val second:T){
  def bigger(implicit ordered: Ordering[T]) = {
    if(ordered.compare(first,second)>0) first else second
  }
}