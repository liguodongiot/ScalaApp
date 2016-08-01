package Study027

/**
  * Type/Array/List/Tuple模式匹配
  * Created by liguodong on 2015/11/20.
  */

object Demo {
  def main(args: Array[String]) {
    //类型匹配
    ArrayDemo.match_type(2)
    ArrayDemo.match_type("liguodong")
    ArrayDemo.match_type(Map("Scala"->"Spark","Java"->"JVM"))

    //数组匹配
    ArrayDemo.match_array(Array(1))
    ArrayDemo.match_array(Array(0,1))
    ArrayDemo.match_array(Array(0,1,2,3,4,5,6))
    ArrayDemo.match_array(Array(1,2,3,4,5,6))
    ArrayDemo.match_array(Array(0))
    //列表
    ListDemo.match_list(List(0))
    ListDemo.match_list(List(0,1))
    ListDemo.match_list(List(0,21,3,45,6))

    //元组
    TupleDemo.match_tuple((0,"Scala"))
    TupleDemo.match_tuple((2,0))
    TupleDemo.match_tuple((0,3,4,5,6))
  }

}


object ArrayDemo{

  def match_type(t:Any) = t match {
    case p: Int=>println("It is Integer")
    case p: String=>println("It is String,the content is " + t + " "+ p)
    //case m:Map[_, _] => m.foreach(println)
    case m:Map[k, v] => m.foreach(println)
    case _ => println("Unknown type!!!")
  }

  def match_array(arr:Any) = arr match{
    case Array(1) => println("Array：[" + "1]")
    case Array(x,y) => println("Array：[" + x + " " + y + "]")
    case Array(0,_*) => println("Array：" + "[0 ...]") //有1个或者多个元素，并且元素开头为0
    case _ => println("something else")
  }


}

object ListDemo{
  def match_list(ls : Any) = ls match {
    case 0 :: Nil => println("List:" + "[0]")
    case x :: y :: Nil => println("List:[" + x + " " + y + "]")
    case 0 :: tail => println("List:" + "[0 ...]")
    case _ => println("something else")
  }

}

object TupleDemo{
  def match_tuple(tuple : Any) = tuple match{
    case(0,_) => println("Tuple:" + "0")
    case(x,0) => println("Tuple:" + x)
    case _ => println("something else")
  }

}