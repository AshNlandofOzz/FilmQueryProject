package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
	
  public Film findFilmById(int filmId) throws SQLException;
  public ArrayList<Actor> findActorById(int actorId) throws SQLException;
  public ArrayList<Actor> findActorsByFilmId(int filmId) throws SQLException;
  public ArrayList<Film> findByKeyword(String keyword) throws SQLException;
  
}
