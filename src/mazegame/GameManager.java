package mazegame;

import java.util.Scanner;

public class GameManager {
	private Room position;  // where the player is right now
	private Building building;   // where we are traveling through
	public int hcq = 100; // player's health points
	
	public GameManager(Building bldg) {
		building = bldg;
	}
	/**
	 * returns the outcome of moving in direction dir
	 * @param dir - N, S, E, or W
	 * @return a string that describes what happened - might embellish
	 */
	public String move(String dir) {
		Room newPosition = building.getRoom(position, dir);
		if (newPosition == null) {  					// dead end
			return "\nYou can't move in that direction.";
		} else {
			position = building.getRoom(position,dir); 
			return "\nYou are now in " + position.getName() + "\n" +  position.getDescription();
		}
	}
	
	public void failure() {
		System.out.println("YOU HAVE SUCCUMBED TO THE 5G.");
	}
	
	public void success() {
		System.out.println("YOU FIND A BIG METAL BOX LABELLED 'COVID-19 TRANSMITTER' AND SMASH IT.");
		System.out.println("'*Transmission from Q* \n'Tremendous job Patriot. You have saved America");
		System.out.println("from the Deep State. Now President Trump can carry on with his mission to defeat Soros...'");
	}
	
	/**
	 * Updates the player's position based on the player's keyboard entries.
	 * @param bldg - remove in future versions b/c we already have one associated
	 */
	public void play(Building bldg) {
		Scanner sc = new Scanner(System.in);
		position = bldg.findRoomByName("entrance");  // must have a room called this
		if (position == null) {
			System.out.println("Invalid starting position. One of the rooms must be named 'entrance'.");
		} else {
			String dir = "";
			while (!dir.equals("Q")) {
				if (hcq <= 0) {
					failure();
					break;
				}
				if (position.getGoalStatus()==true) {
					success();
					break;
				}
				if (position.getRoomHcq() != 0) {
					if (position.getRoomHcq()>0) {
						System.out.println("You found +" + Integer.toString(position.getRoomHcq()) + "HCQ!");
						position.setRoomHcq(0); // gets rid of HCQ after player uses it
					} else {
						System.out.println("Get out of there! There's a 5G emitter in here! You lost " 
								+ Integer.toString(position.getRoomHcq()) + "HCQ!");
					}
				}
				hcq += position.getRoomHcq();
				System.out.print("HCQ: " + hcq);
				System.out.print("\nEnter direction (N, S, E, W, or Q to quit): ");
				dir = sc.nextLine().toUpperCase().trim();
				if (!dir.equals("Q")) {
					System.out.println(move(dir));
				}
			}
		}
	}
}