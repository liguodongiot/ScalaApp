package akka.app.actors;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.app.messages.MapData;
import akka.app.messages.ReduceData;
import akka.app.messages.WordCount;

import java.util.HashMap;
import java.util.List;

/**
 * 对MapActor产生的结果进行统计
 * Created by liguodong on 2015/12/17.
 */
public class ReduceActor extends UntypedActor{

    private ActorRef aggregateActor = null;

    public ReduceActor(ActorRef inAggregateActor){
        aggregateActor = inAggregateActor;
    }


    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof MapData){//对收到的MapActor进行处理
            MapData mapData = (MapData)message;
            //reduce the incoming data
            ReduceData reduceData = reduce(mapData.getDataList());//对单词进行计数
            //forword the result to aggregate actor
            aggregateActor.tell(reduceData);//发送给AggregateActor
        }else{
            unhandled(message);
        }
    }

    private ReduceData reduce(List<WordCount> dataList){
        HashMap<String,Integer> reduceMap = new HashMap<String,Integer>();
        for(WordCount wordCount : dataList){
            if(reduceMap.containsKey(wordCount.getWord())){//判断是否包含有这个单词
                Integer value = (Integer)reduceMap.get(wordCount.getWord());
                value++;
                reduceMap.put(wordCount.getWord(),value);
            }else{
                reduceMap.put(wordCount.getWord(),Integer.valueOf(1));
            }
        }
        return new ReduceData(reduceMap);
    }
}
