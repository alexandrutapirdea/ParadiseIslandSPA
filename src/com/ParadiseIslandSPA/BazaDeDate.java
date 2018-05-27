package com.ParadiseIslandSPA;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class BazaDeDate {

	private static String connectionLink = "jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2240093\",\"sql2240093\",\"cC6!xF7*";

	private BazaDeDate() {
	}

	public static DetaliiProdus getNumeProdusById(String idProdus) {
		
		PreparedStatement ps ;
		ResultSet rs ;
		DetaliiProdus produs;
		String nume,tip;
		double pret;
		
		try(Connection connection = DriverManager.getConnection(connectionLink);
			ps = connection.prepareStatement("SELECT * FROM produse WHERE id_produs=?")){
			 	ps.setString(1, idProdus);
			 	try(rs = ps.executeQuery()){
			 		
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
		        }
		
		
	}

	public static void main(String args[]) {
		System.out.println("Da");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2240093",
					"sql2240093", "cC6!xF7*");
			// here sonoo is the database name, root is the username and root is the
			// password
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from clienti");

			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}