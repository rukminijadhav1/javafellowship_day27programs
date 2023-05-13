package day27Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day22Programming.AddressBook;
import day22Programming.Contact;

public class AddressBookInputOutput {
	private static Scanner s = new Scanner(System.in);
	private static File file = new File("D:/NewFile6");
	static List<Contact1> contact = new ArrayList<>();

	public static void addContact() throws IOException {
		System.out.println("Enter Firstname: ");
		String firstname = s.nextLine();
		System.out.println("Enter Lastname: ");
		String lastname = s.nextLine();
		System.out.println("Enter City: ");
		String city = s.nextLine();
		System.out.println("Enter State: ");
		String state = s.nextLine();
		System.out.println("Enter ZipCode: ");
		String zip = s.nextLine();
		System.out.println("Enter Phone number: ");
		String phoneNumber = s.nextLine();
		System.out.println("Enter EmailId: ");
		String email = s.nextLine();

		Contact1 contact1 = new Contact1(firstname, lastname, city, state, zip, phoneNumber, email);
		addToFile(contact1);
		contact.add(contact1);

		System.out.println("Added person: " + contact1);
		System.out.println();
		showMainMenu();
	}

	private static void addToFile(Contact1 contact) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
			writer.write(contact.toString());
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static boolean readPeopleFromFile() throws IOException {
		List<Contact1> contact = new ArrayList<Contact1>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String name = null;
			while ((name = reader.readLine()) != null) {
				Contact1 contact1 = new Contact1(name, reader.readLine(), reader.readLine(), reader.readLine(),
						reader.readLine(), name, name);
				contact.add(contact1);
				reader.readLine();
			}
			return true;
		} catch (IOException e) {
			System.out.println(e);
		}
		return false;
	}

	public static void printData() throws IOException {
		try {
			Files.lines(new File("").toPath()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

public static void main(String[] args) throws IOException {
	    	
	    	AddressBookInputOutput book = new AddressBookInputOutput();
			Contact c;
	        readPeopleFromFile();
	       book. showMainMenu();
}

	private static void showMainMenu() throws IOException {
		System.out.println("1. Add person");
		System.out.println("2. Show all contacts");
		System.out.println("3. Close program");

		String choice;
		do {
			choice = s.nextLine();
			switch (choice) {
			case "1":
				addContact();
				break;
			case "2":
				printData();
				showMainMenu();
				break;
			case "3":
				System.exit(0);
				break;
			default:
				System.out.println("Enter numer from 1 to 3");
			}
		} while (!choice.equals("3"));
	}

}