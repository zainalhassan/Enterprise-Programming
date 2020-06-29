package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class FilmDAO 
{
	
	Film oneFilm = null;
	Connection conn = null;
    Statement stmt = null;
	String user = "alhassz";
    String password = "sawpRint4";
    // Note none default port used, 6306 not 3306
    String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/"+user;

	public FilmDAO() {}

	
	private void openConnection(){
		// loading jdbc driver for mysql
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for demos database, username demos, password demos
 			conn = DriverManager.getConnection(url, user, password);
		    stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }	   
    }
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Film getNextFilm(ResultSet rs){
    	Film thisFilm=null;
		try {
			thisFilm = new Film(
					rs.getInt("FilmID"),
					rs.getString("FilmName"),
					rs.getInt("FilmYear"),
					rs.getString("FilmCredits"),
					rs.getInt("FilmDuration"),
					rs.getString("FilmReview"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return thisFilm;		
	}
	
	
	
   public ArrayList<Film> getAllFilms()
   {
	   
		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from film";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	allFilms.add(oneFilm);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilms;
   }

   public Film getFilmByName(String filmName){
	   
		openConnection();
		oneFilm=null;
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from film where FilmName = '" + filmName + "'";
		    System.out.println(selectSQL);
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
   }
   
   public Film getFilmByID(int filmID){
	   
		openConnection();
		oneFilm=null;
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from film where FilmID = '" + filmID + "'";
		    System.out.println(selectSQL);
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
   }
   
   public boolean insertFilm(Film f)
   {
	   openConnection();
	   boolean inserted = false;
	   try
	   {
		   String insertSQL = "INSERT INTO film (FilmName,FilmYear,FilmCredits,FilmDuration,FilmReview) VALUES ('" + f.getFilmName() + "'," + f.getFilmYear() + ",'" + f.getFilmCredits() + "'," + f.getFilmDuration() + ",'" + f.getFilmReview() + "');";
		   System.out.println(insertSQL);
		   
		   stmt.executeUpdate(insertSQL);
		   inserted = true;
		   stmt.close();
		   closeConnection();
	   }
	   catch (SQLException e)
	   {
		   System.out.println(e.getMessage());
	   }
	   return inserted;   
   }
   
   public boolean deleteFilm(int filmID)
   {
	   openConnection();
	   boolean deleted = false;
	   
	   try
	   {
		   String deleteSQL = "DELETE FROM film WHERE FilmID = " + filmID + ";";
		   System.out.println(deleteSQL);
		   
		   stmt.executeUpdate(deleteSQL);
		   deleted = true;
		   System.out.println("Film Deleted");
		   stmt.close();
		   closeConnection();
	   }
	   catch (SQLException e)
	   {
		   System.out.println(e.getMessage());
	   }
	   return deleted;
   }
   
   public boolean updateFilm(Film f)
   {
	   openConnection();
	   boolean updated = false;
	   
	   try
	   {
		   String updateSQL = "UPDATE film SET FilmName = '" + f.getFilmName() + "', FilmYear = " + f.getFilmYear() + ",FilmCredits = '" + f.getFilmCredits() + "', FilmDuration = " + f.getFilmDuration() + ",FilmReview = '" + f.getFilmReview() + "' WHERE FilmID = " + f.getFilmID() + ";";
		   System.out.println(updateSQL);
		   
		   stmt.executeUpdate(updateSQL);
		   updated = true;
		   stmt.close();
		   closeConnection();
	   }
	   catch (SQLException e)
	   {
		   System.out.println(e.getMessage());
	   }
	   return updated;
   }
   
   
   public ArrayList<String> getFilmNames()
   {
		ArrayList<String> allFilmNames= new ArrayList<String>();
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectSQL = "select FilmName from film";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	String filmName = rs1.getString("FilmName");
		    	allFilmNames.add(filmName);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilmNames;
   }
   
   
   public ArrayList<Film> getFilmAttribute(String type, String value) {
		
		System.out.println("Getting Film By Name ...\n");
		ArrayList<Film> filmsList = new ArrayList<>();
		openConnection();
		try {
			String selectFilmByAttribute = "SELECT * FROM film where " + type + " LIKE '" + "%" + value + "%" + "' ;"; 
			System.out.println(selectFilmByAttribute);
			ResultSet rs = stmt.executeQuery(selectFilmByAttribute);
			System.out.println("selectFilmByAttribute Query - Status = Successful\n");
			while (rs.next()) {
				oneFilm = getNextFilm(rs);
				filmsList.add(oneFilm);
			}
			stmt.close();
			closeConnection();
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("selectFilmByAttribute Query - Status = Failed");
		}
		return filmsList;
		
	}
}
