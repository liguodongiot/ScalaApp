package Study079

import scala.reflect.runtime.universe.typeOf

/**
 * 单例及单例背后的链式表达式
 * Created by liguodong on 2015/12/15.
 */

object Scala
class Java
class JVM{def method1:this.type = this}
class JVM_Language extends JVM {def method2:this.type = this }

object Main {
  def main(args: Array[String]) {
    println(Scala.getClass)
    println(typeOf[Scala.type])

    val java1 = new Java
    val java2 = new Java
    //每个实例对象都有唯一的单例
    println(typeOf[java1.type])
    println(typeOf[java2.type])


    val content:java1.type = java1
    //val content2:java1.type = java2

    val jvm = new JVM_Language
    println(jvm.method1)
    println(jvm.method1.method2)
    //链式表达式
    jvm.method1.method2


  }
}
