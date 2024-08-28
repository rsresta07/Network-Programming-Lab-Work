package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SubtractionImpl extends UnicastRemoteObject implements Subtraction {
    protected SubtractionImpl() throws RemoteException {
        super();
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }
}
