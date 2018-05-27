package com.ParadiseIslandSPA;

import java.sql.*;


class BazaDeDate{
public static void main(String args[]){
	System.out.println("Da");
try{
Class.forName("com.mysql.jdbc.Driver");

Connection con=DriverManager.getConnection("jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2240093","sql2240093","cC6!xF7*");
//here sonoo is the database name, root is the username and root is the password
Statement stmt=con.createStatement();

ResultSet rs=stmt.executeQuery("select * from clienti");

while(rs.next())
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

con.close();

}catch(Exception e){ System.out.println(e);}

}
}