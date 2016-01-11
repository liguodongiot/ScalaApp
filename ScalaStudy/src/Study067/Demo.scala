package Study067

import scala.actors.Actor._
import scala.actors.Actor



/**
 * 匿名Actor、消息传递、偏函数实现
 * Created by liguodong on 2015/12/14.
 */

object Message_Actor extends Actor{
  def act(){
    while(true){
      receive{
        case msg => println("Message content form inbox: " + msg)
      }
    }
  }
}


object Demo {

  def main(args: Array[String]) {
    val actor_Message = actor{
      while(true){
        receive{ //isDefinedAt是否为true，如果为true，交给apply方法进行处理，如果false，那么在一个阻塞状态。
          case msg => println("Message content form inbox: " + msg)
        }
      }
    }

    val double_Message = actor{
      while(true){
        receive{ //receive偏函数 ，此方法用来接收Actor外部传来的消息
          case msg : Double => println("Double Number from index: "+msg)
          //case _  => println("Something Unknown.")
        }
      }
    }


    Message_Actor.start()
    Message_Actor ! "Hadoop"

    actor_Message ! "Spark"
    double_Message ! Math.PI
    double_Message ! "Hadoop" //case捕获不到字符串类型


  }


}
