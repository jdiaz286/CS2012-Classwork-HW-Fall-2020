/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 4
 */

package homework4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MonsterAttack {
	private String monsterName;
	private String attackLocation;
	private double damagesInMillionUSD;
	private Date date;
	public static SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");

	// constructor for MonsterAttack
	public MonsterAttack(String name, String place, double damage, Date dateAttacked) {
		monsterName = name;
		attackLocation = place;
		damagesInMillionUSD = damage;
		date = dateAttacked;
	}

	// getters and setters for MonsterAttack
	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String newMonsterName) {
		monsterName = newMonsterName;
	}

	public String getAttackLocation() {
		return attackLocation;
	}

	public void setAttackLocation(String newAttackLocation) {
		monsterName = newAttackLocation;
	}

	public double getDamages() {
		return damagesInMillionUSD;
	}

	public void setDamages(double newDamagesInMillionUSD) {
		damagesInMillionUSD = newDamagesInMillionUSD;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date newDate) {
		date = newDate;
	}

	public String toString() {
		return "Monster Name: " + monsterName + "\nLocation Attacked: " + attackLocation
				+ "\nDamage done (Million USD): " + damagesInMillionUSD + "\nDate attacked: " + sdf.format(date);
	}
}

