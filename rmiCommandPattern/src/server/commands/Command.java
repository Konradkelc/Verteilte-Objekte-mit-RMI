/* Autor: Konrad Kelc
 * Datum: 17-03-2016
 * Beschreibung: Interface Vorlage für die Berechnung.
 */

package server.commands;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Interface Command.
 *
 * @param <T> the generic type
 */
public interface Command<T> extends Serializable {

	/**
	 * Execute.
	 */
	public void execute();//führt die Berechnung aus
}
