package Study034

/**
  * 对List进行的高效排序与倒排序
  * Created by liguodong on 2015/11/30.
  */
object Demo {
  def main(args: Array[String]) {
    val list = mergedsort((x: Int,y :Int) => x<y)(List(1,3,21,34,2))
    println(list)
    val list_reversed = mergedsort((x:Int,y:Int)=>x>y) _
    println(list_reversed(List(1,2,3,4)))
  }

  def mergedsort[T] (less: (T,T)=>Boolean)(input: List[T]) : List[T] = {

    /**
     * @param xList 要合并的有序列表
     * @param yList 要合并的有序列表
     * @return  合并后的列表
     */
    def merge(xList:List[T],yList:List[T]):List[T] = (xList, yList) match {
      case (Nil,_) => yList
      case(_,Nil) => xList
      case(x::xtail, y::ytail) =>
        if( less(x,y) ) x :: merge(xtail,yList)
        else y :: merge(xList,ytail)
    }

    val n = input.length/2
    if(n==0) input
    else{
      val(x,y) = input splitAt n //把要排序的列表input平均分成两个列表
      //先对均分后的列表排序，再对排好序的列表进行归并
      merge(mergedsort(less)(x),mergedsort(less)(y))
    }

  }





}
