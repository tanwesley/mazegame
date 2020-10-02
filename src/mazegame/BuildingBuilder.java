package mazegame;

import java.io.File;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class BuildingBuilder {
	public static Building buildFromFile(String fname) {
		File f = new File(fname);
		return buildFromFile(f);
	}
	public static Building buildFromFile(File f) {
		Random rand = new Random();
		try {
			Scanner fsc = new Scanner(f);
			String line;
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<String> descs = new ArrayList<String>();
			ArrayList<String> norths = new ArrayList<String>();
			ArrayList<String> souths = new ArrayList<String>();
			ArrayList<String> easts = new ArrayList<String>();
			ArrayList<String> wests = new ArrayList<String>();
			ArrayList<Integer> roomHcqs = new ArrayList<Integer>(); // Room attributes (gain or lose health)
			String[] parts;
			Room rm;
			Building bldg = new Building();
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();
				if (line.length() > 0) {
					parts = line.split("\t");
					names.add(parts[0]);
					descs.add(parts[1]);
					rm = new Room(parts[0],parts[1],Integer.parseInt(parts[6]));
					bldg.addRoom(rm);
					norths.add(parts[2]);
					souths.add(parts[3]);
					easts.add(parts[4]);
					wests.add(parts[5]);
					roomHcqs.add(Integer.parseInt((parts[6])));
				}
			}
			int roomNum = 0;
			ArrayList<Room> allRooms = bldg.getRooms();
			for (Room room : allRooms) {
				bldg.setNeighborsByName(room,norths.get(roomNum),souths.get(roomNum),easts.get(roomNum),wests.get(roomNum));
				roomNum++;
			}
			allRooms.get(rand.nextInt(allRooms.size())+1).setRoomAsGoal(); // sets random room as the goal room
			fsc.close();
			return bldg;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
}