package Study046

import scala.reflect._
import scala.reflect.runtime.universe._
/**
  * ClassTag/Manifest/ClassManifest/TypeTag
  * Created by liguodong on 2015/12/6.
  */

class A[T]

object Demo {
  def main(args: Array[String]) {
    arrayMake(1,2).foreach(println)

    arrayMake(1,2,3,4,5).foreach(println)
    println("===========")


    mkArray(42,12).foreach(println)
    mkArray("Japan","Brazil","Germany").foreach(println)

    println("===========")

    manif(List("Spark","Hadoop"))
    manif(List(1,2))
    manif(List("Scala",3))


    println("------~~~----")
//    manif2(List("Spark","Hadoop"))
//    manif2(List(1,2))
//    manif2(List("Scala",3))

    println("------~~~----")

    println("------~~~----")
    paramInfo(42)
    paramInfo(List(1, 2))

    println("===========")
    val m = manifest[A[String]]
    println(m)

    //@deprecated("Use scala.reflect.classTag[T] instead", "2.10.0")
    val cm = classManifest[A[String]]
    println(cm)

    val tt = typeTag[A[String]]
    println(tt)

    val ct = classTag[A[String]]
    println(ct)
  }

  //Manifest上下文界定
  def arrayMake[T:Manifest](first:T,second:T) ={
    val r = new Array[T](2); r(0) = first; r(1) = second;r
  }

  // @deprecated("Use scala.reflect.ClassTag (to capture erasures) or
  // scala.reflect.runtime.universe.TypeTag (to capture types) or both instead", "2.10.0")
  def arrayMake[T:Manifest](elems:T*) ={
    val r = Array[T](elems:_*);r
  }


  def mkArray[T : ClassTag](elems:T*) = Array[T](elems:_*)


  //@deprecated("Use scala.reflect.runtime.universe.TypeTag for subtype checking instead", "2.10.0")
  def manif[T](x:List[T])(implicit m:Manifest[T]) = {
    if(m<:<manifest[String])
      println("List strings")
    else
      println("Some other type")
  }


//  def manif2[T](x:List[T])(implicit m:TypeTag[T]) = {
//    if(m.tpe TypeTag[List[String]])
//      println("List strings")
//    else
//      println("Some other type")
//  }

  def paramInfo[T](x: T)(implicit tag: TypeTag[T]): Unit = {
    //val targs = tag.tpe match { case TypeRef(_, _, args) => args }
    val targs = tag.tpe match { case TypeRef(pre, sym, args) => (pre, sym, args) }
    println(s"type of $x has type arguments $targs")
  }

}


