import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.Naming;
import java.util.HashMap;
import java.util.Map;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class NodeReduction extends UnicastRemoteObject {

    public NodeReduction() throws RemoteException {

    }

    public Map<String, Integer> reduction(Map<String, Integer> hashMap) {
        return hashMap;
    }
}