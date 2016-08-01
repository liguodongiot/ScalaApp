package Study054

/**
 * 复合类型
 * Created by liguodong on 2015/12/8.
 */

trait Compound_Type1
trait Compound_Type2

class Compound_Type extends Compound_Type1 with Compound_Type2

object Demo {

  def compound_Type(x:Compound_Type1 with Compound_Type2) = {println("Compound Type in global method")}

  def main(args: Array[String]) {

    compound_Type(new Compound_Type1 with Compound_Type2)

    object compound_Type_object extends Compound_Type1 with Compound_Type2
    compound_Type(compound_Type_object)

    //别名
    type compound_Type_Alias = Compound_Type1 with Compound_Type2
    def compound_Type_Local(x:compound_Type_Alias) = println("Compound Type in local method")

    val compound_Type_Class = new Compound_Type
    compound_Type_Local(compound_Type_Class)

    //既是Compound_Type1 也是 Compound_Type2 同时写init()方法
    type  Scala = Compound_Type1 with Compound_Type2{ def init():Unit}

    def open(res:Scala) = res.init()
    open(new Compound_Type1 with Compound_Type2{def init()=println("init again")})
  }
}
