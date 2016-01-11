
91  案例的介绍
MapActor--->对传进来的数据进行单词的切分（相当于Hadoop的Map）
ReduceActor--->对MapActor产生的结果进行统计（相当于Hadoop的本地reduce）
AggregateActor--->对最后所有的ReduceActor产生的结果进行统计（相当于Hadoop的reduce）
MasterActor--->类似于控制器   Actor之间存在着消息的传输

java方式实现（HelloAkka）



92  开发环境的介绍

<dependencies>
    <dependency>
        <groupId>com.typesafe.akka</groupId>
        <artifactId>akka-actor</artifactId>
        <version>2.0.2</version>
    </dependency>
</dependencies>

<repositories>
    <repository>
        <id>typesafe</id>
        <name>Typesafe Repository</name>
        <url>http://repo.typesafe.com/typesafe/releases/</url>
    </repository>
</repositories>

93  消息实体类（类似于javabean）  --> 用于不同的actor协同工作，传输数据。
MapData--切分字符串为（<单词，1>,<单词，1>,<单词，1>...)的形式
WordCount（单词，计数）
ReduceData--对map产生的结果进行本地reduce统计
Result--用于统计结果作用

94  MapActor--->对传进来的数据进行单词的切分（相当于Hadoop的Map）
    ReduceActor--->对MapActor产生的结果进行统计（相当于Hadoop的本地reduce）
    AggregateActor--->对最后所有的ReduceActor产生的结果进行统计（相当于Hadoop的reduce）


95  MasterActor--->类似于控制器   Actor之间存在着消息的传输


96  ActorSystem





