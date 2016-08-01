package cb005



/**
 * Created by liguodong on 2016/7/4.
 */
object CallMethodSuperclass extends App{


  class Bundle

  class Activity{
    def onCreate(bundle: Bundle): Unit ={

    }
  }

  class WelcomeActivity extends Activity {
    override def onCreate(bundle: Bundle) {
      super.onCreate(bundle)
      // more code here ...
    }
  }

  ///////////////////////////////

  class FourLeggedAnimal {
    def walk { println("I'm walking") }
    def run { println("I'm running") }
  }

  class Dog extends FourLeggedAnimal {
    def walkThenRun {
      super.walk
      super.run
    }
  }
  val suka = new Dog
  suka.walkThenRun

  /////////////////////////////

  val c = new Child
  println(s"c.printSuper = ${c.printSuper}")
  println(s"c.printMother = ${c.printMother}")
  println(s"c.printFather = ${c.printFather}")
  println(s"c.printHuman = ${c.printHuman}")

  println("==================")
  val d = new cb005.Dog
  d.walkThenRun

  println("==================")
  val d2 = new cb005.Dog2
  d2.walkThenRun


}



trait Human {
  def hello = "the Human trait"
}
trait Mother extends Human {
  override def hello = "Mother"
}
trait Father extends Human {
  override def hello = "Father"
}

class Child extends Human with Mother with Father {
  def printSuper = super.hello
  def printMother = super[Mother].hello
  def printFather = super[Father].hello
  def printHuman = super[Human].hello
}



//the following code won’t compile because Dog doesn’t directly extend the Animal trait.
trait Animal {
  def walk { println("Animal is walking") }
}

class FourLeggedAnimal extends Animal {

  override def walk { println("I'm walking on all fours") }

}

class Dog extends FourLeggedAnimal {
  def walkThenRun {
    super.walk // works
    super[FourLeggedAnimal].walk // works
    //super[Animal].walk // error: won't compile
  }
}

class Dog2 extends FourLeggedAnimal with Animal{
  def walkThenRun {
    super.walk // works
    super[FourLeggedAnimal].walk // works
    super[Animal].walk // works
  }
}