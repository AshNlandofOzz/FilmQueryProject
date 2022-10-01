package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();

	}
	

	private void test() throws SQLException {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() throws SQLException {
		homeMenu();
	  int option = 0;
	  Scanner input = new Scanner(System.in);
	  option = input.nextInt();
	  do {
	  switch (option) {
	  case 1:

		  System.out.print("Enter a film ID");
		  int filmId = input.nextInt();
		  Film film = db.findFilmById(filmId);
		  if (film != null) {
			    System.out.println("Title: " + film.getTitle());
			    System.out.println("Release Year: " + film.getReleaseYear());
			    System.out.println("Rating: " + film.getRating());
			    System.out.println("Description: " + film.getDescription());
			    System.out.println("Language: " + film.getLanguage());
			  } else { 
			  System.out.println("No such film in database");
		  }
		  homeMenu();
		  option = input.nextInt();
		 break;
	  case 2:
		  System.out.println("Please enter a keyword");
		  String keyword = input.next();
		  ArrayList<Film> films = db.findByKeyword(keyword);
		  for (Film film2 : films) {
			  
		  if (films.size() != 0) {
			    System.out.println("Title: " + film2.getTitle());
			    System.out.println("Release Year: " + film2.getReleaseYear());
			    System.out.println("Rating: " + film2.getRating());
			    System.out.println("Description: " + film2.getDescription());
			    System.out.println("Language: " + film2.getLanguage());
			  } else { 
			  System.out.println("No such film in database");
		  }}
		  homeMenu();
		  option = input.nextInt();
		  break;
	  case 3:
		  System.out.println("You have decided to exit. Goodbye!");
		  break;
		default:
			System.out.println("That is not an option, please re-enter option 1-3.");
			break;
	  }}while(option != 3);

		input.close();
	}

	private void startUserInterface(Scanner input) {

	  }

	public void homeMenu() {
		System.out.println("Welcome to the Film Information Application! Please select a menu option.");
		System.out.println("1. Look up a film by its id.");
		System.out.println("2. Look up a film by a search keyword.");
		System.out.println("3. Exit the application. ");
	}
}
