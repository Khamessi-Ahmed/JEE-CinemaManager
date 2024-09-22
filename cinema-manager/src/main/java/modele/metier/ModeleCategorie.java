package modele.metier;

import java.util.List;

import Dao.IDaoCategorie;
import modele.entities.Categorie;
import modele.entities.SalleCinema;

public class ModeleCategorie {

	private  Categorie categorie;
	private IDaoCategorie DaoCategorie;
	
	public List<Categorie> getAllCategories(){
		return DaoCategorie.getAllCategories();
	}
	public Categorie addCategorie() {
		Categorie c=null;
		c=this.DaoCategorie.addCategorie(categorie.getLibelle());
				return c;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie c) {
		this.categorie = c;
	}
}
