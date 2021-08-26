/**
 * This class is used to store the ship information in an array list
 */
import java.util.ArrayList;
public class ShipList
{
     // instance variables - replace the example below with your own
     /**
      * ArrayList of Ship class
     */
     private ArrayList<Ship> shipList;
     
     /**
     * Default Constructor for that creates object of ShipList class
     */
     public ShipList()
     {
       shipList  = new ArrayList<Ship>();
     }
    
     /*
     * Non-Default constructor with specified ShipList array size
     */
     public ShipList(int size)
     {
       shipList  = new ArrayList<Ship>(size);
     }
    
       /**
     * This method is used to check whether all ships are destoyed or not.
     * @param   totalShips   total number of ships.
     * @return  boolean      indicating all ships are destroyed
     */
     public boolean checkAllShipsDestroyed(int totalShips)
     {
         int count = 0;
         for(Ship s : shipList)//loop through each ship               
         {
             if(s.getNoOfHitsMade() == s.getNoOfHitsNeeded()) //check if ship is destroyed   
               count++;
         }
         if(count == totalShips) //if count = total number of ship then all ships are destroyed
         {
            return true;  
         }
         return false;
     }
    
       
     /**
     * This method is used to check if a ship already exist at the same point.
     * @param      x        indicates x coordinate
     * @param      y        indicates y coordinate
     * @return     boolean  indicating ship exist at same point
     */
     public boolean checkCordinate(int x,int y)
     {
         boolean alreadyExist = false;
         for( Ship s: shipList )
         {
             if(s.getXPos() == x && s.getYPos() == y)
             {
                 alreadyExist = true;
             }
         }
         return alreadyExist;
     }
     
      /**
     * This method is used to check whether the ships are hit or not.
     * @param      x         indicates x coordinate
     * @param      y         indicates y coordinate
     * @param      msg       indicates the hit or miss msg
     * @return     boolean   return true if ship is hitted else return false.
     */
     public boolean checkShipHits(int x,int y,String msg)
     {
         Ship ship = new Ship();
         ship = getSpecificShip(x,y);
         if(ship!=null)
         {
             if(getCoordinateDestroyStatus(x,y))
             {
                 System.out.println("Sorry.Ship at the ("+x+","+y+") axis  is already destroyed.");
                 return false;
             }
             else
             {
                 int hit = 0;
                 hit = ship.getNoOfHitsMade()+1;
                 ship.setNoOfHitsMade(hit);
                 System.out.println(msg+" HITSSS!!!!!!!!");
                 return true;
             }
             
         }
         else
         {
           System.out.println(msg+" MISSS!!!!!!!!");  
         }
         return false;
     }
     
     
     /**
     * This method is used to display the Grid.
     * @param     gridSize   indicates maximum value of grid 
     * @return    None 
     */
     public void displayGrid(int gridSize)
     {
        for ( int i = 0; i <= gridSize; i++ )
        {
            for ( int j = 0; j <= gridSize; j++ )
            {
                
                if (checkCordinate(i,j))
                {
                    if (getCoordinateDestroyStatus(i,j))        //check if ship is destroyed 
                        System.out.print("X");
                    else if (getCoordinateHitStatus(i,j))       //check if ship is hit 
                            System.out.print("D");
                        else
                            System.out.print("O");           
                }
                else
                    System.out.print("~");
            }
            System.out.println("");
        }
     }
    
     /**
     * This method is used to display non visible computer ships.
     * @param      none 
     * @return     No return type 
     */
    
     public void displayNonVisibleGrid(int gridSize)
     {
         for ( int i = 0; i <= gridSize; i++ )
        {
            for ( int j = 0; j <= gridSize; j++ )
            {
                 if (checkCordinate(i,j))
                {
                    if (getCoordinateDestroyStatus(i,j))        //check if ship is destroyed 
                        System.out.print("X");
                    else if (getCoordinateHitStatus(i,j))       //check if ship is hit 
                        System.out.print("D");
                    else
                         System.out.print("~");
                    
                }
                else
                      System.out.print("~");
                     
                        
            }
            System.out.println("");
        }
     }
      
     /**
     * This method is used to get whether ship at particular position is destroyed or not.
     * @param     x        indicates x coordinate
     * @param     y        indicates y coordinate
     * @return    boolean  return whether a ship is destroed or not 
     */
     public boolean getCoordinateDestroyStatus(int x, int y)
     {
        Ship ship = getSpecificShip(x,y);  //get ship at specific position
        boolean flag = false;
        if (ship.getNoOfHitsNeeded() == ship.getNoOfHitsMade()) //check if destroyed
            flag = true;
        return flag;
     }
    
     /**
     * This method is used to check hits status of each ship.
     * @param  x   indicates x coordinate
     * @param  y   indicates y coordinate
     * @return     returns boolean values 
     */
     public boolean getCoordinateHitStatus(int x,int y)
     {
        Ship sp = getSpecificShip(x,y);
        boolean flag = false;
        int hits = sp.getNoOfHitsMade();
        if ( hits > 0 )
            flag = true;
        return flag;
     }
    
     /**
     * This method is used to get the ship object.
     * @param      x            indicates x coordinate
     * @param      y            indicates y coordinate
     * @param      totalShips   total number of ships.
     * @return     Ship         returns the ship object at the specific position
     */
     public Ship getSpecificShip(int x,int y)
     {
         Ship shipObj = null;
         for(Ship s : shipList)
         {
              if(s.getXPos() == x && s.getYPos() == y)
             {
                 shipObj = s;
             }
         }
         return shipObj;
     }
     
     /**
     * This method is used to add ship values in the arraylist .
     * @param    x           indicates x coordinate
     * @param    y           indicates y coordinate
     * @param    hitsMade    indicates number of hits made
     * @param    hitsNeeded  indicates number of hits needed
     * @return   none 
     */
    
     public void setShipValue(String name, int x ,int y,int hitsMade, int hitsNeeded)
     {
       Ship ship = new Ship(name,x,y,hitsMade,hitsNeeded);
       shipList.add(ship); 
     }
    
      
}
