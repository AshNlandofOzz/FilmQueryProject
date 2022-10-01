package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	
  @Override
  public Film findFilmById(int filmId) throws SQLException {
	  Film film = null;
	  String user = "student";
	    String pass = "student";
	    Connection conn = DriverManager.getConnection(URL,user,pass);
	    
	    String sql = "SELECT film.id, film.title, film.description, film.release_year, "
	    		+ "film.language_id, film.rental_duration, film.rental_rate, film.length, "
	    		+ "film.replacement_cost, film.rating, film.special_features,  language.name "
	    		+ "FROM film JOIN language ON film.language_id = language.id "
	    		+ "WHERE film.id = ?";
		  PreparedStatement stmt = conn.prepareStatement(sql);
		  stmt.setInt(1,filmId);
		  
		  ResultSet filmResult = stmt.executeQuery();
		  
		  if (filmResult.next()) {
		    film = new Film(); 
		    film.setId(filmResult.getInt("id"));
		    film.setTitle(filmResult.getString("Title"));
		    film.setDescription(filmResult.getString("description"));
		    film.setReleaseYear(filmResult.getString("release_year"));
		    film.setLanguageId(filmResult.getInt("language_id"));
		    film.setRentalDuration(filmResult.getInt("rental_duration"));
		    film.setRentalRate(filmResult.getDouble("rental_rate"));
		    film.setLength(filmResult.getDouble("length"));
		    film.setReplacementCost(filmResult.getDouble("replacement_cost"));
		    film.setRating(filmResult.getString("rating"));
		    film.setSpecialFeatures(filmResult.getString("special_features"));
		    film.setLanguage(filmResult.getString("name"));
		    //actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
		    
		  }
		  

	  return film;
  }
  
  @Override
  public ArrayList<Film> findByKeyword(String keyword) throws SQLException {
	  Film film = null;
	  ArrayList<Film> films = new ArrayList();
	  String user = "student";
	    String pass = "student";
	    Connection conn = DriverManager.getConnection(URL,user,pass);
	    
	    String sql = "SELECT film.id, film.title, film.description, film.release_year, "
	    		+ "film.language_id, film.rental_duration, film.rental_rate, film.length, "
	    		+ "film.replacement_cost, film.rating, film.special_features,  language.name "
	    		+ "FROM film JOIN language ON film.language_id = language.id "
	    		+ "WHERE title LIKE ?  OR description LIKE ?";
		  PreparedStatement stmt = conn.prepareStatement(sql);
		  stmt.setString(1,"%" + keyword + "%");
		  stmt.setString(2,"%" + keyword + "%");
		  
		  ResultSet filmResult = stmt.executeQuery();
		  
		  
		  while (filmResult.next()) {
		    film = new Film(); 
		    film.setId(filmResult.getInt("id"));
		    film.setTitle(filmResult.getString("Title"));
		    film.setDescription(filmResult.getString("description"));
		    film.setReleaseYear(filmResult.getString("release_year"));
		    film.setLanguageId(filmResult.getInt("language_id"));
		    film.setRentalDuration(filmResult.getInt("rental_duration"));
		    film.setRentalRate(filmResult.getDouble("rental_rate"));
		    film.setLength(filmResult.getDouble("length"));
		    film.setReplacementCost(filmResult.getDouble("replacement_cost"));
		    film.setRating(filmResult.getString("rating"));
		    film.setSpecialFeatures(filmResult.getString("special_features"));
		    film.setLanguage(filmResult.getString("name"));
		    //actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
		    films.add(film);
		  }

	return films;
  }
	  

@Override
public ArrayList<Actor> findActorsByFilmId(int filmId) throws SQLException {
	  ArrayList<Actor> actors = new ArrayList();
	  Actor actor = null;
	  String user = "student";
	    String pass = "student";
	    Connection conn = DriverManager.getConnection(URL,user,pass);
	    
		  String sql = "SELECT actor.id, actor.first_name, actor.last_name, film.title "
		  		+ "FROM  actor JOIN film_actor ON actor.id = film_actor.actor_id "
		  		+ "JOIN film ON film_actor.film_id = film.id "
		  		+ "WHERE film_id = ?";
		  PreparedStatement stmt = conn.prepareStatement(sql);
		  stmt.setInt(1,filmId);
		  
		  ResultSet actorResult = stmt.executeQuery();
		  
		  while (actorResult.next()) {
		    actor = new Actor(); // Create the object
		    // Here is our mapping of query columns to our object fields:
		    actor.setId(actorResult.getInt("id"));
		    actor.setFirstName(actorResult.getString("first_name"));
		    actor.setLastName(actorResult.getString("last_name"));
		   // actor.setFilms(findFilmsByActorId(actor.id)); // An Actor has Films
		    actors.add(actor);
		  }
		  
		  return actors;
		}


}
