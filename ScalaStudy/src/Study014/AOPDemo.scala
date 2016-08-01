package Study014

/**
 * 用特质进行AOP编程
 * Created by liguodong on 2016/5/30.
 */
object AOPDemo {



  def main(args: Array[String]) {
    val a1 = new RealAction with TBeforeAfter
    a1.doAction
//    Action Before
//    ** real action done!! **
//    Action After

    println("------------")

    //根据with语句定义的顺序来执行的
    val a2 = new RealAction with TBeforeAfter with TTwiceAction
    a2.doAction
//    Action Before
//    ** real action done!! **
//    Action After
//    ==>No.1

//    Action Before
//    ** real action done!! **
//    Action After
//    ==>No.2
    println("------------")

    val a3 = new RealAction with TTwiceAction with TBeforeAfter
    a3.doAction

//    Action Before
//    ** real action done!! **
//    ==>No.1
//    ** real action done!! **
//    ==>No.2
//    Action After
  }

}


trait TAction{
  def doAction
}

trait TBeforeAfter extends TAction{
  abstract override def doAction: Unit ={
    println("Action Before")
    super.doAction //调用原来的处理
    println("Action After")
  }
}

class RealAction extends TAction{
  def doAction={
    println("** real action done!! **")
  }
}


trait TTwiceAction extends TAction{
  abstract override def doAction: Unit ={
    for(i <-1 to 2){

      super.doAction //调用原来的处理

      println("==>No."+i)
    }

  }
}