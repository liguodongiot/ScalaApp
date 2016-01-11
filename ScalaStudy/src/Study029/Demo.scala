package Study029

/**
  * case class 和 case object
  * Created by liguodong on 2015/11/20.
  */

abstract class Person
case class Student(age: Int) extends Person
case class Worker(age: Int,salary: Double)  extends Person
case object Shared extends Person

object Demo {
  def main(args: Array[String]) {

    caseOps(Student(19))
    caseOps(Worker(19,4333))
    caseOps(Shared)

    val worker1 = Worker(23,543.02)
    val worker2 = worker1.copy(salary = 19.95)
    val worker3 = worker1.copy(age = 30)
    val worker4 = worker1.copy()

    caseOps(worker1)
    caseOps(worker2)
    caseOps(worker3)
    caseOps(worker4)
  }

  def caseOps(person:Person) = person match{
    case Student(age) => println("I am " + age +" years old.")
    case Worker(_, salary) => println("Wow,I got "  + salary)
    case Shared => println("No baby")
  }

}




