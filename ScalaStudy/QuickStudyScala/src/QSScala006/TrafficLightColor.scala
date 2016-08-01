package QSScala006




/**
  * Created by liguodong on 2015/11/29.
  */
object TrafficLightColor extends Enumeration{
  var Red,Yellow,Green = Value;
}


object Demo{
  def main(args: Array[String]) {

    println(doWhat(TrafficLightColor.Red))

  }


  def doWhat(color: TrafficLightColor.Value) = {
    if(color == TrafficLightColor.Red) "Stop"
    else if(color == TrafficLightColor.Yellow) "hurry up"
    else "go"
  }
}