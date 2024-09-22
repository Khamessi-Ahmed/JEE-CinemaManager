package Dao;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import modele.entities.SalleCinema;
import utilitaire.SingletonConnexion;

public class DaoSalleCinema implements IDaoSalleCinema{
	private Connection con=SingletonConnexion.getCon();
	
	@Override
	public List<SalleCinema> getAllSalles() {
		List<SalleCinema> l=new ArrayList();
		
		
		try {
			String query= "select * from SalleCinema";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				SalleCinema s=new SalleCinema();
				s.setId(rs.getInt(1));
				s.setNom(rs.getString(2));;
				s.setAdresse(rs.getString(3));
				s.setCapacite(rs.getInt(4));
				l.add(s);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public SalleCinema addSalle(String nom,String adresse,int capacite) {
		SalleCinema s=new SalleCinema();
		try {
			PreparedStatement ps=con.prepareStatement("insert into SalleCinema (nom, adresse, capacite) values (?, ?, ?)");
			ps.setString(1,nom);
			ps.setString(2,adresse);
			ps.setInt(3,capacite);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
	}
	
	@Override
	public int update(SalleCinema salle){
    	Connection connexion = SingletonConnexion.getCon();
    	PreparedStatement ps;
        int status=0;
        try{
        	String query="UPDATE sallecinema SET nom=?,capacite=?,adresse=? where id=?;";
            ps=connexion.prepareStatement(query);
            ps.setString(1,salle.getNom());
            ps.setInt(2,salle.getCapacite());
            ps.setString(3, salle.getAdresse());
            ps.setInt(4,salle.getId());
            status=ps.executeUpdate();
        }catch(Exception e){System.out.println(e);}
        return status;
    }

	@Override
    public void delete(int id){
    	Connection connexion = SingletonConnexion.getCon();
    	PreparedStatement ps;
        
        try{
        	String query="DELETE FROM sallecinema where id=?;";
        	ps=connexion.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(Exception e){System.out.println(e);}

        
    }

    public SalleCinema getSalleById(int id){
    	Connection connexion = SingletonConnexion.getCon();
        SalleCinema salle = null;
        PreparedStatement ps ;
		ResultSet rs ;

        try{
        	String query = "SELECT * FROM SalleCinema WHERE id = ?";
            ps=connexion.prepareStatement(query);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            if(rs.next()){
            	String nom = rs.getString("nom");
                int capacite = rs.getInt("capacite");
                String adresse= rs.getString("adresse");
                salle = new SalleCinema(id, nom, adresse,capacite);
            }
        }catch(Exception e){System.out.println(e);}
        return salle;
    }

}
