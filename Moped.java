
package edu.nyu.cs.assignment6;

/**
 * A virtual moped, roaming the streets of New York.
 * The signatures of a few methods are given and must be completed and used as
 * indicated.
 * Create as many additional properties or methods as you want, as long as the
 * given methods behave as indicated in the instructions.
 * Follow good object-oriented design, especially the principles of abstraction
 * (i.e. the black box metaphor) and encapsulation (i.e. methods and properties
 * belonging to specific objects), as we have learned them.
 * The rest is up to you.
 */
public class Moped {
    /**
     * Constructs a moped initialized to 10th St. and 5th Ave., facing South.
     * This constructor should not take in any arguments and utilize the other 
     * constructor.
     */
	private int street;
	private int avenue;
	private String direction;
	private int gas;
	private boolean parked;

     public Moped() {
        // Start the moped life at 10th St. and 5th Ave., facing South.
    	 this(10,5,"south");
     }

     /**
     * Constructs a moped initialized to the provided parameters
     * 
     * @param street int the street the moped is initially placed at
     * @param avenue int avenue the moped is initially placed at
     * @param direction String "north","south","east","west" indicating the initial direction of the moped
     */

     public Moped(int street, int avenue, String direction) {
        // please fill this out
    	 setStreet(street);
    	 setAvenue(avenue);
    	 setOrientation(direction);
    	 this.gas=100;
    	 this.parked=false;
    	 }
 

	public void setStreet(int s) {
    	 if (s>0 && s<=200) {
    		 this.street=s;    	 
    	 }else if (s<1) {
    		 this.street=1;
    	 }else {
    		 this.street=200;
    	 }
     }
     public void setAvenue(int a) {
    	 if (a>0 && a<=10) {
    		 this.avenue=a;
    	 }else if (a<1) {
    		 this.avenue=1;
    	 }else {
    		 this.avenue=10;
    	 }
     }
     
     public int getAvenue() {
    	 return avenue;
     }
     public int getStreet() {
    	 return street;
     }
     public int getGas() {
    	 return gas;
     }
    /**
     * Sets the orientation of the moped to a particular cardinal direction.
     * 
     * @param orientation A string representing which cardinal direction at which to
     *                    set the orientation of the moped. E.g. "north", "south",
     *                    "east", or "west".
     */
    public void setOrientation(String orientation) {
    	String lowerOrientation = orientation.toLowerCase();
        if (lowerOrientation.equals("north") || lowerOrientation.equals("south") ||
            lowerOrientation.equals("east") || lowerOrientation.equals("west")) {
           this.direction=lowerOrientation;
        }
    }

    /**
     * Returns the current orientation of the moped, as a lowercase String.
     * E.g. "north", "south", "east", or "west".
     * 
     * @return The current orientation of the moped, as a lowercase String.
     */
    public String getOrientation() {
        return direction.toLowerCase(); 
    }

    /**
     * Prints the current location, by default exactly following the format:
     * Now at 12th St. and 5th Ave, facing South.
     *
     * If the current location is associated with location-based advertising, this
     * method should print exactly following format:
     * Now at 12th St. and 4th Ave, facing West. Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?
     * 
     * Note that the suffixes for the numbers must be correct: i.e. the "st" in
     * "1st", "nd" in "2nd", "rd" in "3rd", "th" in "4th", etc, must be correct.
     */
    public void printLocation() {
    	if (street==1&&avenue>3) {
    		System.out.printf("Now at %dst St. and %dth Ave, facing %s. \n",street,avenue,direction);
    	}else if (street==2&&avenue>3) {
    		System.out.printf("Now at %dnd St. and %dth Ave, facing %s. \n",street,avenue,direction);
    	}else if (street==3&&avenue>3) {
    		System.out.printf("Now at %drd St. and %dth Ave, facing %s. \n",street,avenue,direction);
    	}else if (street>3&&avenue==1) {
    		System.out.printf("Now at %dth St. and %dst Ave, facing %s. \n",street,avenue,direction);
    	}else if (street>3&&avenue==2) {
    		System.out.printf("Now at %dth St. and %dnd Ave, facing %s. \n",street,avenue,direction);
    	}else if (street>3&&avenue==3) {
    		System.out.printf("Now at %dth St. and %drd Ave, facing %s. \n",street,avenue,direction);
    	}else {
    		System.out.printf("Now at %dth St. and %dth Ave, facing %s. \n",street,avenue,direction);
    	}

    }

    /**
     * Handles the command, `turn left`.
     * Causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each turn, and doesn't turn unless there is
     * sufficient gas and it isn't parked, as according to the instructions.
     * This method must not print anything.
     */
    public void turnLeft() {
    	if (gas>=1 && !parked) {
    		switch(direction) {
    			case "north": direction="west"; break;
    			case "west": direction="south"; break;
    			case "south": direction="east"; break;
    			case "east": direction="north"; break;
    		}
    		
    	}
   
    }

    /**
     * Handles the command, `turn right`.
     * Causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each turn, and doesn't turn unless there is
     * sufficient gas and isn't parked, as according to the instructions.
     * This method must not print anything.
     */
    public void turnRight() {
    	if (gas >= 1 && !parked) {
            switch (direction) {
                case "north": direction = "east"; break;
                case "east": direction = "south"; break;
                case "south": direction = "west"; break;
                case "west": direction = "north"; break;
            }
 
    	}
    }

    /**
     * Handles the command,`straight on`.
     * Moves the moped one block straight ahead.
     * Consumes gas with each block moved, and doesn't move unless there is
     * sufficient gas and isn't parked, as according to the instructions.
     * This method must not print anything.
     */
    public void goStraight() {
    	if (gas >= 5 && !parked) {
    	switch (direction) {
        case "north":
        	if (street<200) {
        		street++;
        		gas-=5;
        	}
        	break;
        case "south":
        	if (street>1) {
        		street--;
        		gas-=5;
        	}
        	break;
        case "east":
        	if (avenue>1) {
        		avenue--;
        		gas-=5;
        	}
        	break;
        case "west":
        	if (avenue<10) {
        		avenue++;
        		gas-=5;
        	}
        	break;
	}
    }
    }
    /**
     * Handles the command,`back up`.
     * Moves the moped one block backwards, but does not change the cardinal
     * direction the moped is facing.
     * Consumes gas with each block moved, and doesn't move unless there is
     * sufficient gas and isn't parked, as according to the instructions.
     * This method must not print anything.
     */
    public void goBackwards() {
    	if (gas >=5 && !parked) {
    		
    	switch (direction) {
            case "north":
            	if (street>1) {
            		street--;
            		gas-=5;
            	}
            	break;
            case "south":
            	if (street<200) {
            		street++;
            		gas-=5;
            	}
            	break;
            case "east":
            	if (avenue<10) {
            		avenue++;
            		gas-=5;
            	}
            	break;
            case "west":
            	if (avenue>1) {
            		avenue--;
            		gas-=5;
            	}
            	break;
    	}
    	}
    }

    /**
     * Handles the command,`how we doin'?`.
     * This method must not print anything.
     * 
     * @return The current gas level, as an integer from 0 to 100.
     */
    public int getGasLevel() {
        return this.gas; 
    }

    /**
     * Prints the current gas level, by default exactly following the format:
     * The gas tank is currently 85% full.
     *
     * If the moped is out of gas, this method should print exactly following
     * format:
     * We have run out of gas. Bye bye!
     */
    public void printGasLevel() {
    	if (gas>0) {
    		System.out.printf("The gas tank is currently %d%% full.\n", gas);
    	}else {
    		System.out.println("We have run out of gas. Bye bye!");
    	}
    }

    /**
     * Handles the command, `fill it up`.
     * This method must not print anything.
     * Fills the gas level to the maximum.
     */
    public void fillGas() {
    	this.gas=100;
    }

    /**
     * Handles the command, `park`.
     * Prints out the statement "We have parked." and makes the vehicle park.
     */
    public void park() {
    	parked=true;
    	System.out.println("We have parked.");
    	

    }

    /**
     * Handles the command, `go to Xi'an Famous Foods`
     * Causes the moped to self-drive, block-by-block, to 8th Ave. and 15th St.
     * Consumes gas with each block, and doesn't move unless there is sufficient
     * gas, as according to the instructions.
     */
    public void goToXianFamousFoods() {
    	if (parked) {
    		return; 
    	}
    	
    	while (getAvenue()!=8 ) {
    		if (gas<5) {
    			fillGas();
    		}
    
    		if (getAvenue()>8) {
    			while (!getOrientation().equals("east")) {
    				this.turnRight();
    				printLocation();
    			}
    			this.goStraight();
    			printLocation();
    		}
    		
    		if (getAvenue()<8) {
    			while (!getOrientation().equals("west")) {
    				this.turnRight();
    				printLocation();
    			}
    			this.goStraight();
    			printLocation();
    		}
    
    	}
    	
    	while (getStreet()!=15) {
    		if (gas<5) {
    			fillGas();
    		}
 
    		if (getStreet()>15) {
    			while (!getOrientation().equals("south")) {
    				this.turnRight();
    				printLocation();
    			}
    			this.goStraight();
    			printLocation();
    		}
    		
    		if (getStreet()<15) {
    			while (!getOrientation().equals("north")) {
    				this.turnRight();
    				printLocation();
    			}
    			this.goStraight();
    			printLocation();
    		}
   
    	}
    }
    /**
     * Generates a string, containing a list of all the user commands that the
     * program understands.
     * 
     * @return String containing commands that the user can type to control the
     *         moped.
     */
    public String getHelp() {
    	
    	return "Available commands:\n" +
    	           "1. 'turn left' - Turn left (consumes 1 unit of gas).\n" +
    	           "2. 'turn right' - Turn right (consumes 1 unit of gas).\n" +
    	           "3. 'straight on' - Move one block forward (consumes 1 unit of gas).\n" +
    	           "4. 'back up' - Move one block backward (consumes 1 unit of gas).\n" +
    	           "5. 'how we doin\\'?' - Check the current gas level.\n" +
    	           "6. 'fill it up' - Refill the gas tank to 100%.\n" +
    	           "7. 'park' - Park the moped (stops movement until further commands).\n" +
    	           "8. 'go to Xi'an Famous Foods' -Go to 8th Ave. and 15th St.\n" +
    	           "9. 'help' - Display this help message again."; // dummy return statement
    }

    /**
     * Sets the current location of the moped.
     * 
     * @param location an int array containing the new location at which to place
     *                 the moped, in the order {street, avenue}.
     */
    public void setLocation(int[] location) {
    	this.street=location[0];
    	this.avenue=location[1];
    }

    /**
     * Gets the current location of the moped.
     * 
     * @return The current location of the moped, as an int array in the order
     *         {street, avenue}.
     */
    public int[] getLocation() {
    	int [] location=new int[2];
    	location[0]=this.street;
    	location[1]=this.avenue;
        return location; // dummy return statement
    }
}
