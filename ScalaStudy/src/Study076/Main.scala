package Study076

/**
 * 模式匹配下的赋值语句
 * Created by liguodong on 2015/12/15.
 */
object Main {
  def main(args: Array[String]) {
    //@就是别名的意思  a是b的别名
    val a@b = 1000   //内部会进行模式匹配，将1000赋值给a和b
    println("a = "+ a +", b = " + b)
    //元组方式接收
    val (c,d) = (1000,2000)
    println("c = "+ c +", d = " + d)

    //F大写会报错，如果大写，会默认进行常量匹配，但是我们又没有定义F这个常量
    //val (e,F) = (1000,2000)

    val Array(g,h) = Array(1000,2000)
    //val Array(i,J) = Array(1000,2000)

    object Test{ val 1 = 1} //TRUE
    //object Test{ val 1 = 2} //FALSE   匹配的时候是lazy级别，只有在真正运行时会报错，编译时没问题。
  }
}
