/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 4
 */

package homework4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class AttackMonitor {
	public static Scanner input = new Scanner(System.in);
	public static SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
	public static ArrayList<MonsterAttack> listOfAttacks = new ArrayList<MonsterAttack>();

	public static void main(String[] args) throws IOException, ParseException {
		menu();
	}

	public static ArrayList<MonsterAttack> reportAttacks() {
		System.out.println("Type in the number of monsters that you would like to add: ");
		int amountOfMonstersToAdd = input.nextInt();
		for (int currentAttack = 0; currentAttack < amountOfMonstersToAdd; currentAttack++) {
			System.out.println("Attack " + (currentAttack + 1));
			System.out.print("Type in the monster name: ");
			input.nextLine(); // this line is to fix a bug that occurs
			String monsterName = input.nextLine();
			System.out.print("Type in the attack location: ");
			String attackLocation = input.nextLine();
			System.out.print("Type in the damage caused (in Millions of USD): ");
			double damage = input.nextDouble();
			input.nextLine(); // this line is to fix a bug that occurs after the previous nextDouble() line
			System.out.print("Type in the Month of the attack (MM): ");
			int attackMonth = input.nextInt() - 1;
			System.out.print("Type in the Day of the attack (dd): ");
			int attackDay = input.nextInt();
			System.out.print("Type in the Year of the attack (yyyy): ");
			int attackYear = input.nextInt() - 1900;
			input.nextLine();
			@SuppressWarnings("deprecation")
			Date attackDate = new Date(attackYear, attackMonth, attackDay);

			MonsterAttack attackToAdd = new MonsterAttack(monsterName, attackLocation, damage, attackDate);
			listOfAttacks.add(attackToAdd);
			System.out.println();
		}
		return listOfAttacks;
	}

	public static void showAttacks(ArrayList<MonsterAttack> listOfAttacks) {
		for (int currentAttack = 0; currentAttack < listOfAttacks.size(); currentAttack++) {
			System.out.println("Attack " + (currentAttack + 1) + " details");
			System.out.println(listOfAttacks.get(currentAttack).toString());
			System.out.println();
		}
	}

	public static void showDamages(ArrayList<MonsterAttack> listOfAttacks) {
		System.out.println("Damages");
		double sumOfDamages = 0.0;
		for (int currentAttack = 0; currentAttack < listOfAttacks.size(); currentAttack++) {
			sumOfDamages += listOfAttacks.get(currentAttack).getDamages();
		}
		System.out.println("Total amount of damages: " + sumOfDamages);
		double meanOfDamages = sumOfDamages / listOfAttacks.size();
		System.out.println("Mean damages: " + meanOfDamages);
		System.out.println();

	}

	public static void showMonsters(ArrayList<MonsterAttack> listOfAttacks) {
		System.out.println("Amount of times each monster attacked");
		// this array of Strings calls the reference to the array passed by the method
		// getUniqueMonsterNames() which is a helper method
		String[] monsterNames = getUniqueMonsterNames(listOfAttacks);
		for (int i = 0; i < monsterNames.length; i++) { // this for loop goes through the names that were extracted from
														// listOfAttacks
			int numberOfAttacks = 0;
			String nameFromMonsterNames = monsterNames[i];
			if (nameFromMonsterNames != null) {
				for (int j = 0; j < listOfAttacks.size(); j++) { // this loop goes each attack, gets the name of
																	// monster at specific index and compares it to
																	// index of monsterNames
					String extractedName = listOfAttacks.get(j).getMonsterName();
					if (nameFromMonsterNames.equals(extractedName)) {
						numberOfAttacks++;
					}
				}
				System.out.println(nameFromMonsterNames + " attacked " + numberOfAttacks + " times.");
			}
		}
		System.out.println();

	}

	public static void findEarliestAttack(ArrayList<MonsterAttack> listOfAttacks) {
		System.out.println("Earliest Attack: ");
		Date[] arrayOfDates = new Date[listOfAttacks.size()];
		for (int i = 0; i < listOfAttacks.size(); i++) {
			arrayOfDates[i] = listOfAttacks.get(i).getDate();
		}
		Date earliestAttack = arrayOfDates[0];
		int indexOfEarliestAttack = 0;
		for (int j = 1; j < arrayOfDates.length; j++) {
			if (earliestAttack.before(arrayOfDates[j]) == false) {
				earliestAttack = arrayOfDates[j];
				indexOfEarliestAttack = j;
			}
		}
		System.out.println(listOfAttacks.get(indexOfEarliestAttack).toString());
		System.out.println();
	}

	public static void menu() throws IOException, ParseException {
		printMenu();
		int userChoice = input.nextInt();
		executeChoice(userChoice);
		while (userChoice >= 1 && userChoice <= 8) {
			printMenu();
			userChoice = input.nextInt();
			executeChoice(userChoice);
		}
	}

	// method to add attacks from list to a file
	public static void saveToFile(File outFile) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
		for (MonsterAttack currentAttack : listOfAttacks) {
			String currentAttackName = "Monster Name: " + currentAttack.getMonsterName();
			String currentAttackLocation = "Location Attacked: " + currentAttack.getAttackLocation();
			String currentAttackDamage = "Damage Done: " + currentAttack.getDamages();
			String curretnAttackDate = "Date Attacked: " + sdf.format(currentAttack.getDate());
			String lineToAdd = currentAttackName + ", " + currentAttackLocation + ", " + currentAttackDamage + ", "
					+ curretnAttackDate;
			writer.write(lineToAdd);
			writer.newLine();
		}
		System.out.println("Successfully saved to typed in file");
		System.out.println();
	}
	
	// method to retrieve a file
	public static void retrieveFile() throws IOException, ParseException {
		try {
			System.out.print("Make sure that each line is in the format: Monster name, Attack location, Damage dealt, and Date of attack. ");
			System.out.println("Enter a filepath to read from: ");
			File inFile = new File(input.next()); // File to read from.
			Scanner freader = new Scanner(inFile);

			String line="";
			String[] fields;
			String name;
			String location;
			double damage;
			Date date;

			while (freader.hasNextLine()) {
				line = freader.nextLine();
				fields = line.split(",");
				name = fields[0];
				location= fields[1];
				damage = Double.parseDouble(fields[2]);
				date=new SimpleDateFormat("MM/DD/yyyy").parse(fields[3]);
				listOfAttacks.add(new MonsterAttack(name, location, damage, date));
			}
			
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}

	// method to clear the list of attacks
	public static void clearList() {
		for (MonsterAttack currentAttack : listOfAttacks) {
			listOfAttacks.remove(currentAttack);
		}
		System.out.println("Successfully removed all attacks from list!");
		System.out.println();
	}

	// helper method to find all the different names of monsters and return them in
	// an array
	public static String[] getUniqueMonsterNames(ArrayList<MonsterAttack> listOfAttacks) {
		String[] arrayOfMonsterNames = new String[5];
		for (int i = 0; i < listOfAttacks.size(); i++) {
			boolean isDistinct = false;
			for (int j = 0; j < i; j++) {
				if (listOfAttacks.get(i).getMonsterName().equals(listOfAttacks.get(j).getMonsterName())) {
					isDistinct = true;
					break;
				}
			}
			if (!isDistinct) {
				arrayOfMonsterNames[i] = listOfAttacks.get(i).getMonsterName();
			}
		}

		return arrayOfMonsterNames;
	}

	public static void printMenu() {
		System.out.println("Menu");
		System.out.println("1.) Report Attacks");
		System.out.println("2.) Show Attacks");
		System.out.println("3.) Show Damages");
		System.out.println("4.) Show Monsters");
		System.out.println("5.) Find Earliest Attack");
		System.out.println("6.) Save to a file");
		System.out.println("7.) Retrieve a file");
		System.out.println("8.) Clear the list of Attacks");
		System.out.print("Choose which of the following options you would like (1-8), press 0 to quit: ");
		System.out.println();
	}

	public static void executeChoice(int userChoice) throws IOException, ParseException {
		switch (userChoice) {
		case 1:
			reportAttacks();
			break;
		case 2:
			showAttacks(listOfAttacks);
			break;
		case 3:
			showDamages(listOfAttacks);
			break;

		case 4:
			showMonsters(listOfAttacks);
			break;

		case 5:
			findEarliestAttack(listOfAttacks);
			break;

		case 6:
			System.out.println("Enter a filepath to save to.");
			File outFile = new File(input.next()); // File to write to
			BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
			try {
				saveToFile(outFile);
			} catch (IOException e) {
				System.err.println(e);
			}
			break;
		case 7:
			try {
				retrieveFile();

			} catch (IOException e) {
				System.err.println(e);
				System.exit(1);
			}
			break;
		case 8:
			clearList();
			break;
		default:
			System.out.println("Program has been terminated. ");
			break;
		}
	}
}

