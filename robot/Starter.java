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
    Robot rob1 = new Robot(20,5,South,90);
    

  }

}

// stupid rob1 refuses to follow commands after initial "for" loop and I don't know why
// just sitting their being ugly after every other bot leaves