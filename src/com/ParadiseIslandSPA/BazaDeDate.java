package com.ParadiseIslandSPA;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.tomcat.util.descriptor.web.LoginConfig;

class BazaDeDate {

	private static String connectionLink = "jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2240093\",\"sql2240093\",\"cC6!xF7*";

	private BazaDeDate() {
	}

	public static DetaliiProdus getNumeProdusById(String idProdus) {
		
		String query ="SELECT * FROM produse WHERE id_produs=?";
		
		DetaliiProdus produs = null;
		String nume,tip;
		double pret;
		
		try(Connection connection = DriverManager.getConnection(connectionLink);
				PreparedStatement ps = connection.prepareStatement(query)){
			 	
				ps.setString(1, idProdus);
			 	
				try(ResultSet rs = ps.executeQuery()){
			 		
			 		rs.next();
		 			nume = rs.getString(2);
		 			pret = rs.getDouble(3);
		 			tip = rs.getString(4);
			 		produs = new DetaliiProdus(nume,tip,pret);
			 		return produs;
			 		
			 	} catch (SQLException ex) {
			             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
			        }
		} catch (SQLException ex)  {
			Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
		}finally {
			return produs;
		}
		
			
		
		
		
	}
	
	public static Client getClientByEmail(String email) {
		
		String query = "SELECT * FROM clienti WHERE email=?";
		
		Client client = null;
		String nume,prenume;
		int idClient;
		boolean admin;
		
		
		try(Connection connection = DriverManager.getConnection(connectionLink);
				PreparedStatement ps = connection.prepareStatement(query)){
			 	
				ps.setString(1, email);
			 	
				try(ResultSet rs = ps.executeQuery()){
			 		
			 		if(!rs.next()) {
			 			idClient = rs.getInt(1);
			 			nume = rs.getString(2);
			 			prenume = rs.getString(3);
			 			admin = rs.getBoolean(5);
			 			client = new Client(idClient,nume,prenume,admin);
			 		}
			 		
			 	} catch (SQLException ex) {
			             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
			        }
		} catch (SQLException ex)  {
			Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
		}
		finally {
			return client;
		}
	}
	
	public static boolean addNewClient(Client client) {
		
		// De verificat aici denumirile
		String query = "INSERT INTO clienti (id_client, nume, prenume, email, password)" + "values(?,?,?,?,?)";
		
		try(Connection connection = DriverManager.getConnection(connectionLink);
				PreparedStatement ps = connection.prepareStatement(query)){
			 	
				ps.setString(1, ""); //Trebuie verificat daca punem null aici si se incrementeaza automat
				ps.setString(2, client.getNume());
				ps.setString(3, client.getPrenume());
				ps.setString(4, client.getEmail());
				ps.setString(5, client.getPassword());
			 	
				try(ResultSet rs = ps.executeQuery()){
			 		
					return true;
			 		
			 	} catch (SQLException ex) {
			             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
			             return false;
			        }
		} catch (SQLException ex)  {
			Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}
	
	public static boolean loginValidation (String email, String password) {
		
		String query = "Select count(*) from clienti where email = ? and password = ?";
		
		try(Connection connection = DriverManager.getConnection(connectionLink);
				PreparedStatement ps = connection.prepareStatement(query)){
			 	
				ps.setString(1, email); //Trebuie verificat daca punem null aici si se incrementeaza automat
				ps.setString(1, password);
				
				try(ResultSet rs = ps.executeQuery()){
					if(!rs.next() && rs.getInt(1) == 1) {
						return true;
					}else {
						return false;
					}
			 		
			 	} catch (SQLException ex) {
			             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
			             return false;
			        }
		} catch (SQLException ex)  {
			Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
		
	}
	
	public static List<DetaliiProdus> getListaProduse(String tipProdus){
		
		String query = "Select * from produse where tip_produs = ?"; //De verificat si aici
		
		List<DetaliiProdus> listaProduse= new ArrayList<>();
		String nume,tip;
		double pret;
		
		try(Connection connection = DriverManager.getConnection(connectionLink);
				PreparedStatement ps = connection.prepareStatement(query)){
			 	
				ps.setString(1, tipProdus); 
				
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						nume = rs.getString(2);
			 			pret = rs.getDouble(3);
			 			tip = rs.getString(4);
				 		DetaliiProdus produs = new DetaliiProdus(nume,tip,pret);
				 		listaProduse.add(produs);
						
					}
			 		
			 	} catch (SQLException ex) {
			             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);	             
			        }
		} catch (SQLException ex)  {
			Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
		}
		finally {
			return listaProduse;
		}
		
	}
	

//	public static void main(String args[]) {
//		System.out.println("Da");
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//
//			Connection con = DriverManager.getConnection("jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2240093",
//					"sql2240093", "cC6!xF7*");
//			// here sonoo is the database name, root is the username and root is the
//			// password
//			Statement stmt = con.createStatement();
//
//			ResultSet rs = stmt.executeQuery("select * from clienti");
//
//			while (rs.next())
//				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//
//			con.close();
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//	}
	
}