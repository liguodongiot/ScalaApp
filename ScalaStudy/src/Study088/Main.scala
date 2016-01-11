package Study088

/**
 * For表达式实现map，flatMap，filter
 * Created by liguodong on 2015/12/16.
 */
object Main {
  def main(args: Array[String]) {

    def map[A,B](list:List[A],f:A => B):List[B] = for(element <- list) yield f(element)

    def flatMap[A,B](list:List[A],f:A => List[B]) : List[B] = for(x <- list; y <- f(x) ) yield y

    def filter[A](list:List[A],f:A =>Boolean):List[A] = for(elem <- list if f(elem)) yield elem
  }
}
