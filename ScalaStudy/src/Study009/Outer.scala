package Study009

/**
  * Created by liguodong on 2015/11/15.
  */
class Outer(val name:String) {
  outer =>
  class Inner(val name: String){
    def foo(b:Inner) = println("Outer: " + outer.name + " Inner: " + b.name)
  }

  class Inner2(val name: String){
    def foo(b:Inner2) = println("Outer: " + outer.name + " Inner: " + b.name)
  }

}
