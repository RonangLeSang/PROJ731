import java.rmi.RemoteException;
import java.util.Map;

public interface Coordinator extends java.rmi.Remote {
    void submitMapResult(Map<String, Integer> mapResult) throws RemoteException;

    Map<String, Integer> getReduceResult() throws RemoteException;
}
