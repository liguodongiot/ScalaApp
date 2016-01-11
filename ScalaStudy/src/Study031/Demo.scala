package Study031

/**
  * Option使用
  * Created by liguodong on 2015/11/21.
  */
object Demo {
  def main(args: Array[String]) {
    val scores = Map("Alice" -> 99,"Spark"->100)
    scores.get("Ali1ce") match{
      case Some(score) => println(score)
      case None => println("No score")
    }
  }
}
