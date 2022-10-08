package server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class server {
    public static void main (String [] args){
        try {
            System.out.println("Server is booting...");
            System.setProperty("java.rmi.server.hostname","127.0.0.1"); 
            Pendulum_impl pendulum_implGame =new  Pendulum_impl();
            pendulum stub1 = (pendulum) UnicastRemoteObject.exportObject(pendulum_implGame, 0);
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9000);
            registry.rebind("GAME",stub1);
        } catch (Exception e) {
            System.out.println("Server error" + e);
        }
    }
}