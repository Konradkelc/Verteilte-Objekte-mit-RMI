/* Autor: Konrad Kelc
 * Datum: 17-03-2016
 * Beschreibung: Server service Klasse.
 */

package server;

import java.rmi.RemoteException;
import remoteService.DoSomethingService;
import server.commands.Command;

// TODO: Auto-generated Javadoc
/**
 * The Class ServerService.
 */
public class ServerService implements DoSomethingService {

	/* (non-Javadoc)
	 * @see remoteService.DoSomethingService#executeTask(server.commands.Command)
	 */
	@Override
	public void executeTask(Command c) throws RemoteException {
		c.execute();

	}

}
