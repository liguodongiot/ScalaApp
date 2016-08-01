package cb011

/**
  * Created by liguodong on 2016/8/1.
  */
object UseRange {

  println(1 to 10)

  println(1 until 10)

  println(1 to 10 by 2)

  println( 'a' to 'c')

  //you can use ranges to create and populate sequences:
  val x = (1 to 10).toList
  println(x)
  
}
