package Study005

import scala.collection.mutable.ArrayBuffer

/**
 * Created by liguodong on 2016/5/29.
 */
object ScalaInAction {
  def main(args: Array[String]) {

    val s = Array("Hello","World");

    for(elem <- s) println(elem + "...")

    val ob = println("李国冬")


    s(0)="good night"

    val test = println(s(0))

    for(elem <- s) println(elem + "...")

    val nums = new Array[Int](10)

    val a = new Array[String](10)


    val b = ArrayBuffer[Int]()
    b += 1
    b += (1,2,3,5)

    b ++= Array(8, 12, 13)

    b.trimEnd(5)

    println(b)

    //在2的位置上插入6
    b.insert(2,6)
    println(b)

    //在2的位置上插入7,8,9
    b.insert(2,7,8,9)
    println("[2 insert 7 8 9]:"+b)

    //移除2位置上的元素
    b.remove(2)
    println("[2 remove]:"+b)

    b.remove(2,3)
    println("[2 remove 3 position]:"+b)

    val c = b.toArray
    println("b:"+b)
    for(ctemp <- c){
      print(ctemp+":")
    }
    println


    val d = Array(2,3,5,8,11)
    //数组中每个元素*2
    val result = for(elem <- d) yield 2 * elem

    for(tempResult <- result){
      print(tempResult+":")
    }

    println

    //数组中的所有偶数*2
    val resultOdd = for(elem<-d if(elem%2 ==0)) yield 2*elem

    for(tempResultOdd <- resultOdd){
      print(tempResultOdd+":")
    }
    println

    //生产环境中的使用方式（_表示占位符）
    val resultEnd = d.filter(_ % 2 == 0).map(2 * _)

    for(tempResultEnd <- resultEnd){
      print(tempResultEnd+":")
    }
    println

    Array(1,2,3,4,5).sum

    ArrayBuffer("Mark","Jason","Tony","s","Chinses").max

    val e = Array(4,5,1,3)
    val bSorted = e.sorted
    println("bSorted:"+bSorted.toList)


    val f = Array(100,2,3,7,4)

    scala.util.Sorting.quickSort(f)
    println("Sort:"+f.toList)

    //分隔符
    //f.mkString(" and ")
    println("mkString:"+f.mkString(" and "))

    //f.mkString("<", ",", ">")
    println("mkString:"+f.mkString("<", ",", ">"))

    //定义矩阵
    val martix = Array.ofDim[Double](3,4)
    martix(2)(1) = 42
    println(martix.length)

    //定义二维数组
    val triangle = new Array[Array[Int]](10)
    for(i <- 0 until triangle.length)
      triangle(i) = new Array[Int](i+1)
    println(triangle.length)
  }
}
