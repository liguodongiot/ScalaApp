package Study014

/**
  * 接口
  * Created by liguodong on 2015/11/16.
  */
object Demo {

  def main(args: Array[String]) {
    val logger = new ConcreteLogger
    logger.concreteLog
    logger.study()

    println("---------")

    val traitLogger = new TraitLogger
    traitLogger.log("liguodong")
    traitLogger.study

    println("---------")
    val traitLoggered = new Test
    traitLoggered.test
    traitLoggered.logTraitLoggered("liguodong")
    traitLoggered.studyTraitLoggered

    println("---------")


    val stu = new ConcreteLogger with TraitLoggered
    stu.studyTraitLoggered()

  }
}


//特质
trait Logger{
  //抽象方法
  def log(msg: String)

  //不是抽象方法
  def study(){}
}

//多个trait采用with连接
class ConcreteLogger extends Logger /*with Cloneable*/{

  def concreteLog{
    log("It's me!!!")
  }

  override def log(msg: String) = println("Log: " + msg)

}


class  TraitLogger extends Logger{

  override def log(msg: String){
    println("TraitLogger Log content is : " + msg)
  }

  override def study(){
    println("override study...")
  }
}

trait TraitLoggered{
  def logTraitLoggered(msg: String){
    println("TraitLoggered Log content is : " +msg)
  }
  def studyTraitLoggered(){
    println("TraitLoggered study...")
  }
}


trait ConsoleLogger extends TraitLoggered{
  override def logTraitLoggered(msg: String){
    println("Log from Console : " + msg)
  }
}

class Test extends ConsoleLogger{

  def test{
    logTraitLoggered("Here is Spark!!!")
  }
}

