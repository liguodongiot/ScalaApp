package Study048

/**
  * 类型约束
  * Created by liguodong on 2015/12/6.
  */

object Demo {

  def main(args: Array[String]) {
    //A =:= B   //表示A类型等同于B类型
    //A <:< B   //表示A类型是B类型的子类型
    //A <%< B   //表示A能否被视图隐式转换为B
    def rocky[T](i:T)(implicit ev:T <:< java.io.Serializable): Unit ={
      print("Life is short,you need spark!!!")
    }

    rocky("Spark")

    //rocky(100)
  }
}
