97  在build.sbt文件夹下，添加最后两行文件，然后下载
name := "StudyAkkaWithSBT"

version := "1.0"

scalaVersion := "2.11.6"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.3"


------------
98  对于windows 32位系统直接运行SBT Console下（run），他会到IEDA的目录下找jre，
而对于64位操作系统而言，他就不会到IDEA目录下去找JRE。

所以64位操作系统 要运行idea64.exe

------------
99  手动Artifacts打包并运行SBT开发Akka第一个案例

SBT可以自动打包编译运行，我们也可以用IDEA方式打包编译运行，为什么要手动Artifacts打包？
我们希望把开发的工程打包成jar包在其他的机器或者命令终端，或者让其他人去运行，
那么这个时候就需要打包成jar包的方式。
File->Project Structure->Artifacts-> + -> jar -> From Modules With Denpendences...



编译打包：
Build -> Build Artifacts -> Action Build

在工程 $PROJECT_PATH/out/artifacts/studyakkawithsbt_jar/ 目录下看到jar文件。

运行
$PROJECT_PATH/out/artifacts/studyakkawithsbt_jar>java -jar studyakkawithsbt.jar Demo.Main

$PROJECT_PATH/out/artifacts/studyakkawithsbt_jar>java -jar studyakkawithsbt.jar
最好指定Main Class，一是运行速度更快，二是一个工程有可能有多个Main Class。

-----------
100 消息、main入口、MasterActor


101 MapActor、ReduceActor、AggregateActor

102 Actor的运行机制以及生命周期

Actor是异步的，非阻塞的，事件驱动编程模型（Actor之间的沟通是通过发消息的方式），
轻量级事件驱动进程。

生命周期
LifeCycle.png

Actor初始化--Actor接收消息处理消息--停止对消息的处理，进行清理工作

preStart：资源的初始化
preRestart
Start状态：查看邮箱中是否有邮件，收到消息之后进行处理。
Stop状态：有可能收到的指令要求actor关闭。
postStop：清理资源
postRestop

103 Actor的定义与创建

val system = ActorSystem("HelloAkka")
//创建具体的MasterActor
 val master = system.actorOf(Props[MasterActor],name = "master")


104 Actor的不同类型的Constructor
Actor默认的Constructor与Actor非默认的Constructor

//创建AggregateActor
val aggregateActor:ActorRef = context.actorOf(Props[AggregateActor],name="aggregate")

//reduceActor结果会交给aggregateActor
val reduceActor:ActorRef = context.actorOf(Props(new ReduceActor(aggregateActor)),name="reduce")

//mapActor结果会交给reduceActor
val mapActor:ActorRef = context.actorOf(Props(new MapActor(reduceActor)),name="map")


105 子actor
actor之间是有层级结构的

val system = ActorSystem("HelloAkka")
//创建具体的MasterActor
val master = system.actorOf(Props[MasterActor],name = "master")
println(master.path)   --->akka://HelloAkka/user/master

master是HelloAkka的子actor

masterActor之间又有3个子Actor
masterActor:akka://HelloAkka/user/master
aggregateActor:akka://HelloAkka/user/master/aggregate
reduceActor:akka://HelloAkka/user/master/reduce
mapActor:akka://HelloAkka/user/master/map

106 消息的不同的发送方式（异步方式）
Fire and Forget（发送了之后不关心结果）
Send and Receive（发送了之后关心结果）

SendMessage.png

107 Future
Send and Receive（发送消息之后，会等待结果）


108 消息的处理，回复与转发

Actor

消息处理
/**
* This defines the initial actor behavior, it must return a partial function
* with the actor logic.
*/
//#receive
def receive: Actor.Receive

消息回复
/**
* The reference sender Actor of the last received message.
* Is defined if the message was sent from another Actor,
* else `deadLetters` in [[akka.actor.ActorSystem]].
*
* WARNING: Only valid within the Actor itself, so do not close over it and
* publish it to other threads!
*/
final def sender(): ActorRef = context.sender()

消息的转发
ActorRef

/**
* Forwards the message and passes the original sender actor as the sender.
*
* Works, no matter whether originally sent with tell/'!' or ask/'?'.
*/
def forward(message: Any)(implicit context: ActorContext) = tell(message, context.sender())


109 Actor同步或异步停止方式

//master ! PoisonPill   //异步方式
//master ! Kill         //同步方式

context.stop(self)  //停止自己的Actor

system.shutdown     //停止所有的Actor


110 Actor的Monitoring（监控）机制

Actor的Supervisor.png

Actor的Monitoring.png
Actor的Monitoring具体流程.png

111 Actor中用become和unbecome动态切换receive的具体处理逻辑
