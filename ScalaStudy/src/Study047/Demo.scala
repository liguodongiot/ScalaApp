package Study047

/**
  * 多重界定
  *
  * T <: A with B with C (可以实现多个特质)
  * T >: A with B
  * T >: A :< B （同时指定上界和下界）
  * T : A : B (多个上下文界定)
  * T <% A <% B （多个视图界定）
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
