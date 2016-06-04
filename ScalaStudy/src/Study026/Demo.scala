package Study026

/**
  * 模式匹配
  * Created by liguodong on 2015/11/20.
  */

object Demo {
  def main(args: Array[String]) {

    //case左侧可以是变量，也可以是条件表达式。
    var data = 30
    data match{
      case 1 => println("First")  //Scala不需要写break或return结束case分支
      case 2 => println("Second")
      case _ => println("Not Known Number")
    }

    data = 2

    val result = data match{
      //val i = data
      case i if i == 1 => "The First"
      //val number = data
      case number if number == 2 =>"The Second " + number
      case _ => "Not Known Number"
    }
    println(result)

    // ("Spark !" foreach...)等价于("Spark !".foreach...)
    "Spark !".foreach{ c => println(
    c match{
      case ' ' => "space"
      case ch => "Char: " + ch
    }
    )}

    "Spark !" foreach{ c => println(
      c match{
        case ' ' => "space"
        case ch => "Char: " + ch
      }
    )}
  }
}
