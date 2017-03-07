import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; // import java.util.*;

public class HelloFriends {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		String nelleke = ("Nelleke");

		if (name.equals(nelleke)) {
			System.out.println("Welkom terug Nelleke!");
		}

		Scanner output = null;

		try {
			output = new Scanner(new File("friends.txt")); // leest het bestand
															// met alle namen
															// erin
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		String naam = "naam";
		while (output.hasNextLine()) {
			naam = output.nextLine(); // hier krijg ik een error, hij geeft aan
										// dat hij de line niet kan vinden
			System.out.println(naam);
		}
		output.close();

		Scanner friendsOutput = null;
		String fileName = (name + ".txt");
		try {

			friendsOutput = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		input.close();

	}
}
