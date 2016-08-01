package Study010

/**
  * 单例对象与伴生对象
  *
  * 伴生对象的作用：
  *   1、非常方便类的构建
  *   2、也可以作为类的静态方法成员的一个集合
  *
  * Object对象类似于Java中的静态类，里边的所有成员都是静态的。
  * Created by liguodong on 2015/11/15.
  */
object Demo {
  def main(args: Array[String]) {
    println(University.newStudentNo)
    println(University.newStudentNo)
    println(new University().id)

    //不使用new时，实际上使用的是Object Array这个伴生对象来创建的数组
    val array = Array(1,2,3,4)
    val arrayNew = new Array[Int](10);

  }
}

//class University是object University的伴生类
//object University是class University的伴生对象
//这个类可以访问这个对象中的所有成员，包括private修饰的成员
class University{
  val id = University.newStudentNo

  private var number = 0

  def aClass(number:Int): Unit = {
    this.number += number
  }
}

object University{
  private var studentNo = 0
  def newStudentNo = {
    studentNo += 1
    studentNo  //最后一行就是函数的返回内容
  }
}