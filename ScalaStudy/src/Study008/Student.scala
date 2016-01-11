package Study008

/**
  * 有参的类
  * 类构造器：内部所有的代码，除了方法，都会被执行。
  *
  * 如果不想使用默认的构造器，则需要加上private
  * class Student private (val name:String, val age:Int)
  *
  * Created by liguodong on 2015/11/15.
  */
class Student (val name:String, val age:Int) {
  println("This is the primary constructor!!!")
  var gender : String = _
  println("gender: " + gender)

  def this(name:String, age:Int, gender:String){
    this(name,age)
    this.gender = gender
  }



}
