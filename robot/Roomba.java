// first is variable creation
// 4 different modules to bring the robot to the bottom left edge facing north no matter where it is spanwed and no matter which way it faces
// then two different modules with almost identical code that does every function but alows the zigzag to happen, one is for bouncing off the top and one for the bottom but it became easier to just completely seperate them and literally all the code



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
		double distanceTraveled_area = 0;
		double largestPile = 0;
		double beepersInPile = 0;
		double amountOfPiles = 0;
		double largestPileLocationX = 0;
		double largestPileLocationY = 0;
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
				
				if (rob1.nextToABeeper()) {
				while (rob1.nextToABeeper()) {
					beepersInPossession++;
					beepersInPile++;
					rob1.pickBeeper();
				
				}
				amountOfPiles++;
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
				// had to add another if emcompassing all of this just so beepers inpile doesnt repeat evwery time a beeper collected
				beepersInPile = 0;
			rob1.turnLeft();
			rob1.turnLeft();
			rob1.turnLeft();
			// to prevent crashing
			if (rob1.frontIsClear() == false) {
				// all the printing outputs for if it hits the end at the top
				System.out.println("Beepers collected: " + beepersInPossession);
				System.out.println("Area: " + distanceTraveled_area);
				System.out.println("The largest pile had " + largestPile + " beepers in it.");
				System.out.println("The coordinates of the largest pile are (" + largestPileLocationX + ", " + largestPileLocationY + ").");
				System.out.println("There were " + amountOfPiles + " piles.");
				System.out.println("The average amount of beepers per pile was " + (beepersInPossession/amountOfPiles) + ".");
				System.out.println("Piles covered " + (amountOfPiles/8700) + "% of the map.");
				System.out.println("The robot is (" + (rob1.avenue()-largestPileLocationX) + "units to the right of the largest pile and " + (rob1.street() - largestPileLocationY) + " units above the largest pile.");
				// to prevent crashing but it doesnt really matter because i moved the print code above
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
				// had to add another if emcompassing all of this just so beepers inpile doesnt repeat evwery time a beeper collected
				beepersInPile = 0;
				rob1.turnLeft();
			
			if (rob1.frontIsClear() == false) {
				// all the printing outputs for if it hits the end at the bottom
				System.out.println("Beepers collected: " + beepersInPossession);
				System.out.println("Area: " + distanceTraveled_area);
				System.out.println("The largest pile had " + largestPile + " beepers in it.");
				System.out.println("The coordinates of the largest pile are (" + largestPileLocationX + ", " + largestPileLocationY + ").");
				System.out.println("There were " + amountOfPiles + " piles.");
				System.out.println("The average amount of beepers per pile was " + (beepersInPossession/amountOfPiles) + ".");
				System.out.println("Piles covered " + (amountOfPiles/8700) + "% of the map.");
				System.out.println("The robot is (" + (rob1.avenue()-largestPileLocationX) + "units to the right of the largest pile and " + (rob1.street() - largestPileLocationY) + " units above the largest pile.");
				// to prevent crashing but it doesnt really matter because i moved the print code above
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
