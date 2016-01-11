package Study019

/**
  * 正则表达式
  * 正则表达式与模式匹配的Reg代码
  * Created by liguodong on 2015/11/18.
  */
object Demo {
  def main(args: Array[String]) {
    val regex="""([0-9]+) ([a-z]+)""".r
    val numPattern = "[0-9]+".r
    val numberPattern = """\s+[0-9]+\s+""".r

    //findAllIn方法返回遍历所有匹配项的迭代器
    for(matchString <- numPattern.findAllIn("99345 Scala,22298 Spark")) println(matchString)
    //99345   22298

    //找到首个匹配项
    println(numberPattern.findFirstIn("99ss java, 222 hadoop"))
    //Some( 222 )

    val numitemPattern="""([0-9]+) ([a-z]+)""".r

    val numitemPattern(num,item) = "99 hadoop"
    //num: String = 99
    //item: String = hadoop

    val line = "93459 spark"
    line match{
      case numitemPattern(num,blog) => println(num+"\t"+blog)
      case _ =>println("ohh...")
    }

  }
}
