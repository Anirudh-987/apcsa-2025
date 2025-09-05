package robot;
import kareltherobot.*;


public class Starter implements Directions{

  public static void main(String[] args) {

    World.setVisible(true);// allows us to see the run output
    // the bigger the street, the farther north
    World.setSize(20,20);
    World.setDelay(5);

    // The line below creates a Robot that we will refer to as rob
    // Find out what the numbers and direction do!
    // Put rob in a better location for your initials.
    Robot rob1 = new Robot(5,15,North,90);
    

     for (int i=0; i < 4; i++)  { 
    rob1.putBeeper();
    rob1.move();
    rob1.turnLeft();
    rob1.move();
     rob1.putBeeper();
    rob1.move();
    rob1.turnLeft();
    rob1.turnLeft();
    rob1.turnLeft();
    rob1.move();
    rob1.putBeeper();
    rob1.move();
    rob1.turnLeft();
    rob1.move();
    rob1.putBeeper();
    rob1.move();
    rob1.turnLeft();
    rob1.turnLeft();
    rob1.turnLeft();
    rob1.move();

    rob1.turnLeft();
  
    
     }


  }

}



system.out.println(5*5);

for (double x=0; x < 5; i++)  {



  
}