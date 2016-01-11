package Study033

/**
  * List一阶函数的操作
  * Created by liguodong on 2015/11/24.
  */
object Demo {
  def main(args: Array[String]) {

    println(List(1,2,3,4):::List(4,5,6,7,8):::List(10,11))
    println(List(1,2,3,4):::(List(4,5,6,7,8):::List(10,11)))
    println(List(1,2,3,4).length)

    val bigData = List("Hadoop","Spark","Kafka","JStorm")
    println(bigData.last)   //最后一个元素
    println(bigData.init)   //除了最后一个元素，其他所有元素的集合
    println(bigData.reverse)  //反转
    println(bigData)

    println(bigData take 2)     //取前两个元素
    println(bigData drop 2)     //去除前两个元素
    println(bigData splitAt 3)  //分成两部分，前三个一组，后面所有元素一组
    println(bigData apply 2)    //第二个元素，从零开始
    println(bigData apply 1)    //第一个元素

    println(bigData(2))         //第二个元素

    val data = List('a','b','c','d','e','f')
    println(data.indices)   //所有元素的索引
    println(data.indices zip data)    //两个集合进行拉链操作
    println(data.toString())
    println(data.mkString("[", ",", "]"))
    println(data.mkString(" "))
    println(data.mkString)

    val buffer = new StringBuilder
    data addString (buffer, "(", ";;", ")")
    println(buffer)

    val buffer2 = new StringBuilder
    data.addString(buffer2,"["," : ","]")
    println(buffer2)
    println(data)

    val array = data.toArray
    println(array.toList)

    val new_array = new Array[Char](10)
    data.copyToArray(new_array,3) //复制数据到new_array，从new_array第3个元素开始
    new_array.foreach(print)
    println

    val iterator = data.toIterator
    println(iterator.next())
    println(iterator.next())

  }
}
