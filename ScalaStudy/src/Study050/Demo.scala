package Study050

/**
  * Variance变化点
  * Created by liguodong on 2015/12/7.
  */

//class P[+T](val first:T,val second:T)


class P[+T](val first:T,val second:T){
  def replaceFirst[R >: T](newFirst:R) = new P[R](newFirst,second)
}


object Demo {
  def main(args: Array[String]) {

  }
}
