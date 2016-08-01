package akka.app.actors;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.app.messages.MapData;
import akka.app.messages.WordCount;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * 对传进来的数据进行单词的切分
 * Created by liguodong on 2015/12/17.
 */
public class MapActor extends UntypedActor {

    private ActorRef reduceActor = null;

    String[] STOP_WORDS = {"a","is"};//这里面的单词不在单词统计的范围内

    private List<String> STOP_WORDS_LIST = Arrays.asList(STOP_WORDS);

    public MapActor(ActorRef inReduceActor){ reduceActor = inReduceActor;}


    //message 接收消息
    @Override
    public void onReceive(Object message) throws Exception{

        if(message instanceof String){//对消息类型进行判断
            String work = (String)message;
            //map the words in the sentence
            MapData data = evaluateExpression(work);//对单词进行切分
            //send the result to ReducerActor
            reduceActor.tell(data);//对处理的结果交给ReduceActor
        }else
            unhandled(message);//不在处理的范围
    }

    //单词切分工作
    private MapData evaluateExpression(String line){
        List<WordCount> dataList = new ArrayList<WordCount>();

        StringTokenizer parser = new StringTokenizer(line);//切分

        while(parser.hasMoreTokens()){
            String word = parser.nextToken().toLowerCase();//获取切分的元素再转化成小写
            if(!STOP_WORDS_LIST.contains(word)){
                dataList.add(new WordCount(word,Integer.valueOf(1)));
            }
        }
        return new MapData(dataList);
    }
}
