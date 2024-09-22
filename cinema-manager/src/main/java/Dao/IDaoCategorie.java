package Dao;

import java.util.List;

import modele.entities.Categorie;
import modele.entities.SalleCinema;

public interface IDaoCategorie {
	public List<Categorie> getAllCategories();
	public Categorie addCategorie(String Libelle);

	public int update(Categorie categorie);
	 public void delete(int id);
}
