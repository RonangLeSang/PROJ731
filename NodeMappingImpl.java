import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NodeMappingImpl extends UnicastRemoteObject implements NodeMapping {


//    private ArrayList<String> text = new ArrayList<>();
    private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
    public NodeMappingImpl() throws RemoteException {
        // Constructor
    }


    @Override
    public Map<String, Integer> mapping(ArrayList<String> text) throws RemoteException {
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
