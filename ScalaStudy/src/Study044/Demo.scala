package Study044

/**
  * View Bounds
  *
  * Created by liguodong on 2015/12/6.
  */
object Demo {
  def main(args: Array[String]) {

    //求二者之间的较大值
    val pair = new Pair_NotPerfect("Spark","Hadoop")
    println(pair.bigger)

    //Int->RichInt（隐式转换）
    val pairInt = new Pair_NotPerfect(3,5)
    println(pairInt.bigger)

    //String->RichString(隐式转换) RichString中有（> < =）
    val pair_Better_String = new Pair_Better("Java","Scala")
    println(pair_Better_String.bigger)

    val pair_Better_Int = new Pair_Better(28,23)
    println(pair_Better_Int.bigger)


  }
}

//视图界定
class Pair_NotPerfect[ T <% Comparable[T] ](val first:T,val second:T){
  def bigger = if(first.compareTo(second)>0) first else second
}

class Pair_Better[T <% Ordered[T]](val first:T,val second:T){
  def bigger = if(first > second) first else second
}






