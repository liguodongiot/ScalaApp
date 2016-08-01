val map = Map("book"->10,"gun"->18,"ipad"->1000)

for((k, v)<- map) yield (k, v*0.9)
map


val scores = scala.collection.mutable.Map("Scala"->7,"Hadoop"->8,"Akka"->9)
val hadoopScore = scores.getOrElse("Hadoop",0)

scores += ("R"->1001)
scores -= "Hadoop"


val scoreSort = scala.collection.immutable.SortedMap("Scala"->7,"Hadoop"->8,"Akka"->9)


//-----------------
val tuple = (1,2,3,5,1001,"Jason","Mark")

val third = tuple._3

val (first,second,thirds,fourht,fifth,sixth,seren) = tuple

val (f, s, _, _, _,_,_) = tuple

"Rocky Spark".partition(_.isUpper)

//-----------------
val symbols = Array("[","-","]")
val counts = Array(2,5,2)

val pairs = symbols.zip(counts)

for((x,y) <- pairs) print(x*y)