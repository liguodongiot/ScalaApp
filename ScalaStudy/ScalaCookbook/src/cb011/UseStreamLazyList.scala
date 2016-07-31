package cb011

/**
  * Created by liguodong on 2016/7/31.
  */
object UseStreamLazyList extends App{

  val stream2 = 1 #:: 2 #:: 3 #:: Stream.empty

  val stream = (1 to 100000000).toStream

  println(stream.head)  //Int = 1

  println(stream.tail)  //scala.collection.immutable.Stream[Int] = Stream(2, ?)

  println(stream.take(3))

  println(stream.filter(_ < 200)) //scala.collection.immutable.Stream[Int] = Stream(1, ?)

  println(stream.filter(_ > 200)) //scala.collection.immutable.Stream[Int] = Stream(201, ?)

  println(stream.map { _ * 2 })   //scala.collection.immutable.Stream[Int] = Stream(2, ?)

  val list = (1 to 100000000).toStream
  stream(0) // returns 1
  stream(1) // returns 2
  // ...
  stream(10) // returns 11

}
