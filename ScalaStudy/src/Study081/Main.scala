package Study081

/**
 * List的构造是类型约束逆变、协变、下界
 * Created by liguodong on 2015/12/15.
 */
abstract class Big_Data
class Hadoop extends Big_Data
class Spark extends Big_Data


object Main {
  def main(args: Array[String]) {
    //hadoop: List[Hadoop] = List(Study081.A$A2$A$A2$Hadoop@1d55327)
    val hadoop = new Hadoop :: Nil

    //big_Data: List[Big_Data] = List(Study081.A$A2$A$A2$Spark@84eb4e, Study081.A$A2$A$A2$Hadoop@1d55327)
    val big_Data = new Spark :: hadoop
  }
}
