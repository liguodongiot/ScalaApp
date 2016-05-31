package Study008

/**
  * 类的主构造器以及私有构造器，构造器重载
  * Created by liguodong on 2015/11/15.
  */

object OOPInScala {
  def main(args: Array[String]) {
    val p = new Teacher
    p.name = "Spark"
    //p.age = 1
    //p.gender = "female"
    p.sayHello()

    val p2 = new Teacher("Scala")
    //p2.name = "Flink"
    p2.sayHello()

    /*----------------*/
    val st = new Student("Scala",11)
    println("st age:"+st.age)

    println("-------------")
    val st2 = new Student("Spark",12,"male")

    println("st2 age:" + st2.age)
    println("st2 gender: " + st2.gender)


  }
}
