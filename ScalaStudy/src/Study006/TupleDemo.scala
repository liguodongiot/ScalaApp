package Study006

/**
  * 2、Tuple-->一种非常重要的数据结构
  * Created by liguodong on 2015/11/14.
  */
object TupleDemo {
  def main(args: Array[String]) {
    val tuple = (1,2,3,5,1001,"Jason","Mark")
    //访问元素
    val third = tuple._3
    println(third)

    val (first,second,thirds,fourht,fifth,sixth,seren) = tuple
    println("first:"+first+",fifth:"+fifth)


    //如果不需要改值的话，需要使用占位符
    val (f, s, _, _, _,_,_) = tuple
    println("f:"+f+",s:"+s)

    //遍历字符串是否是大写，大写放入一个集合，其他的另外一个集合
    val (upper,lower) = "Rocky Spark".partition(_.isUpper)
    println("[upper:"+upper+",lower:"+lower+"]")



  }
}
