package Study049

import java.util

/**
  * Variance
  * Created by liguodong on 2015/12/7.
  */
class Person
class Student extends Person
class C[+T](val args:T)

class S[+T](arg:T) extends C[T](arg)

trait Friend[-T]{
  def makeFriend(somebody:T)
}

object Demo {
  def makeFriendWithYou(s:Student, f:Friend[Student]){
    f.makeFriend(s)
  }

  def main(args:Array[String]): Unit ={
    val value:C[Person] = new C[Student](new Student)


    //Java
    //List<? extends Object> list = new ArrayList<String>()
    //Scala
    val list:List[_ <: Any] = List[String]("Spark")
  }

}
