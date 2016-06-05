package Study055

/**
 * Infix Type
 * Created by liguodong on 2015/12/8.
 */
object Demo {
  def main(args: Array[String]) {

    //右结合
    object Log{ def >>: (data:String): Log.type = {println(data); Log}}
    "MapReduce" >>: "Spark" >>:Log


    val list = List()
    val newList = "A" :: "B" :: list
    println(newList)

    class Infix_Type[A,B]

    val infix:Int Infix_Type String = null

    val infix2: Infix_Type[Int,String] = null

    case class Cons(first:String,second:String)

    val case_class = Cons("one","two")
    case_class  match { case "one" Cons "two" => println("Spark!!!")}
  }
}
