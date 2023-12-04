import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class NodeMappingImpl extends UnicastRemoteObject implements NodeMapping {

    public NodeMappingImpl() throws RemoteException {
        // Constructor
    }

    @Override
    public Map<String, Integer> mapping(Map<String, Integer> hashMap) throws RemoteException {
        // Implement mapping logic
        return hashMap;
    }
}
