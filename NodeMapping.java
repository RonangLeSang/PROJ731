import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;

public interface NodeMapping extends Remote {
    public Map<String, Integer> mapping(ArrayList<String> text) throws RemoteException;
}

