package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		 app.homeMenu();
		  int option = 0;
		  Scanner input = new Scanner(System.in);
		  option = input.nextInt();
		  do {
		  switch (option) {
		  case 1:
			  System.out.print("Enter a film ID");
			  int filmId = input.nextInt();
			  app.db.findFilmById(filmId);
			  app.homeMenu();
			  option = input.nextInt();
			 break;
		  case 2:
			  System.out.println("Please enter a keyword");
			  String keyword = input.nextLine();
			  break;
		  case 3:
			  System.out.println("You have decided to exit. Goodbye!");
			  break;
			default:
				System.out.println("That is not an option, please re-enter option 1-3.");
				break;
		  }}while(option != 3);
//    app.test();
//		app.launch();

	}
	

	private void test() throws SQLException {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

//	private void launch() {
//		Scanner input = new Scanner(System.in);
//
//		startUserInterface(input);
//
//		input.close();
//	}

	private void startUserInterface(Scanner input) {
//	  int filmId = 0;
//	  int option = 0;
//	  while(option != 3) {
//		 homeMenu();
//	option = input.nextInt();
//	  switch (option) {
//	  case 1:
//		  System.out.print("Enter a film ID");
//		  filmId = input.nextInt();
//		  findFilmById(filmId);
//		  if(app.findFilmById(filmId) = null) {
//			  System.out.println("There are no films with that id. Please make a new selection.");
//		  }
//		  else
//		 break;
//	  case 2:
//		  //
//		  break;
//	  case 3:
//		  System.out.println("You have decided to exit. Goodbye!");
//		  break;
//		default:
//			System.out.println("That is not an option, please re-enter option 1-3.");
//			break;
//	  }
	  }

	public void homeMenu() {
		System.out.println("Welcome to the Film Information Application! Please select a menu option.");
		System.out.println("1. Look up a film by its id.");
		System.out.println("2. Look up a film by a search keyword.");
		System.out.println("3. Exit the application. ");
	}
}
