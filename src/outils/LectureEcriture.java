package outils;

import java.io.*;

/**
 * Classe LectureEcriture, permet de lire ou �crire dans un fichier.
 * @author Arthur Pellegrini
 * @see java.io
 */
public class LectureEcriture implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * M�thode de lecture d�un fichier
	 * @param parFichier : le fichier lu
	 * @return l�objet lu
	 */
	public static Object lecture (File parFichier) {
		ObjectInputStream flux ;
		Object objetLu = null;
	
		// Ouverture du fichier en mode lecture
		try {
			flux = new ObjectInputStream(new FileInputStream (parFichier));
			objetLu = (Object)flux.readObject ();
			flux.close ();
		} catch (ClassNotFoundException parException) {
			System.err.println (parException.toString ());
			System.exit (1);
		} catch (IOException parException) {
			System.err.println ("Erreur lecture du fichier " + parException.toString ());
			System.exit (1);
		}
		return objetLu ;
	}

	/** M�thode d��criture dans un fichier
	 * @param parFichier : le fichier dans lequel on �crit
	 * @param parObjet : l�objet �crit dans le fichier
	 */
	public static void ecriture (File parFichier, Object parObjet) {
		ObjectOutputStream flux = null;
		// Ouverture du fichier en mode �criture
		try {
			flux = new ObjectOutputStream (new FileOutputStream (parFichier));
			flux.writeObject (parObjet);
			flux.flush ();
			flux.close ();
		}

		catch (IOException parException) {
			System.err.println ("Probleme a l�ecriture\n" + parException.toString ());
			System.exit (1);
		}
	}
}
