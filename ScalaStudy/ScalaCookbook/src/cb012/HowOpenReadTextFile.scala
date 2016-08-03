package cb012



/**
  * Created by liguodong on 2016/8/2.
  */
object HowOpenReadTextFile extends App {

  //Using the concise syntax
  import scala.io.Source
  val filename = "D:\\lilili.txt"
  for (line <- Source.fromFile(filename).getLines) {
    println(line)
  }


  val lines = Source.fromFile("D:\\lilili.txt").getLines.toList
  println(lines)

  val lines2 = Source.fromFile("D:\\lilili.txt").getLines.toArray
  lines.foreach(x=>print(x+" "))
  println


  val fileContents = Source.fromFile(filename).getLines.mkString
  println(fileContents)

  //Properly closing the file
  val bufferedSource = Source.fromFile("D:\\lilili.txt")
  for (line <- bufferedSource.getLines) {
    println(line.toUpperCase)
  }
  bufferedSource.close

  //Discussion

  //Leaving files open
  // leaves the file open
  for (line <- io.Source.fromFile("D:\\lilili.txt").getLines) {
    println(line)
  }
  // also leaves the file open
  val contents = io.Source.fromFile("D:\\lilili.txt").mkString

  println("contents:"+contents)


  //Automatically closing the resource
//  def using[A](r : Resource)(f : Resource => A) : A =
//  try {
//    f(r)
//  } finally {
//    r.dispose()
//  }
  object Control {
    def using[A <: { def close(): Unit }, B](resource: A)(f: A => B): B =
      try {
        f(resource)
      } finally {
        resource.close()
      }
  }

  import Control._
  using(io.Source.fromFile("D:\\lilili.txt")) { source => {
    for (line <- source.getLines) {
      println(line)
    }
  }
}


