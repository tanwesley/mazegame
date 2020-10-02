package mazegame;

import java.util.Scanner;

public class MazeApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String keepPlaying = "y"; // controls if player wants to keep playing the game
		
		System.out.println("Q Q Q Q Q Q ============================");
		System.out.println(" Q Q Q Q Q Q============================");
		System.out.println("Q Q Q Q Q Q ============================");
		System.out.println(" Q Q Q Q Q Q============================");
		System.out.println("Q Q Q Q Q Q ============================");
		System.out.println(" Q Q Q Q Q Q============================");
		System.out.println("========================================");
		System.out.println("========================================");
		System.out.println("========================================");
		System.out.println("========================================");
		System.out.println("========================================");
		System.out.println("========================================");
		System.out.println("\n");
		System.out.println("\n*BEGIN MISSION BRIEFING* \nGreetings fellow Patriot, this is Q speaking. \nAs we all know by now, this so-called"
				+ " coronavirus pandemic \nis nothing more than a lie perpetuated by the Deep State"
				+ "\nto pacify the public and subvert the President's noble crusade \nagainst the Satanic vampire elites. "
				+ "5G signals have been detected \nfrom Center for Disease Control HQ. I need you to "
				+ "infiltrate \nCDCHQ and find out the truth, so that we can expose the evil lies \nof the Deep State,"
				+ "and restore our God-ordained Constitutional right \nto go to Target unmuzzled from these mind-control masks.");
		System.out.println("\nYou will be given a supply of hydroxychloroquine (HCQ), should you fall \nill in your mission. This will be your lifeline against"
				+ " whatever \nhorrors lie inside. Once your HCQ falls to zero, you'll be naked to whatever \nattacks they throw at you. We have no map of the facility, "
				+ "so I'm afraid you're \ngoing in blind, Patriot. The Day of Reckoning draws nearer... "
				+ "We are counting on you...");
		System.out.println("\nGood luck, godspeed, and remember....");
		System.out.println("W H E R E    W E    G O    O N E, \n      W E    G O    A L L \n\n - Q signing off...\n\n"); 
		
		
		do {
			Building bldg = BuildingBuilder.buildFromFile("my_home.txt");
			GameManager gm = new GameManager(bldg);
			gm.play(bldg);	
			System.out.println("Enter y to keep playing. Hit enter to quit.");
			keepPlaying = sc.nextLine();
		} 
		while (keepPlaying.equalsIgnoreCase("y"));
		
		System.out.println("Exiting game...");
	}
}