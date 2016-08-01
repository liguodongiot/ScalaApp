package Study031

/**
  * Option使用
  * Created by liguodong on 2015/11/21.
  */
object Demo {
  def main(args: Array[String]) {
    val scores = Map("Alice" -> 99,"Spark"->100)

    scores.get("Alice") match{
      case Some(score) => println(score)
      case None => println("No score")
    }

    val alicesScore = scores.get("Alice")
    println(alicesScore.getOrElse("No Score"))

    println(scores.getOrElse("Alice","No Score"))

    println("------------")

    for(score <- scores.get("Alice")){
      println(score)
    }

    scores.get("Alice").foreach(println _)

    scores.get("Alice").filter(_.equals(None)).foreach(println _)

    println("==~~~==~~~===~~~==")
    scores.get("Scala").foreach(println _)

    scores.get("Scala").filter(!_.equals(None)).foreach(println _)
    println("==~~~==~~~===~~~==")
  }
}
