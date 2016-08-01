package akka.app.actors;

import akka.actor.UntypedActor;
import akka.app.messages.ReduceData;
import akka.app.messages.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * 对最后所有的ReduceActor产生的结果进行统计
 * Created by liguodong on 2015/12/17.
 */
public class AggregateActor extends UntypedActor{

    //保存全局结果
    private Map<String,Integer> finalReducedMap = new HashMap<String,Integer>();


    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof ReduceData){
            ReduceData reduceData = (ReduceData) message;
            //对本地reduce的结果进行全局的统计
            aggregateInMemoryReduce(reduceData.getReduceDataList());
        }else if(message instanceof Result){
            System.out.println(finalReducedMap.toString());
        }
        else{
            unhandled(message);
        }
    }

    private void aggregateInMemoryReduce(Map<String,Integer> reducedList){
        Integer count = null;
        for(String key:reducedList.keySet()){
            if(finalReducedMap.containsKey(key)){
                count = reducedList.get(key) + finalReducedMap.get(key);
                finalReducedMap.put(key,count);
            }else{
                finalReducedMap.put(key,reducedList.get(key));
            }
        }
    }

}
