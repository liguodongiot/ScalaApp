package Study012

/**
  * 超类的构造方法
  * 重写字段
  * 重写方法
  * Created by liguodong on 2015/11/15.
  */
object Demo {

  def main(args: Array[String]) {

    val w = new Worker("Spark",88,1000)

    println("School:" + w.school)
    println("Salary:" + w.salary)
    println("oo:" + w.toString)
    println("age:" + w.age)
  }
}

//父类
class Person(val name: String, var age: Int){
  println("The primary constructor of Person...")
  val school = "BJ University"
  def sleep = "8 hours"

  //重写toString方法
  override def toString = "I am a Person!!!"
}

//子类
class Worker(name: String, age: Int, val salary :Long)
  extends Person(name,age){

  println("This is a subclass of Person, Primary constructs of Works...")

  //重写字段
  override val school = "Spark University"

  override  def toString = "I am a work!!!"+super.sleep
}
