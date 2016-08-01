package cb003

/**
 * Created by liguodong on 2016/6/28.
 */


object UsePatternMatchInMatchExpression extends App{

  case class Person(firstName: String, lastName: String)
  case class Dog(name: String)

  // trigger the constant patterns
  println(echoWhatYouGaveMe(0))
  println(echoWhatYouGaveMe(true))
  println(echoWhatYouGaveMe("hello"))
  println(echoWhatYouGaveMe(Nil))

  // trigger the sequence patterns
  println(echoWhatYouGaveMe(List(0,1,2)))
  println(echoWhatYouGaveMe(List(1,2)))
  println(echoWhatYouGaveMe(List(1,2,3)))
  println(echoWhatYouGaveMe(Vector(1,2,3)))

  // trigger the tuple patterns
  println(echoWhatYouGaveMe((1,2))) // two element tuple
  println(echoWhatYouGaveMe((1,2,3))) // three element

  // trigger the constructor patterns
  println(echoWhatYouGaveMe(Person("Melissa", "Alexander")))
  println(echoWhatYouGaveMe(Dog("Suka")))

  // trigger the typed patterns
  println(echoWhatYouGaveMe("Hello, world"))
  println(echoWhatYouGaveMe(42))
  println(echoWhatYouGaveMe(42F))
  println(echoWhatYouGaveMe(Array(1,2,3)))
  println(echoWhatYouGaveMe(Array("coffee", "apple pie")))
  println(echoWhatYouGaveMe(Dog("Fido")))
  println(echoWhatYouGaveMe(List("apple", "banana")))
  println(echoWhatYouGaveMe(Map(1->"Al", 2->"Alexander")))
  // trigger the wildcard pattern
  println(echoWhatYouGaveMe("33d"))



  def echoWhatYouGaveMe(x: Any): String = x match {
    // constant patterns
    case 0 => "zero"
    case true => "true"
    case "hello" => "you said 'hello'"
    case Nil => "an empty List"

    // sequence patterns
    case List(0, _, _) => "a three-element list with 0 as the first element"
    case List(1, _*) => "a list beginning with 1, having any number of elements"
    case Vector(1, _*) => "a vector starting with 1, having any number of elements"

    // tuples
    case (a, b) => s"got $a and $b"
    case (a, b, c) => s"got $a, $b, and $c"

    // constructor patterns
    case Person(first, "Alexander") => s"found an Alexander, first name = $first"
    case Dog("Suka") => "found a dog named Suka"

    // typed patterns
    case s: String => s"you gave me this string: $s"
    case i: Int => s"thanks for the int: $i"
    case f: Float => s"thanks for the float: $f"
    case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
    case as: Array[String] => s"an array of strings: ${as.mkString(",")}"
    case d: Dog => s"dog: ${d.name}"
    case list: List[_] => s"thanks for the List: $list"
    case m: Map[_, _] => m.toString
    // the default wildcard pattern
    case _ => "Unknown"
  }


  //similar
  /*
  case list: List[_] => s"thanks for the List: $list"
  case m: Map[_, _] => m.toString

  <==========>

  case m: Map[a, b] => m.toString
  case list: List[x] => s"thanks for the List: $list"
  */


  /////////////////////Discussion//////////////////////
  val test = new RandomNoiseMaker
  test.makeRandomNoise(RandomString("liguodong"))


  //Adding variables to patterns
  //variableName @ pattern

  def matchType(x: Any): String = x match {
    //case x: List(1, _*) => s"$x" // doesn't compile

    case x @ List(1, _*) => s"$x" // works; prints the list
    //case Some(_) => "got a Some" // works, but can't access the Some
    //case Some(x) => s"$x" // works, returns "foo"
    case x @ Some(_) => s"$x" // works, returns "Some(foo)"
    case p @ Person(first, "Doe") => s"$p" // works, returns "Person(John,Doe)"
  }

  println(matchType(List(1,2,3))) // prints "List(1, 2, 3)"
  println(matchType(Some("foo"))) // prints "Some(foo)"
  println(matchType(Person("John", "Doe"))) // prints "Person(John,Doe)"


  //Using Some and None in match expressions
  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  toInt("42") match {
    case Some(i) => println(i)
    case None => println("That wasn't an Int.")
  }


}

import java.io.File
sealed trait RandomThing
case class RandomFile(f: File) extends RandomThing
case class RandomString(s: String) extends RandomThing

class RandomNoiseMaker {
  def makeRandomNoise(t: RandomThing) = t match {
    case RandomFile(f) => println("playSoundFile(f)")//playSoundFile(f)
    case RandomString(s) => println("speak(s)")//speak(s)
  }
}

