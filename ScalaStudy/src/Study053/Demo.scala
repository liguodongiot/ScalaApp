package Study053

/**
 * 结构类型
 * Created by liguodong on 2015/12/8.
 */
class Structural_Type{
  def open()=println("A class instance Opened")
}

object Demo {

  def init(res:{def open():Unit}){
    res.open()
  }

  def main(args: Array[String]) {

    init(new { def open()=println("Opened")})

    //取别名
    type X = {def open():Unit}
    def init(res:X) = res.open

    init(new {def open()=println("Opened again")})


    object  A{ def open() {println("A single object Opened")}}
    init(A)

    val structural = new Structural_Type
    init(structural)
  }



}
