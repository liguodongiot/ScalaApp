package Study056


/**
 * Self Type
 * Created by liguodong on 2015/12/9.
 */
object Demo {
  def main(args: Array[String]) {


      class Outer{ outer =>
        val v1 = "Spark"
        class Inner{
          def printString = println(outer.v1)
        }
      }

      val c = new S2 with S1

      val out = new Outer
      val in = new out.Inner
      in.printString
  }
}


class Self{ self =>
  val tmp = "Scala"
  def foo = self.tmp + this.tmp
}

trait S1
class S2 { this:S1 => }

class S3 extends S2 with S1

trait T{ this:S1 => }
object S4 extends T with S1
