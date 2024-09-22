package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.entities.Categorie;
import modele.entities.SalleCinema;
import utilitaire.SingletonConnexion;

public class DaoCategorie implements IDaoCategorie{

	private Connection con=SingletonConnexion.getCon();
	
	
	
	@Override
	public List<Categorie> getAllCategories() {
		List<Categorie> l=new ArrayList();
		try {
			String query= "select * from categorie";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Categorie c=new Categorie();
				c.setId(rs.getInt(1));
				c.setLibelle(rs.getString(2));
				l.add(c);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Categorie addCategorie(String Libelle) {
		Categorie c=new Categorie();
		try {
			PreparedStatement ps=con.prepareStatement("insert into categorie (libelle) values (?)");
			ps.setString(1,Libelle);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public int update(Categorie categorie) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
        int status=0;
        try{
        	String query="UPDATE categorie SET libelle=? where id=?;";
            ps=con.prepareStatement(query);
            ps.setString(1,categorie.getLibelle());
            ps.setInt(2,categorie.getId());
            status=ps.executeUpdate();
        }catch(Exception e){System.out.println(e);}
		return status;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
			PreparedStatement ps;
        
        try{
        	String query="DELETE FROM categorie where id=?;";
        	ps=con.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(Exception e){System.out.println(e);}

	}

}
