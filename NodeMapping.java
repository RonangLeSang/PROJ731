import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public interface NodeMapping extends Remote {
    Map<String, Integer> mapping(Map<String, Integer> hashMap) throws RemoteException;
}

