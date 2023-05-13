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

public class AddressBOOkChecking {
	static String f_name;
	private static File file = new File("");
	static ArrayList<Contact1> list = new ArrayList<Contact1>();
	static Scanner s = new Scanner(System.in);

	public void Add_Contact() {
		Scanner s = new Scanner(System.in);
		System.out.print("Add Contact  \n");
		System.out.print("Enter First Name: ");
		String firstname=s.next();
		
		System.out.print("Enter Last Name : ");
		String lasttname=s.next();
		
		System.out.print("Enter City : ");
		String city=s.next();
		
		
		System.out.print("Enter State : ");
		String state=s.next();
		
		System.out.print("Enter zip : ");
		String zip=s.next();
		
		System.out.print("Enter PhoneNumber: ");
		String phone=s.next();
		
		System.out.print("Enter Email ID : ");
		String email=s.next();
		
		
		
	}

	private static void addToFile(Contact1 contact) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
			writer.write(contact.toString());
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void Display_All() {
		boolean is_Empty = list.isEmpty();
		if (is_Empty == true)
			System.out.println("Array List is Empty");
		else
			System.out.println(list);
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

	public void deleteContact(Contact1 c, String f_name) {
		for (int i = 0; i < list.size(); i++) {
			c = (Contact1) list.get(i);
			if (f_name.equals(c.getFirstName())) {
				list.remove(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		 AddressBOOkChecking book1 = new  AddressBOOkChecking();
		Contact1 c;

		int option;
		do {
			System.out.println("Enter your option : ");
			System.out.println("1.Add contact  ");
			System.out.println("2.Display all contact ");
			System.out.println("3.Edit Contact ");
			System.out.println("4.Delete Contact ");

			option = s.nextInt();
			c = new Contact1(f_name, f_name, f_name, f_name, f_name, f_name, f_name);
			Scanner sc = new Scanner(System.in);

			switch (option) {
			case 1:
				book1.Add_Contact();
				break;
			case 2:
				book1.Display_All();
				break;
			case 3:
				System.out.println("Enter first name that you want to edit:");
				f_name = sc.nextLine();
				book1.readPeopleFromFile();
				break;
			case 4:
				System.out.println("Enter first name that you want to edit:");
				f_name = sc.nextLine();
				book1.deleteContact(c, f_name);
				break;
			default:
				System.out.println("Enter valid option");
				break;
			}
			System.out.println("Do you want to continue (1.Continue or 0.Exit)");
			option = s.nextInt();
		} while (option != 0);
	}

}
