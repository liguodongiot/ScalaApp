package Study014

/**
 * Created by liguodong on 2016/5/30.
 */
object MixInDemo {

  def main(args: Array[String]) {
    val t1 = new PianoplayerTeacher
    t1.teach
    t1.playPiano

    //创建对象时才将特质各自的特点赋予对象。
    val t2 = new Person with TTeacher with TPianoPlayer{
      def teach = println("I'm teaching students.")
    }
    t2.teach
    t2.playPiano
  }


}



class Person; //实体类

trait TTeacher extends Person{
  def teach //虚方法
}

trait TPianoPlayer extends Person{
  def playPiano = println("I'm playing piano.")
}

class PianoplayerTeacher extends Person with TTeacher with TPianoPlayer{
  def teach = println("I'm teaching students.")
}