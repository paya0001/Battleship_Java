
/**
 * These class is used to define the property of ship
 */
public class Ship
{
    /**
     * Name of the ship
    */
    public String shipName;
    /**
     * X axis position of the ship
    */
    public int xPos;
    /**
     * Y axis position of the ship
    */
    public int yPos;
    /**
     * Number of hits made to the ship
    */
    public int noOfHitsMade;
    /**
     * Number of hits required to destroy the ship
    */
    public int noOfHitsNeeded;
   
     /**
     * Constructor for objects of class Ship
     */
    public Ship()
    {
        shipName = "Vikrant";
        xPos = 5;
        yPos = 10;
        noOfHitsMade = 2;
        noOfHitsNeeded = 3;
    }
    
    /**
     * Non-Default constructor that creates the ship class object with specified data
     */
    public Ship(String name,int xAxis,int yAxis,int hitsMade,int hitsNeeded)
    {
        shipName = name;
        xPos = xAxis;
        yPos = yAxis;
        noOfHitsMade = hitsMade;
        noOfHitsNeeded = hitsNeeded;
    }
    
    /**
     * This method is used to get the number of hits made to a ship
     * @param     None.
     * @return    int   return integer value of number of hit made to ship
     */
    public int getNoOfHitsMade()
    {
        return noOfHitsMade;
    }
    
    /**
     * This method is used to get the number of hits needed to destroy a ship.
     * @param     None.
     * @return    int   return integer value of number of hit needed.
    */
    public int getNoOfHitsNeeded()
    {
        return noOfHitsNeeded;
    }
    
    /**
     * This method is used to get the name of the ship.
     * @param     None.
     * @return    String   return ship name.
    */
    public String getShipName()
    {
        return shipName;
    }
    
    /**
     * This method is used to get the x co-ordinate of the ship.
     * @param     None.
     * @return    int   return ship x position.
    */
    public int getXPos()
    {
        return xPos;
    }
    
    /**
     * This method is used to get the y co-ordinate of the ship.
     * @param     None.
     * @return    int   return ship y position.
    */
    public int getYPos()
    {
        return yPos;
    }
    
    /**
     * This method is used to display the state of the object
     * @param     None
     * @return    None   
    */
    public void display()
    {
        System.out.println("Ship Name:"+shipName);
        System.out.println("Ship X axis position:"+xPos);
        System.out.println("Ship Y axis position:"+yPos);
        System.out.println("No of hits Made:"+noOfHitsMade);
        System.out.println("No of hits Needed:"+noOfHitsNeeded);
    }
   
    /**
     * This method is used to set the number of hits made to a ship
     * @param     int   integer value of number of hit made to ship
     * @return    None   
    */
    public void setNoOfHitsMade(int hitsMade)
    {
         noOfHitsMade = hitsMade;
    }
    
    /**
     * This method is used to set the number of hits needed to destroy a ship.
     * @param     int   return integer value of number of hit needed
     * @return    None  
    */
    public void setNoOfHitsNeeded(int hitsNeeded)
    {
         noOfHitsNeeded = hitsNeeded;
    }
    
    /**
     * This method is used to set the name of the ship with provided name.
     * @param     String Ship Name.
     * @return    None.
    */
    public void setShipName(String shipName)
    {
        this.shipName = shipName;
    }
    
    /**
     * This method is used to set the x co-ordinate of the ship.
     * @param     int   ship x position
     * @return    None
    */   
    public void setXPos(int xPosition)
    {
        xPos = xPosition;
    }
    
    /**
     * This method is used to set the y co-ordinate of the ship.
     * @param     int   ship y position
     * @return    None
    */   
    public void setYPos(int yPosition)
    {
        yPos = yPosition;
    }
    
}
