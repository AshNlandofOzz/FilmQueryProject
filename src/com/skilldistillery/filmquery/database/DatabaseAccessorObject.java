package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

//	  public Customerlister() throws ClassNotFoundException {
//		  Class.forName("com.mysql.cj.jdbc.Driver");
//		}
	
  @Override
  public Film findFilmById(int filmId) throws SQLException {
	  Film film = null;
	  String user = "student";
	    String pass = "student";
	    Connection conn = DriverManager.getConnection(URL,user,pass);
	    
	    String sql = "SELECT id, title, description, release_year, "
	    		+ "language_id, rental_duration, rental_rate, length, "
	    		+ "replacement_cost, rating, special_features "
	    		+ "FROM actor WHERE id = ?";
		  PreparedStatement stmt = conn.prepareStatement(sql);
		  stmt.setInt(1,filmId);
		  
		  ResultSet filmResult = stmt.executeQuery();
		  
		  if (filmResult.next()) {
		    film = new Film(); 
		    film.setId(filmResult.getInt("id"));
		    film.setTitle(filmResult.getString("title"));
		    film.setDescription(filmResult.getString("description"));
		    film.setReleaseYear(filmResult.getString("releaseYear"));
		    film.setLanguageId(filmResult.getInt("languageId"));
		    film.setRentalDuration(filmResult.getInt("rentalDuration"));
		    film.setLength(filmResult.getDouble("length"));
		    film.setReplacementCost(filmResult.getDouble("replacementCost"));
		    film.setRentalRate(filmResult.getDouble("rating"));
		    film.setSpecialFeatures(filmResult.getString("specialFeatures"));
		    //actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
		  }
	  
	  
	  return film;
  }
  
  public Actor findActorById(int actorId) throws SQLException {
	  Actor actor = null;
	  //... proof is left to reader ...
	  String user = "student";
	    String pass = "student";
	    Connection conn = DriverManager.getConnection(URL,user,pass);
	  
	  
	  
	  String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setInt(1,actorId);
	  
	  ResultSet actorResult = stmt.executeQuery();
	  
	  if (actorResult.next()) {
	    actor = new Actor(); // Create the object
	    // Here is our mapping of query columns to our object fields:
	    actor.setId(actorResult.getInt("id"));
	    actor.setFirstName(actorResult.getString("first_name"));
	    actor.setLastName(actorResult.getString("last_name"));
	    //actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
	  }
	  //...
	  return actor;
	}

@Override
public List<Actor> findActorsByFilmId(int filmId) {
	// TODO Auto-generated method stub
	return null;
}

}
