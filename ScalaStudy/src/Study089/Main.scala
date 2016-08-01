package Study089

import scala.collection.generic

/**
 * For表达式实现内幕
 * Created by liguodong on 2015/12/16.
 */
object Main {
  def main(args: Array[String]) {

    for(l <- List(1,2,3)) yield print(l)
    //FilterMonadic
  }
}
