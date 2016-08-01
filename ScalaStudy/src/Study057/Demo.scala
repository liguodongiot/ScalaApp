package Study057

/**
 * Dependency Injection
 *
 * Created by liguodong on 2015/12/9.
 */
//抽象方法
trait Logger {def log(msg:String)}

trait Auth{
  auth : Logger =>   //表明使用Auth必须实现Logger
  def act(msg:String){
    log(msg)
  }
}

//Auth依赖于Logger
object DI extends Auth with Logger{
  override def log(msg : String) = println(msg)
}


object Demo {
  def main(args: Array[String]) {
    DI.act("I like DI...")
  }
}
