package cb011

/**
  * Created by liguodong on 2016/7/31.
  */
object TraverseMap extends App {

  val ratings = Map("Lady in the Water"-> 3.0,
    "Snakes on a Plane"-> 4.0,
    "You, Me and Dupree"-> 3.5)

  for ((k,v) <- ratings) println(s"key: $k, value: $v")

  ratings.foreach {
    case(movie, rating) => println(s"key: $movie, value: $rating")
  }


  ratings.foreach(x => println(s"key: ${x._1}, value: ${x._2}"))

  //If you just want to use the keys in the map, the keys method returns an Iterable
  ratings.keys.foreach((movie) => println(movie))

  ratings.keys.foreach(println)

  println("===============")

  ratings.values.foreach((rating) => println(rating))

  println("===============")

  //Operating on map values
  var x = collection.mutable.Map(1 -> "a", 2 -> "b")

  println(x)

  val y = x.mapValues(_.toUpperCase)

  println(y)

  val map = Map(1 -> 10, 2 -> 20, 3 -> 30)

  println(map)

  val newMap = map.transform((k,v) => k + v)

  println(newMap)


}
