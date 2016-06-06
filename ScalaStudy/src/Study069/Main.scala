package Study069


import scala.actors.Actor
import scala.actors.Actor._
import java.net.InetAddress
import java.net.UnknownHostException


/**
 * 并发编程react，loop
 * Created by liguodong on 2015/12/14.
 */
object Main {
  def main(args: Array[String]) {
    NameResolver.start()
    NameResolver ! Net("www.baidu.com",self)

    //println(self.reactWithin(10000){case x => x})

    println(self.receive{case x => x+" day by day!!!"})
  }
}


case class Net(name:String,actor:Actor)



object NameResolver extends Actor{
  def act(): Unit = {
    /*react{
      case Net(name,actor) =>
        actor ! getIp(name)
        act()
      case "EXIT" => println("Name resolver exiting.")
      case msg =>
        println("Unknown message : " + msg)
        act()
    }*/

    loop{
      react{
        case Net (name,actor) =>
          actor ! getIp(name)
        case msg =>
          println("Unknown message : " + msg)
      }
    }

  }



  def getIp(name:String) : Option[InetAddress] = {
    try{
      println(InetAddress.getByName(name))
      Some(InetAddress.getByName(name))
    }catch {
      case _ : UnknownHostException => None
    }
  }

}