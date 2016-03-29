/* Autor: Konrad Kelc
 * Datum: 28-03-2016
 * Beschreibung: Die Implementation des Callback Interfaces
 */

package callback;

import java.math.BigDecimal;
import java.rmi.RemoteException;


// TODO: Auto-generated Javadoc
/**
 * The Class PiCallback.
 */
public class Callback implements CallbackInt {
	

	/**
	 * Erhaltet das Ergebnis und gibt es aus
	 *
	 * @param pi the pi
	 * @throws RemoteException the remote exception
	 */
	public void receive(BigDecimal pi) throws RemoteException {
		System.out.println(pi);
	}
}
