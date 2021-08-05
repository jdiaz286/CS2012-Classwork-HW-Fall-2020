/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 2
 */

package homework2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AttackMonitor {
	public static Scanner input = new Scanner(System.in);
	public static SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");

	public static void main(String[] args) {
		// code to show that all the methods work
		MonsterAttack[] myAttacks = reportAttacks();
		menu(myAttacks);
		showAttacks(myAttacks);
		showDamages(myAttacks);
		showMonsters(myAttacks);
		findEarliestAttack(myAttacks);
		menu(myAttacks);
	}

	public static MonsterAttack[] reportAttacks() {
		MonsterAttack[] arrayOfAttacks = new MonsterAttack[5];
		for (int currentAttack = 0; currentAttack < arrayOfAttacks.length; currentAttack++) {
			System.out.println("Attack " + (currentAttack + 1));
			System.out.print("Type in the monster name: ");
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
			// the bottom is to ignore the error thrown because Date is a deprecated method
			@SuppressWarnings("deprecation")
			Date attackDate = new Date(attackYear, attackMonth, attackDay);

			// attackDate.set(attackYear,attackMonth,attackDay);
			arrayOfAttacks[currentAttack] = new MonsterAttack(monsterName, attackLocation, damage, attackDate);
			System.out.println();
		}
		return arrayOfAttacks;
	}

	public static void showAttacks(MonsterAttack[] arrayOfAttacks) {
		for (int currentAttack = 0; currentAttack < arrayOfAttacks.length; currentAttack++) {
			System.out.println("Attack " + (currentAttack + 1) + " details");
			System.out.println(arrayOfAttacks[currentAttack].toString());
			System.out.println();
		}
	}

	public static void showDamages(MonsterAttack[] arrayOfAttacks) {
		System.out.println("Damages");
		double sumOfDamages = 0.0;
		for (int currentAttack = 0; currentAttack < arrayOfAttacks.length; currentAttack++) {
			sumOfDamages += arrayOfAttacks[currentAttack].getDamages();
		}
		System.out.println("Total amount of damages: " + sumOfDamages);
		double meanOfDamages = sumOfDamages / arrayOfAttacks.length;
		System.out.println("Mean damages: " + meanOfDamages);
		System.out.println();

	}

	public static void showMonsters(MonsterAttack[] arrayOfAttacks) {
		System.out.println("Amount of times each monster attacked");
		// this array of Strings calls the reference to the array passed by the method
		// getUniqueMonsterNames() which is a helper method
		String[] monsterNames = getUniqueMonsterNames(arrayOfAttacks);
		for (int i = 0; i < monsterNames.length; i++) { // this for loop goes through the names that were extracted from
														// arrayOfAttacks
			int numberOfAttacks = 0;
			String nameFromMonsterNames = monsterNames[i];
			if (nameFromMonsterNames != null) {
				for (int j = 0; j < arrayOfAttacks.length; j++) { // this loop goes each attack, gets the name of
																	// monster at specific index and compares it to
																	// index of monsterNames
					String extractedName = arrayOfAttacks[j].getMonsterName();
					if (nameFromMonsterNames.equals(extractedName)) {
						numberOfAttacks++;
					}
				}
				System.out.println(nameFromMonsterNames + " attacked " + numberOfAttacks + " times.");
			}
		}
		System.out.println();

	}

	public static void findEarliestAttack(MonsterAttack[] arrayOfAttacks) {
		System.out.println("Earliest Attack: ");
		Date[] arrayOfDates = new Date[arrayOfAttacks.length];
		for (int i = 0; i < arrayOfAttacks.length; i++) {
			arrayOfDates[i] = arrayOfAttacks[i].getDate();
		}
		Date earliestAttack = arrayOfDates[0];
		int indexOfEarliestAttack = 0;
		for (int j = 1; j < arrayOfDates.length; j++) {
			if (earliestAttack.before(arrayOfDates[j]) == false) {
				earliestAttack = arrayOfDates[j];
				indexOfEarliestAttack = j;
			}
		}
		System.out.println(arrayOfAttacks[indexOfEarliestAttack].toString());
		System.out.println();
	}

	public static void menu(MonsterAttack[] arrayOfAttacks) {
		System.out.println("Menu");
		System.out.println("1.) Report Attacks");
		System.out.println("2.) Show Attacks");
		System.out.println("3.) Show Damages");
		System.out.println("4.) Show Monsters");
		System.out.println("5.) Find Earliest Attack");
		System.out.print("Choose which of the following options you would like (1-5), press any other key to quit: ");
		System.out.println();
		int userChoice = input.nextInt();
		while (userChoice >= 1 && userChoice <= 5) {
			System.out.println("Menu");
			System.out.println("1.) Report Attacks");
			System.out.println("2.) Show Attacks");
			System.out.println("3.) Show Damages");
			System.out.println("4.) Show Monsters");
			System.out.println("5.) Find Earliest Attack");
			System.out.print("Choose which of the following options you would like (1-5), press any other key to quit: ");
			System.out.println();

			userChoice = input.nextInt();
			switch (userChoice) {
			case 1:
				arrayOfAttacks = reportAttacks();
				break;
			case 2:
				showAttacks(arrayOfAttacks);
				break;
			case 3:
				showDamages(arrayOfAttacks);
				break;

			case 4:
				showMonsters(arrayOfAttacks);
				break;

			case 5:
				findEarliestAttack(arrayOfAttacks);
				break;

			default:
				System.out.println("Thank you! ");
				break;
			}
		}
	}

	// helper method to find all the different names of monsters and return them in
	// an array
	public static String[] getUniqueMonsterNames(MonsterAttack[] arrayOfAttacks) {
		String[] arrayOfMonsterNames = new String[5];
		for (int i = 0; i < arrayOfAttacks.length; i++) {
			boolean isDistinct = false;
			for (int j = 0; j < i; j++) {
				if (arrayOfAttacks[i].getMonsterName().equals(arrayOfAttacks[j].getMonsterName())) {
					isDistinct = true;
					break;
				}
			}
			if (!isDistinct) {
				arrayOfMonsterNames[i] = arrayOfAttacks[i].getMonsterName();
			}
		}

		return arrayOfMonsterNames;
	}

}
