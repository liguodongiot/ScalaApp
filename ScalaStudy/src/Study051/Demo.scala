package Study051

/**
 * 链式调用
 * Created by liguodong on 2015/12/8.
 */

class Animal {
  //Scala中任何类对象都有一个type属性
  def breathe : this.type  = this
}

class Cat extends Animal{
  def eat : this.type = this
}

object Demo {
  def main(args: Array[String]) {
    val cat = new Cat //this指向的是cat对象
    cat.breathe.eat //cat对象中有eat方法，所以可以链式调用
  }
}
