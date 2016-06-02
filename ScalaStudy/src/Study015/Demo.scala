package Study015

/**
  * 多重继承
  *
  * 基于trait的AOP编程
  * Created by liguodong on 2015/11/17.
  */
object Demo {

  def main(args: Array[String]) {
    val p = new PianoTeacher
    p.playPiano
    p.teach

    println("---------")

    val h = new Human with Teacher with PianoPlayer{
      //抽象方法
      override def teach: Unit = println("I'm training students.")
    }
    h.playPiano
    h.teach

    println("-----AOP----")
    val w = new Work with TBeforeAfter
    w.doAction




  }

}


class Human{
  println("Human")
}

trait Teacher extends Human{
  println("Teacher")
  //抽象方法
  def teach
}

trait PianoPlayer extends Human{
  println("PianoPlayer")
  def playPiano = {
    println("I'm playing piano.")
  }
}

//构造顺序从左往右构造（Human->Teacher->PianoPlayer）
class PianoTeacher extends Human with Teacher with PianoPlayer{
  //抽象方法
  override def teach = {
    println("I'm training students.")
  }
}

/*---AOP-------*/
trait Action{
  def doAction
}

trait TBeforeAfter extends Action{
  //doAction虽然实现了，但依旧是抽象方法。
  //方法内部我们调用了super.doAction，因此仍然是抽象的
  abstract override def doAction: Unit ={
    println("Init")
    super.doAction
    println("Destroyed")
  }
}

class Work extends Action{
  override def doAction: Unit = println("Working...")
}



