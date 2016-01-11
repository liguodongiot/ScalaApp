package Study007

/**
  * 面向对象编程基础
  * Created by liguodong on 2015/11/14.
  */
object HelloOOP {
  def main(args: Array[String]) {
    val person = new Person()//有无括号都可以
    person.increment()
    println(person.current)

    person.increment //无参数，可以省略括号
    person.increment
    println(person.current)

    val student = new Student
    student.age = 1 //赋值时，是age_函数
    println(student.age)//读取时，是age函数

    //val默认只有getter方法，无setter方法。
    //student.name = "Spark"
    println(student.name)

    println(student.priage)//自定义的setter方法
  }
}
