/* Autor: Konrad Kelc
 * Datum: 17-03-2016
 * Beschreibung: Server Klasse.
 */

package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import remoteService.DoSomethingService;

// TODO: Auto-generated Javadoc
/**
 * The Class Server.
 */
public class Server {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			ServerService uRemoteObject = new ServerService();//ServerService erstellen.
			DoSomethingService stub = (DoSomethingService) UnicastRemoteObject.exportObject(uRemoteObject, 0);//stub erstellen.
			Registry registry = LocateRegistry.createRegistry(1200);//registry erstellen (getRegistry geht nicht).
			registry.rebind("Service", stub);//Objekt mit der registry verbinden.
			System.out.println("Service bound! Press Enter to terminate ...");

			while ( System.in.read() != '\n' );//verbindung schliessen wenn Enter gedrückt wird.
			UnicastRemoteObject.unexportObject(uRemoteObject, true);

			System.out.println("Service unbound, System goes down ...");

		} catch (RemoteException re) {
			System.err.println("Service already bound?" + " Check your RMI-Registry settings!");
			re.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:");
			e.printStackTrace();
			System.exit(1);
		}

	}

}
