package Study004

/**
  * 1、关于函数的说明
  * Created by liguodong on 2015/11/14.
  */
object ForFunctionDemo {
  def main(args: Array[String]) {
    //Scala里面能够自动类型推导
    for (i <- 1 to 2; j <- 1 to 2) print((100*i+j)+" ")
    println

    for (i <- 1 to 2; j <- 1 to 2) if(i!=j) print((100*i+j)+" ")
    println

    def addA(x:Int) = x + 100
    //(x:Int)=>x + 200 为匿名函数
    val addB = (x:Int) => x + 200
    println("The result from a function is: "+addA(2))
    println("The result from a function is: "+addB(2))


    //除了递归以外，一般的函数我们都可以不指定函数的返回类型（自动类型推导）
    def fac(n: Int):Int = if(n <= 0) 1 else n * fac(n-1)
    println("The Result is "+fac(5))

    //函数的参数
    def combine(content:String, left:String="[",right:String = "]") = left +" "+content +" "+ right
    println("The Result from a combine is : "+combine("I love Scala","思密达"))
    println("The Result from a combine is : "+combine("I love Scala"))

    //可变参数
    def connected(args: Int*) ={
      var result = 0
      for (arg <- args) result += arg
      result
    }

    println("The Rusult is "+connected(1,2,3,4,5))
    println("The Rusult is "+connected(1,2,3,4))
  }
}
