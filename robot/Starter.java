package robot;
import kareltherobot.*;


public class Starter implements Directions{

  public static void main(String[] args) {

    World.setVisible(true);// allows us to see the run output
    // the bigger the street, the farther north
    World.setSize(20,20);


    // The line below creates a Robot that we will refer to as rob
    // Find out what the numbers and direction do!
    // Put rob in a better location for your initials.
    Robot rob = new Robot(20,5,South,90);
    Robot rob2 = new Robot(20, 5, South, 90);
    // Want a second robot?  No prob.  They are cheap :)
    Robot rob3 = new Robot(5,15,West,90);
    Robot rob4 = new Robot(5,15, West, 90);
    Robot rob5 = new Robot(10,7, East, 90);
    // examples of commands you can invoke on a Robot
    // move one step in the direction it is facing

    for (int i=0; i < 6; i++)  {
    rob.putBeeper();
    rob.move();
    rob.putBeeper();
    rob.move();
    rob.move();
    rob.turnLeft();
    rob.turnLeft();
    rob.turnLeft();
    rob.move();
    rob.putBeeper();
    rob.turnLeft();

    rob2.move();
    rob2.putBeeper();
    rob2.move();
    rob2.move();
    rob2.turnLeft();
    rob2.move();
    rob2.putBeeper();
    rob2.turnLeft();
    rob2.turnLeft();
    rob2.turnLeft();

    }

    rob5.move();
    rob5.putBeeper();
    rob5.move();
    rob5.putBeeper();
    rob5.move();
    rob5.putBeeper();
    rob5.move();
  
    for (int j=0, j < 6, i++)  {
      



    }
    // done with the line, now on the curve
    // rob.turnLeft();

  }
}
