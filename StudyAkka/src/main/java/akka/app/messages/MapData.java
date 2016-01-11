package akka.app.messages;

import java.util.List;

/**
 * 作用：方便把MapActor处理的结果传给ReduceActor
 * Created by liguodong on 2015/12/17.
 */
public class MapData {
    private List<WordCount> dataList;

    public List<WordCount> getDataList(){ return dataList;}
    public MapData(List<WordCount> dataList) {this.dataList = dataList;}

}
