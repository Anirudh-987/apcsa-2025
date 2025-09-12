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

// All changes below

	public int cleanRoom(String worldName, int startX, int startY) {

		Robot rob1 = new Robot(7,6,North,0);
		int beepersInPossession = 0;
		int distanceTraveled_area = 0;
		World.setDelay(5);

		World.readWorld(worldName);
		World.setVisible(true);
		// section start - code to move it to a predictable starting point

		if (rob1.facingNorth()) {
			rob1.turnLeft();
			while (rob1.frontIsClear())  {
				rob1.move();
			}
			rob1.turnLeft();
			while (rob1.frontIsClear())  {
				rob1.move();
			}
			rob1.turnLeft();
			rob1.turnLeft();
		}
		if (rob1.facingSouth()) {
			
			while (rob1.frontIsClear())  {
				rob1.move();
			}
			rob1.turnLeft();
			rob1.turnLeft();
			rob1.turnLeft();
			while (rob1.frontIsClear())  {
				rob1.move();
			}
			rob1.turnLeft();
			rob1.turnLeft();
			rob1.turnLeft();
		}
		if (rob1.facingEast()) {
			rob1.turnLeft();
			rob1.turnLeft();
			while (rob1.frontIsClear())  {
				rob1.move();
			}
			rob1.turnLeft();
			while (rob1.frontIsClear())  {
				rob1.move();
			}
			rob1.turnLeft();
			rob1.turnLeft();
		}
		if (rob1.facingWest()) {
			while (rob1.frontIsClear())  {
				rob1.move();
			}
			rob1.turnLeft();
			while (rob1.frontIsClear())  {
				rob1.move();
			}
			rob1.turnLeft();
			rob1.turnLeft();
		}

		// section end

		//section start - code for zigzag
		boolean dirty = true;

		while (dirty = true) {


			while (rob1.frontIsClear()) {
				while (rob1.nextToABeeper()) {
					beepersInPossession++;
					rob1.pickBeeper();
				}
				distanceTraveled_area++;
				rob1.move();
			}
			if (rob1.facingNorth()) {
			rob1.turnLeft();
			rob1.turnLeft();
			rob1.turnLeft();

			rob1.move();
			rob1.turnLeft();
			rob1.turnLeft();
			rob1.turnLeft();

			}

			if (rob1.facingSouth()) {
			rob1.turnLeft();
			

			rob1.move();
			
			rob1.turnLeft();

			}
			// idk how to make a turn right command will that mess up robot plugin?
				
			

		}
		
		

		System.out.println("Beepers collected: " + beepersInPossession);
		System.out.println("Area: " + distanceTraveled_area);
		
		return beepersInPossession;

		
		


		
	}


	
}
