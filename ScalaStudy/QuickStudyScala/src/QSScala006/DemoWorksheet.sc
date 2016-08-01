
object TrafficLightColor extends Enumeration{
  var Red,Yellow,Green = Value;
}

TrafficLightColor.Red.id

TrafficLightColor.Yellow.id

TrafficLightColor.Green.toString

TrafficLightColor(0)

TrafficLightColor(1)

TrafficLightColor.withName("Yellow")


object TrafficLightColor2 extends Enumeration{
  var Red=Value(0,"Stop")
  val Yellow=(10)
  val Green = Value("go");
}

TrafficLightColor2.Red.id

TrafficLightColor2.Yellow

TrafficLightColor2.Green.id

TrafficLightColor2(0)

TrafficLightColor2(1)

TrafficLightColor2.withName("Stop")