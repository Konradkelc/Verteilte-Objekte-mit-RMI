/* Autor: Konrad Kelc
 * Datum: 17-03-2016
 * Beschreibung: Interface für die Taskabfrage.
 */

package remoteService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.math.BigDecimal;

import server.commands.Command;

// TODO: Auto-generated Javadoc
/**
 * The Interface DoSomethingService.
 */
public interface DoSomethingService extends Remote {

	/**
	 * Execute task.
	 *
	 * @param c the c
	 * @throws RemoteException the remote exception
	 */
	public void executeTask(Command<BigDecimal> c) throws RemoteException;
	
}
