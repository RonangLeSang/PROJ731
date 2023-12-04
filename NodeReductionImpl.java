import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class NodeReductionImpl extends UnicastRemoteObject implements NodeReduction {

    public NodeReductionImpl() throws RemoteException {
        // Constructor
    }

    @Override
    public Map<String, Integer> reduction(Map<String, Integer> hashMap) throws RemoteException {
        // Implement reduction logic
        return hashMap;
    }
}
