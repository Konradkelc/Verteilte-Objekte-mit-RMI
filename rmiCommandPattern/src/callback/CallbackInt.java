/* Autor: Konrad Kelc
 * Datum: 28-03-2016
 * Beschreibung: Interface f�r das Callback.
 */

package callback;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

// TODO: Auto-generated Javadoc
/**
 * The Interface Callback.
 *
 * 
 */
public interface CallbackInt extends Remote {
	
	/**
	 * Das Ergebnis der Berechnung zur�ckerhalten
	 *
	 * @param pi the pi
	 * @throws RemoteException the remote exception
	 */
	void receive(BigDecimal pi) throws RemoteException;

}
