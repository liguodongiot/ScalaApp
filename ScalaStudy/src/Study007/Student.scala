package Study007

/**
  * Created by liguodong on 2015/11/14.
  */
class Student {
  //scala中会默认帮我们生成setter/getter方法
  var age = 0
  //常量默认只有getter方法
  val name = "Scala"

  private var priAge = 0
  def priage = priAge //getter方法

  //对象私有字段
  //这个字段属于当前对象私有的属性，限定为该属性只能为当前对象所有，不能够为当前对象的类所在的方法所使用
  private[this] var pricur = 0

  //在这个方法中，访问了对象的私有属性-->合法
  def isYounger(other: Student) = priAge < other.priAge

}
