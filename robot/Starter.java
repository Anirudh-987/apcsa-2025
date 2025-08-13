package robot;
import kareltherobot.*;


public class Starter implements Directions{

  public static void main(String[] args) {

    World.setVisible(true);// allows us to see the run output
    // the bigger the street, the farther north
    World.setSize(20,20);
    World.setDelay(1);

    // The line below creates a Robot that we will refer to as rob
    // Find out what the numbers and direction do!
    // Put rob in a better location for your initials.
    Robot rob1 = new Robot(20,5,South,90);
    Robot rob2 = new Robot(20, 5, South, 90);
    // Want a second robot?  No prob.  They are cheap :)
    Robot rob3 = new Robot(5,15,North,90);
    Robot rob4 = new Robot(5,15, North, 90);
    Robot rob5 = new Robot(12,2, East, 90);
    // examples of commands you can invoke on a Robot
    // move one step in the direction it is facing

    for (int i=0; i < 5; i++)  {
    rob1.putBeeper();
    rob1.move();
    rob1.putBeeper();
    rob1.move();
    rob1.move();
    rob1.turnLeft();
    rob1.turnLeft();
    rob1.turnLeft();
    rob1.move();
    rob1.putBeeper();
    rob1.turnLeft();

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
    rob5.putBeeper();
    rob5.move();
    rob5.putBeeper();
    rob5.move();
  
    for (int j=0; j < 6; j++)  {
      

      rob3.putBeeper();
      rob3.move();
      rob3.putBeeper();
      rob3.move();
      rob3.move();
      rob3.turnLeft();
      rob3.turnLeft();
      rob3.turnLeft();
      rob3.move();
      rob3.putBeeper();
      rob3.turnLeft();

      rob4.move();
      rob4.putBeeper();
      rob4.move();
      rob4.move();
      rob4.turnLeft();
      rob4.move();
      rob4.putBeeper();
      rob4.turnLeft();
      rob4.turnLeft();
      rob4.turnLeft();
    }
  
    
    rob1.turnLeft();
    rob2.turnLeft();
  
    for (int L=0; L < 20; L++) {

      rob1.move();
      rob2.move();
      rob3.move();
      rob4.move();
      rob5.move();

    }

  }

}

// stupid rob1 refuses to follow commands after initial "for" loop and I don't know why
// just sitting their being ugly after every other bot leaves