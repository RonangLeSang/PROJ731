import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Future;

public interface Coordinator extends java.rmi.Remote {
    void submitMapResult(ArrayList<Future<Map<String, Integer>>>) throws RemoteException;

    Map<String, Integer> getReduceResult() throws RemoteException;
}
