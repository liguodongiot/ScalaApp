package Study036

/**
 * List的partition find takeWhile dropWhile span forall exists操作
 * Created by liguodong on 2015/11/30.
 */
object Demo {
  def main(args: Array[String]) {

    //分区
    println(List(1,2,3,4,5) partition(_ % 2 ==0))
    //找出集合中第一个满足条件的元素
    println(List(1,2,3,4,5) find (_ % 2==0))
    println(List(1,2,3,4,5) find (_ % 6==0))

    //找出符合条件的元素
    println(List(1,2,3,4,5) takeWhile (_ <= 4))
    //剪切掉符合条件的元素
    println(List(1,2,3,4,5) dropWhile (_ < 4))
    //将元素分成符合条件与不符合条件的部分
    println(List(1,2,3,4,5) span (_ < 4))

    //forall表示是否所有元素都是0

    //矩阵中是否存在某一行所有的元素都为0
    def hastotalZeroRow(m:List[List[Int]]) = m exists(row => row forall (_ == 0))
    val m = List(List(1,0,0), List(0,1,0),List(0,0,0))
    println(hastotalZeroRow(m))

  }
}
