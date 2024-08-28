package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Subtraction extends Remote {
    int subtract(int a, int b) throws RemoteException;
}
