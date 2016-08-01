package Study003

/**
  * 2、
  * Created by liguodong on 2015/11/14.
  */

object ArrayDemo {
  def main(args: Array[String]) {
    val array = Array(1,2,3,4,5)
    //这种写法比较繁琐
    for(i <- 0 until array.length){
      print(array(i)+" ")
    }
    println()

    //常用
    for(elem <- array) print(elem+" ")

  }
}
