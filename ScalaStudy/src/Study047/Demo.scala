package Study047

/**
  * 多重界定
  *
  * T <: A with B
  * T >: A with B
  * T >: A :< B
  * T : A : B
  * T <% A <% B
  *
  * Created by liguodong on 2015/12/6.
  */


class M_A[T]
class M_B[T]

object Demo {
  def main(args: Array[String]) {
    implicit val a = new M_A[Int]
    implicit val b = new M_B[Int]

    def foo[T:M_A:M_B](i:T) = println("OK")
    foo(2)
  }
}
