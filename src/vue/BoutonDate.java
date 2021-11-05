package vue;

import javax.swing.JButton;

import modele.Date;

/**
 * Classe BoutonDate, permet de cr�er un bouton qui est associ� � une date.
 * @author Arthur Pellegrini / Antoine Gache
 * @see javax.swing.JButton
 */
public class BoutonDate extends JButton {
	private static final long serialVersionUID = 1L;
	/**
	 * Attribut contenant la date du bouton
	 */
	private Date date;
	
	/**
	 * Constructeur de la Classe BoutonDate.
	 * @param date, date du bouton
	 */
	public BoutonDate(Date date) {
		super (Integer.toString(date.getJour()));
		this.date= date;
	}

	/**
	 * Permet d'obtenir la date du this.
	 * @return date, renvoie la date du bouton
	 */
	public Date getDate() {		 
		return date;
	}

}
