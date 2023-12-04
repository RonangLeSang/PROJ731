// CoordinatorNode.java

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class CoordinatorNode extends UnicastRemoteObject {
    private Map<String, Integer> reduceResult = new HashMap<>();

    public CoordinatorNode() throws RemoteException {
        // Constructor
    }

    public void submitMapResult(Map<String, Integer> mapResult) {
        // Handle Map results and update reduceResult
        for (Map.Entry<String, Integer> entry : mapResult.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            // Update or initialize count in reduceResult
            reduceResult.merge(word, count, Integer::sum);
        }
    }

    public Map<String, Integer> getReduceResult() {
        // Return the final reduceResult
        return reduceResult;
    }

    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            CoordinatorNode coordinatorNode = new CoordinatorNode();
            java.rmi.Naming.rebind("CoordinatorNode", coordinatorNode);
            System.out.println("CoordinatorNode is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}