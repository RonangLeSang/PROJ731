import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public interface NodeReduction extends Remote {
    Map<String, Integer> reduction(Map<String, Integer> hashMap) throws RemoteException;

}

