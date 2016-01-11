package Study030


/**
  * 嵌套的case class
  * Created by liguodong on 2015/11/20.
  */

abstract class Item
case class Book(description: String, price: Double) extends Item
case class Bundle(description: String, price: Double, items: Item*) extends Item


object Demo {
  def main(args: Array[String]) {

    caseclass_nested(
      Bundle(
        "1111 Special's",
        30.0,
        Book("Scala for the Spark Developer", 69.95),
        Bundle(
          "Hadoop",
          40.0,
          Book("Hive",323),
          Book("Hbase",32.32)
        )
      )
    )

    caseclass_nested(
      Bundle(
        "1212 Special's",
        35.0,
        Book("Spark for the Impatient",39.95)
      )
    )

  }

  def caseclass_nested(person: Item) = person match{
    // _* 表示有多个，也可以表示没有
    //case Bundle(_, _, Book(desc,_), _*) => println("The first description is : " + desc)
    case Bundle(_, _,art @ Book(_, _), rest @ _*) => println(art.description + " : " + art.price)
    case _ => println("Oops!")
  }
}



