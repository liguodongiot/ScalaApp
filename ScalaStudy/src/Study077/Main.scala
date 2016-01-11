package Study077

/**
 * 模式匹配下的提取器手动构造
 * Created by liguodong on 2015/12/15.
 */

object :> {
  def unapply[A](list:List[A]) = {
    //init ==> Selects all elements except the last.
    //last ==> Select the last element
    Some((list.init,list.last))
  }
}

object Main {
  def main(args: Array[String]) {
    (1 to 9).toList match { case _ :> 9 => println("Boys")}
    (1 to 9).toList match { case x :> 8 :> 9 => println("Girls")}
    (1 to 9).toList match { case  :> (:>(_,8) ,9) => println("Ladys")}
  }
}
