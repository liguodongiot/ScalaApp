package Study007

/**
  * Created by liguodong on 2015/11/14.
  */
class Person {
  //必须赋值操作
  private var age = 0
  //加1操作
  def increment(){ age += 1}
  //该方法返回当前值, 因为无参数，可以省略括号。
  def current = age

}
