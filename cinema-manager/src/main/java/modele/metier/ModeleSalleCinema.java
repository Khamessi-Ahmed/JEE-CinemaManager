package modele.metier;
import java.util.List;

import Dao.DaoSalleCinema;
import Dao.IDaoSalleCinema;
import modele.entities.SalleCinema;

public class ModeleSalleCinema {
	
	private SalleCinema salle;
	private IDaoSalleCinema DaoSalle=new DaoSalleCinema();
	

	public List<SalleCinema> getAllSallesCinema(){
		return DaoSalle.getAllSalles();
	}
	public SalleCinema addSalle() {
		SalleCinema s=null;
		s=this.DaoSalle.addSalle(salle.getNom(), salle.getAdresse(), salle.getCapacite());
				return s;
	}
	public SalleCinema getSalle() {
		return salle;
	}
	public void setSalle(SalleCinema salle) {
		this.salle = salle;
	}
}
