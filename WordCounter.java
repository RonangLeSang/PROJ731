import java.util.HashMap;

public class WordCounter {

    private String[] text;
    private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

    public WordCounter(String text){
        this.text = text.split(" ");;
    }

    public HashMap count(){
        for(String word : text){
            if(wordCount.containsKey(word)){
                wordCount.put(word, wordCount.get(word)+1);
            }else{
                wordCount.put(word, 1);
            }
        }
        return wordCount;
    }

}
