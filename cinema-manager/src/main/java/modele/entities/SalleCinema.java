package modele.entities;

public class SalleCinema {

	private int id;
	private String nom;
	private String adresse;
	private int capacite;
	
	
	
	
	public SalleCinema() {
		super();
	}
	public SalleCinema(int id, String nom, String adresse, int capacite) {
		
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.capacite = capacite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	
	
}
