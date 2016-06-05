package Study060

/**
 * 隐式参数
 * Created by liguodong on 2015/12/9.
 */

object Context_Implicats{
  implicit val default:String = "Java"
}

object Param{

  def print(content:String)(implicit language:String): Unit ={
    println(language+":"+content)
  }
}


object Demo {
  def main(args: Array[String]) {
    Param.print("Spark")("Scala")

    import Context_Implicats._
    Param.print("Hadoop")
  }
}
