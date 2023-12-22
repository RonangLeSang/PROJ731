import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class CoordinatorNode extends UnicastRemoteObject implements Coordinator {
    private Map<String, Integer> reduceResult = new HashMap<>();

    public CoordinatorNode() throws RemoteException {
        // Constructor
    }

    @Override
    public void submitMapResult(ArrayList<Future<Map<String, Integer>>> mapResult) throws RemoteException {
        // Handle Map results and update reduceResult
        for (Map.Entry<String, Integer> entry : mapResult.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            // Update or initialize count in reduceResult
            reduceResult.merge(word, count, Integer::sum);
        }
    }

    @Override
    public Map<String, Integer> getReduceResult() throws RemoteException {
        // Return the final reduceResult
        return reduceResult;
    }


}
