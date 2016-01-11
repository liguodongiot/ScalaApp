package Study008

/**
  * 1、无参的类
  * Created by liguodong on 2015/11/15.
  */
class Teacher {
  //name本身是私有的，但是它的setter方法是共有的
  var name : String = _
  private var age = 27
  private[this] var gender = "male"

  /**
    * 任何一个重载的构造器，都必须调用其他构造器，
    * 而其他构造器在最终形态上一定会调用主构造器
    * @param name
    */

  def this(name : String){
    //this为系统默认的构造器
    this
    this.name = name
  }

  def sayHello(): Unit ={
    println(this.name + " : " + this.age + " : " + this.gender)
  }

}
