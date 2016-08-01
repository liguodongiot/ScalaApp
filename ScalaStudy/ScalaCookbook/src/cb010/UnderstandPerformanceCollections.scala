package cb010

/**
  * Created by liguodong on 2016/7/24.
  */
object UnderstandPerformanceCollections extends App{

  var v = Vector[Int]()
  for (i <- 1 to 50000) v = v :+ i
}
