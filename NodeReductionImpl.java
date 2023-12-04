import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NodeReductionImpl extends UnicastRemoteObject implements NodeReduction {

    public ArrayList<HashMap<String, Integer>> hashList;
    public HashMap<String, Integer> fullHashMap = new HashMap<>();

    public NodeReductionImpl() throws RemoteException {
        // Constructor
    }

    @Override
    public Map<String, Integer> reduction(Map<String, Integer> hashMap) throws RemoteException {
        hashMap.forEach((key, value) -> fullHashMap.merge(key, value, Integer::sum));
        return hashMap;
    }
}
