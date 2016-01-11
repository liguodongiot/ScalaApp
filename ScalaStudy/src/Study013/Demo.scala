package Study013

/**
  * 抽象类，抽象字段，抽象方法
  * Created by liguodong on 2015/11/16.
  */
object Demo {
  def main(args: Array[String]) {
    val teacher = new Teacher("Spark")
    teacher.teach
    println("teacher.id:"+teacher.id)
    println("teacher.name:"+teacher.name)
    println("teacher.age:"+teacher.age)
  }
}

class ClassTeacher{
  //具体类声明时必须要赋值（要么具体指，要么使用占位符）
  //val必须有具体的值，不可使用占位符。
  var id: Int = _

}

//抽象类
abstract class SuperTeacher(val name: String){
  //字段声明时不给字段赋值表名是抽象字段
  var id : Int
  var age: Int
  //不写方法实现体表明是抽象方法
  def teach
}



//实现抽象类
class Teacher(name:String) extends SuperTeacher(name){

  override var id = name.hashCode
  override var age = 29

  override def teach{
    println("Teaching!!!")
  }
}
