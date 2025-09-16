package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/finalTestWorld2024.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba;

// All changes below

	public int cleanRoom(String worldName, int startX, int startY) {
		// arbitrary starting location just guessed to put it in the box
		Robot rob1 = new Robot(40,150,East,0);
		int beepersInPossession = 0;
		int distanceTraveled_area = 0;
		int largestPile = 0;
		int beepersInPile = 0;
		int largestPileLocationX = 0;
		int largestPileLocationY = 0;
		World.setDelay(0);

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
		
		// been having some problems with piles near borders

		//section start - code for zigzag
		boolean dirty = true;

		while (dirty = true) {


			while (rob1.frontIsClear()) {
				while (rob1.nextToABeeper()) {
					beepersInPossession++;
					beepersInPile++;
					rob1.pickBeeper();
				}
				distanceTraveled_area++;
				rob1.move();
				if (beepersInPile > largestPile) {
					largestPile = beepersInPile;
					largestPileLocationX = rob1.avenue();
					largestPileLocationY = rob1.street();
				}
				beepersInPile = 0;
			}
			//turning around and moving downards
			if (rob1.facingNorth() && rob1.frontIsClear() == false) {
				//next is stuff to pick up beepers on edge
				while (rob1.nextToABeeper()) {
					beepersInPossession++;
					beepersInPile++;
					rob1.pickBeeper();
				}
				distanceTraveled_area++;
				if (beepersInPile > largestPile) {
					largestPile = beepersInPile;
					largestPileLocationX = rob1.avenue();
					largestPileLocationY = rob1.street();
				}
				beepersInPile = 0;
			rob1.turnLeft();
			rob1.turnLeft();
			rob1.turnLeft();
			// to prevent crashing
			if (rob1.frontIsClear() == false) {
				System.out.println("Beepers collected: " + beepersInPossession);
				System.out.println("Area: " + distanceTraveled_area);
				System.out.println("The largest pile had " + largestPile + "beepers in it.");
				System.out.println("The coordinates of the largest pile are (" + largestPileLocationX + ", " + largestPileLocationY + ").");
		
				rob1.turnOff();
			}
			rob1.move();
			rob1.turnLeft();
			rob1.turnLeft();
			rob1.turnLeft();

			}
	
			// turning arounds and moving upwards
			if (rob1.facingSouth() && rob1.frontIsClear() == false) {
				//next is code to get beepers on edges
				while (rob1.nextToABeeper()) {
					beepersInPossession++;
					beepersInPile++;
					rob1.pickBeeper();
				}
				distanceTraveled_area++;
				if (beepersInPile > largestPile) {
					largestPile = beepersInPile;
					largestPileLocationX = rob1.avenue();
					largestPileLocationY = rob1.street();
				}
				beepersInPile = 0;
				rob1.turnLeft();
			// to prevent crashing
			if (rob1.frontIsClear() == false) {
				System.out.println("Beepers collected: " + beepersInPossession);
				System.out.println("Area: " + distanceTraveled_area);
				System.out.println("The largest pile had " + largestPile + "beepers in it.");
				System.out.println("The coordinates of the largest pile are (" + largestPileLocationX + ", " + largestPileLocationY + ").");

				rob1.turnOff();
			}
			rob1.move();
			
			rob1.turnLeft();

			}
			// idk how to make a turn right command will that mess up robot plugin?
				
			

		}
		
	
		// return statement - arbitrary integer
		
		return beepersInPossession;


		
	}


	
}
