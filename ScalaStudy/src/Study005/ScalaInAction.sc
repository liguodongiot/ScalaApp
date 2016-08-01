import scala.collection.mutable.ArrayBuffer

/**
  * 数组的相关使用
  */
val s = Array("Hello","World");

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
b

//在2的位置上插入6
b.insert(2,6)
b

//在2的位置上插入7,8,9
b.insert(2,7,8,9)
b

//移除2位置上的元素
b.remove(2)
b

b.remove(2,3)
b

val c = b.toArray
b
c


val d = Array(2,3,5,8,11)
//数组中每个元素*2
val result = for(elem <- d) yield 2 * elem

//数组中的所有偶数*2
val resultOdd = for(elem<-d if(elem%2 ==0)) yield 2*elem

//生产环境中的使用方式（_表示占位符）
val resultEnd = d.filter(_ % 2 == 0).map(2 * _)

Array(1,2,3,4,5).sum

ArrayBuffer("Mark","Jason","Tony","s","Chinses").max

val e = Array(4,5,1,3)
val bSorted = e.sorted


val f = Array(100,2,3,7,4)

scala.util.Sorting.quickSort(f)
f

//分隔符
f.mkString(" and ")
f.mkString("<", ",", ">")


//定义矩阵
val martix = Array.ofDim[Double](3,4)
martix(2)(1) = 42
martix

//定义二维数组
val triangle = new Array[Array[Int]](10)
for(i <- 0 until triangle.length)
  triangle(i) = new Array[Int](i+1)
triangle
