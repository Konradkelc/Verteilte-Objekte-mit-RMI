/* Autor: Konrad Kelc
 * Datum: 17-03-2016
 * Beschreibung: Client Klasse zur Verbindung mit den server und ausführen der Berechnung.
 */
 
 package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.math.BigDecimal;
import remoteService.DoSomethingService;
import server.commands.Command;
import server.commands.RegisterCommand;
import server.commands.LoginCommand;
import server.commands.Pi;
import callback.CallbackInt;
import callback.Callback;

// TODO: Auto-generated Javadoc
/**
 * The Class Client.
 */
public class Client {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());//SecurityManager erstellen.
		}
		try {
			Registry registry = LocateRegistry.getRegistry(1200);//registry abfragen
			CallbackInt c = new Callback();//Objekt von Callback erstellen
			CallbackInt stub =(CallbackInt)UnicastRemoteObject.exportObject(c,0); //Stub erstellen
			DoSomethingService uRemoteObject = (DoSomethingService) registry.lookup("Service");//Service Objekt aus der registry auslesen
			System.out.println("Service found");
			Command<BigDecimal> rc = new Pi(Integer.parseInt(args[0]),stub);//Objekt von Pi erstellen
			uRemoteObject.executeTask(rc);//Objekt übergeben und berechnung am server durchführen
			
			
		} catch (RemoteException re) {
			System.err.println("Service not found?" + " Check your RMI-Registry!");
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
