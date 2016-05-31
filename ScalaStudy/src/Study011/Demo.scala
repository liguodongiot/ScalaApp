package Study011

/**
  * Class中的apply与Object中的apply
  * Created by liguodong on 2015/11/15.
  */
object Demo {
  def main(args: Array[String]) {
    val salary = Array(1,2,3,4,5)
    val a = ApplyTest()
    a.haveATry

    println("----------")
    val app = new ApplyTest
    app.haveATry
    println(app)

  }
}

class ApplyTest{
  def apply() = println("I am into Spark so much!!!")

  def haveATry ={
    println("Have a try on apply!")
  }
}

object ApplyTest{
  //伴生对象复写apply方法
  def apply() ={
    println("I'm into Scala so much!!!")
    new ApplyTest//返回值
  }
}



