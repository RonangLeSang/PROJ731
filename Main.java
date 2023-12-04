import java.util.ArrayList;
import java.util.HashMap;

public class Main{

    public static void main(String[] args){
        String text = "bonjour je suis Andres et je suis un gros naze";

        WordCounter wc = new WordCounter(text);
        System.out.println(wc.count());

        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("D", 8);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        map2.put("E", 7);

        HashMap<String, Integer> map3 = new HashMap<>();
        map3.put("A", 1);
        map3.put("C", 4);
        map3.put("E", 2);

        ArrayList<HashMap<String, Integer>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        list.add(map3);

        Reducer r = new Reducer(list);
        System.out.println(r.testMerge());

    }

}
