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
    //混入-->有问题没解决
    //val stu = new ConcreteLogger with TraitLogger
    //stu.study()

  }
}

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
  def  log(msg: String){
    println("TraitLoggered Log content is : " +msg)
  }
  def study(){
    println("override study...")
  }
}


trait ConsoleLogger extends TraitLogger{
  override def log(msg: String){
    println("Log from Console : " + msg)
  }
}

class Test extends ConcreteLogger{
  def test{
    log("Here is Spark!!!")
  }
}