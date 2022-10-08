package server;

import java.rmi.Remote; 
import java.rmi.RemoteException;
public interface pendulum  extends Remote{
    public String StartGame() throws RemoteException;
    public int Play(Character word) throws RemoteException;
    public void EndGame() throws RemoteException;
    public String getWordPlay() throws RemoteException;
    public int getCount() throws RemoteException;
}
