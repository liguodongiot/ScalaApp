package Study046

import scala.reflect.ClassTag

/**
  * ClassTag/Manifest/ClassManifest/TypeTag
  * Created by liguodong on 2015/12/6.
  */
class A[T]

object Demo {
  def main(args: Array[String]) {
    arrayMake(1,2).foreach(println)

    println("===========")
    mkArray(42,12).foreach(println)
    mkArray("Japan","Brazil","Germany").foreach(println)

    println("===========")

    manif(List("Spark","Hadoop"))
    manif(List(1,2))
    manif(List("Scala",3))

    println("===========")
    val m = manifest[A[String]]
    println(m)
    val cm = classManifest[A[String]]
    println(cm)
  }

  def arrayMake[T:Manifest](first:T,second:T) ={
    val r = new Array[T](2);r(0) = first;r(1) = second;r
  }

  def mkArray[T : ClassTag](elems:T*) = Array[T](elems:_*)


  def manif[T](x:List[T])(implicit m:Manifest[T]) = {
    if(m<:<manifest[String])
      println("List strings")
    else
      println("Some other type")
  }

}


