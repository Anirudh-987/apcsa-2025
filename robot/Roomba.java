package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba;



	public int cleanRoom(String worldName, int startX, int startY) {

		Robot rob1 = new Robot(startX,startY,North,0);

		World.readWorld(worldName);
		World.setVisible(true);
		// section start - code to move it to starting point

		if (roomba.facingNorth()) {
			roomba.turnLeft();
			while (roomba.frontIsClear())  {
				roomba.move();
			}
			roomba.turnLeft();
			while (roomba.frontIsClear())  {
				roomba.move();
			}
			roomba.turnLeft();
			roomba.turnLeft();
		}
		if (roomba.facingSouth()) {
			
			while (roomba.frontIsClear())  {
				roomba.move();
			}
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.turnLeft();
			while (roomba.frontIsClear())  {
				roomba.move();
			}
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.turnLeft();
		}
		if (roomba.facingEast()) {
			roomba.turnLeft();
			roomba.turnLeft();
			while (roomba.frontIsClear())  {
				roomba.move();
			}
			roomba.turnLeft();
			while (roomba.frontIsClear())  {
				roomba.move();
			}
			roomba.turnLeft();
			roomba.turnLeft();
		}
		if (roomba.facingWest()) {
			while (roomba.frontIsClear())  {
				roomba.move();
			}
			roomba.turnLeft();
			while (roomba.frontIsClear())  {
				roomba.move();
			}
			roomba.turnLeft();
			roomba.turnLeft();
		}

		// section end

		//section start - code for zigzag
		boolean dirty = true;

		while (dirty) {


			while (roomba.frontIsClear()) {

			roomba.move();

			if (roomba.facingEast()) {
				roomba.turnLeft();
				roomba.move();
				roomba.turnLeft();
			}
			else {
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.move();
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
				// idk how to make a turn right command will that mess up robot plugin?
				
			}

		}
		
		

		}
		
		

		
		


		
	}

int totalBeepers = 0; // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
		return totalBeepers;
	
}
