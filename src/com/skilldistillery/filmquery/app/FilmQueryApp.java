package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
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
		boolean terminate;
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
					System.out.println("Actors: ");
					for (Actor a : db.findActorsByFilmId(filmId)) {
						System.out.println("   " + a.getFirstName() + " " + a.getLastName() + " ");
					}
				} else {
					System.out.println("No such film in database");
				}
				int option2 = 0;
				do {
					subMenu();
					option2 = input.nextInt();
					if (option2 == 5) {
						System.out.println("ID: " + film.getId());
						System.out.println("Title: " + film.getTitle());
						System.out.println("Description: " + film.getDescription());
						System.out.println("Release Year: " + film.getReleaseYear());
						System.out.println("Language ID: " + film.getLanguageId());
						System.out.println("Rental Duration: " + film.getRentalDuration());
						System.out.println("Rental Rate: " + film.getRentalRate());
						System.out.println("Length: " + film.getLength());
						System.out.println("Replacement Cost: " + film.getReplacementCost());
						System.out.println("Rating: " + film.getRating());
						System.out.println("Special Features" + film.getSpecialFeatures());
						System.out.println("Language: " + film.getLanguage());
						System.out.println("Actors: ");
						for (Actor a : db.findActorsByFilmId(filmId)) {
							System.out.println("   " + a.getFirstName() + " " + a.getLastName() + " ");
						}
						System.out.println();
					}
				} while (option2 != 4);
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
						for (Actor a : db.findActorsByFilmId(film2.getId())) {
							System.out.println("   " + a.getFirstName() + " " + a.getLastName() + " ");
						}
						System.out.println();
					} else {
						System.out.println("No such film in database");
					}
				}
				do {
					subMenu();
					option2 = input.nextInt();
					if (option2 == 5) {
						for (Film film2 : films) {
							if (films.size() != 0) {
								System.out.println("ID: " + film2.getId());
								System.out.println("Title: " + film2.getTitle());
								System.out.println("Description: " + film2.getDescription());
								System.out.println("Release Year: " + film2.getReleaseYear());
								System.out.println("Language ID: " + film2.getLanguageId());
								System.out.println("Rental Duration: " + film2.getRentalDuration());
								System.out.println("Rental Rate: " + film2.getRentalRate());
								System.out.println("Length: " + film2.getLength());
								System.out.println("Replacement Cost: " + film2.getReplacementCost());
								System.out.println("Rating: " + film2.getRating());
								System.out.println("Special Features" + film2.getSpecialFeatures());
								System.out.println("Language: " + film2.getLanguage());
								System.out.println();
							}
						}
					}
				} while (option2 != 4);

				homeMenu();
				option = input.nextInt();
				break;
			case 3:
				break;
			default:
				System.out.println("That is not an option, please re-enter option 1-3.");
				homeMenu();
				option = input.nextInt();
				break;
			}
		} while (option != 3);
		System.out.println("You have decided to exit. Goodbye!");
		input.close();
	}

	public void homeMenu() {
		System.out.println("Welcome to the Film Information Application! Please select a menu option.");
		System.out.println("1. Look up a film by its id.");
		System.out.println("2. Look up a film by a search keyword.");
		System.out.println("3. Exit the application. ");
	}

	public void subMenu() {
		System.out.println("Would you like to return to Home Menu or view full details?");
		System.out.println("4. Return to main menu");
		System.out.println("5. View full details");
	}
}
