package modele;

public class HauteurMaree {
	private Horaire chHoraire; 
	private float chHauteur;
	
	public HauteurMaree(float parHauteur,Horaire parHoraire) {
		chHoraire = new Horaire(parHoraire.getHeure(),parHoraire.getMinutes());
		chHauteur = parHauteur;	
	}
	
	public String toString() {
		return chHoraire + " & " + chHauteur;
	}
	
	public Horaire getHoraire() {
		return chHoraire;
	}
	
	public float getHauteur() {
		return chHauteur;
	}
}