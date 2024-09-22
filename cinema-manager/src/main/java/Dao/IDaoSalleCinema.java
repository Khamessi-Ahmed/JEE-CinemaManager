package Dao;

import java.util.List;

import modele.entities.SalleCinema;

public interface IDaoSalleCinema {

	public List<SalleCinema> getAllSalles();
	public SalleCinema addSalle(String nom,String adresse,int capacite);
	public int update(SalleCinema salle);
	public void delete(int id);
}
