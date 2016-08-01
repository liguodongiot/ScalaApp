package Study003

/**
  * 3、
  * Created by liguodong on 2015/11/14.
  */
object MapDemo {
  def main(args: Array[String]) {

    val args = Map("Jason"->1001,"Spark"->1002)

    for((k,v)<- args){
      println("Key is "+k+", Value is "+ v+".")
    }

    //如果不想使用value，就用占位符。
    for((k,_) <- args){
      println("Key is "+k+".")
    }

    //如果不想使用key
    for((_,v) <- args){
      println("Value is "+v+".")
    }

  }
}
