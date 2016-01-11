package akka.app.messages;

/**
 * JavaBean
 * Created by liguodong on 2015/12/17.
 */
public class WordCount {
    private String word; //单词
    private Integer count; //单词的计数

    public WordCount(String inWord,Integer inCount){
        word = inWord;
        count = inCount;
    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }
}
