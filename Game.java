/**
 * These class will specify the attributes and behaviours of the game
 */
import java.util.ArrayList;
import java.io.*;
public class Game
{
    private ShipList playerShips;
    private ShipList computerShips;
    
    /**
    * Constructor for objects of class Game
    */
    public Game()
    {
       playerShips = new ShipList();
       computerShips = new ShipList();
      
    }
    
    private static int xAxis = 0;
    private static int yAxis = 0;
    private static String xShip ="X";
    private static String yShip ="Y";
    /**
     * This method will display the contents read from file.
     * @param      none
     * @return     No return type
    */
    
    public void displayFileContents(int size,boolean hits,boolean visible,int ships)
    {
        System.out.println("+============================================================================+");
        System.out.println("|                                                                            |");
        System.out.println("|      Welcome to the Battleship Game -- With a twist!!                      |");
        System.out.println("|                                                                            |");
        System.out.println("+============================================================================+");
        System.out.println("The game will use the grid size defined in the setting file");
        System.out.println("Playing grid size set as("+size+"X"+size+")");
        System.out.println("Maximum number of ships allowed as "+ships);
        System.out.println("Multiple hits allowed per ship set as "+hits);
        if(visible == true)
          System.out.println("Computer Ships Visible: ON");
        else
          System.out.println("Computer Ships Visible: OFF");
        
    }
    
     /**
     * This method will randomly generate and place the computer ship on the grid.
     * @param      gridSize maximum grid size
     * @param      multipleHitsAllowed indicate  whether multiple hits are allowed to the ship
     * @param      noOfShips no of ships to be added in the game
     * @return     No return type
    */
    public void getComputerShips(int gridSize,boolean multipleHitsAllowed,int noOfShips)
    {
        boolean result;
        String shipName;
        boolean isrepeated; 
        int x;
        int y;
        int hitsAllowed;
        int i = 0;
        shipName = "USS John Paul Jones";
        while(i < noOfShips)
        {
           
            result = false;
            isrepeated = false;
            x = 0;
            y = 0;
            hitsAllowed = 0;
            do
            {
                CoordinateGenerator generator = new CoordinateGenerator(0,gridSize);
                x = generator.generateRandomnValue();
                y = generator.generateRandomnValue();
                isrepeated = computerShips.checkCordinate(x,y); //check if co-ordinates are repeated or not 
                if(isrepeated == true)
                {
                    System.out.println("Coordinate already exists. Entering different coordinates.");
                }
            }while(isrepeated != false);
            
            hitsAllowed = getHitsAllowed(multipleHitsAllowed);  //check if multiple hits are allowed or nott and set the hits value
            
            computerShips.setShipValue(shipName,x,y,0,hitsAllowed); //add computer ships to array list
            shipName=shipName+" "+(i+1); 
            i++;
        }
        
    }
    
    /**
     * This method will return whether a computer hit a player ship or not .
     * @param      gridSize maximum grid size
     * @return     boolean whether a ship is hit or not
     */
    public boolean getComputerGuess(int gridSize)
    {
        int x = 0;
        int y = 0;
        boolean result = false;
        CoordinateGenerator generator = new CoordinateGenerator(0,gridSize); //randomly generate x and y co-ordinae
        x = generator.generateRandomnValue();
        y = generator.generateRandomnValue();
        System.out.println("Computer X guess:"+x);
        System.out.println("Computer Y guess:"+y);
        result = playerShips.checkShipHits(x,y,"Computer");  //computer make guess
        return result;
    }
    
    /**
     * This method will return the number of hits required to hit a ship .
     * @param      multipleHitsAllowed   indicates whether multiple hits are allowed or not
     * @return     integer 
    */
    public int getHitsAllowed(boolean multipleHitsAllowed)
    {
        int value = 0;
        if(multipleHitsAllowed == true)
        {
             CoordinateGenerator generator = new CoordinateGenerator(1,5);    //strength of ship between 1 to 5
             value = generator.generateRandomnValue();
        }
        else
        {
            value = 1;     //strength of ship is set to 1
        }
        return value;
    }
    
    /**
     * This method will accept the ship co-ordinate from the user .
     * @param      gridSize maximum grid size
     * @return     None
    */
    public void getPlayerCoordinate(int gridSize)
    {
      
         Input input = new Input();
         Validation validate = new Validation();
         boolean result = false;
         do
         {
             xAxis = input.getCordinate(xShip,gridSize);   //get the ship x co-ordinate
             if(xAxis == 100)
             {
               System.out.println("Ship X Position must be between 0 and "+gridSize+".");
               result = false;
             }
             else
             {
               result = validate.validateInteger(xAxis,gridSize,xShip);  //validate the x co-ordinate
             }
         }while(result != true);
                    
         result = false;
                    
         do
         {
            yAxis = input.getCordinate(yShip,gridSize);   //get the ship y co-ordinate
            if(yAxis == 100)
            {
               System.out.println("Ship Y Position must be between 0 and "+gridSize+".");
               result = false;
            }
            else
            {
               result = validate.validateInteger(yAxis,gridSize,yShip);  //validate the y co-ordinate
            }
         }while(result != true);
        
    }
    
     /**
     * This method will return whether a player hit a computer ship or not .
     * @param      gridSize  maximum grid size
     * @return     boolean   whether a ship is hit or not
     */
    public boolean getPlayerGuess(int gridSize)
    {
        boolean result = false;
        getPlayerCoordinate(gridSize);                              //get user to make guess of ship position
        result = computerShips.checkShipHits(xAxis,yAxis,"Player"); //check if ship is hit or not
        return result;
    }
    
     /**
     * This method will accept the input the ship detail from the user .
     * @param      gridSize maximum grid size
     * @param      multipleHitsAllowed indicate  whether multiple hits are allowed to the ship
     * @param      noOfShips no of ships to be added in the game
     * @return     No return type
     */
    public void getPlayersShip(int gridSize,boolean multipleHitsAllowed,int noOfShips)
    {
        boolean result;
        String shipName;
        boolean isrepeated; 
        int hitsAllowed;
        int i = 0;
        
        Input input = new Input();
        Validation validate = new Validation();
        while(i < noOfShips)
        {
            shipName = null;
            result = false;
            isrepeated = false;
            hitsAllowed = 0;
            System.out.println("Please enter the details for "+(i+1)+" ship:");
           
            do
            {
              shipName = input.getShipName();   //get the ship name
              result = validate.validateString(shipName,3,15);  //validate the ship name
            }while(result != true);
            
            shipName = null;
            result = false;
            
            do
            {  
              getPlayerCoordinate(gridSize);
              isrepeated = playerShips.checkCordinate(xAxis,yAxis);
              if(isrepeated == true)
              {
                  System.out.println("Coordinate already exists. Please enter different coordinates");
              }
            }while(isrepeated != false);
            
            hitsAllowed = getHitsAllowed(multipleHitsAllowed);  // get the no oh hits of ship 
            playerShips.setShipValue(shipName,xAxis,yAxis,0,hitsAllowed);  //add ship details to ArrayList
            i++;
            xAxis = 0;
            yAxis = 0;
        } 
    }
    /**
     * This method is responsible for executing the game
     * @param      none
     * @return     none
     */
    public void main()
    {
        Game g = new Game();
        g.readGameSetting();
    }
    
    /**
     * This method will initialize the game for playing. .
     * @param      gridSize                 size of the grid
     * @param      multipleHitsAllowed      indicates whether multiple hits are allowed or not
     * @param      computerShipsVisible     indicates whether computer ship ahould be displayed or not
     * @param      noOfShips                indicates the number of ship
     * @return     None
    */
    public void initializeGame(int gridSize,boolean multipleHitsAllowed,boolean computerShipsVisible,int noOfShips)
    {
        int round = 1;
        int playerScore = 0;
        int computerScore = 0;
        boolean gameBegin = false;
        String filename = "gameoutcome.txt";
        System.out.println("Loading Player Setting......");
        try
        {
            getPlayersShip(gridSize,multipleHitsAllowed,noOfShips);
            getComputerShips(gridSize,multipleHitsAllowed,noOfShips);
          
            do
            {
                gameBegin = true;
                
                if(!playerShips.checkAllShipsDestroyed(noOfShips) && !computerShips.checkAllShipsDestroyed(noOfShips) )   //No ships Destroyed generate rounds
                {
                     System.out.println("Begining round "+round);
                     System.out.println("Player Score: "+playerScore);
                     System.out.println("Computer Score: "+computerScore);
                     System.out.println("Displaying the Player Grid");
                     playerShips.displayGrid(gridSize);
                     System.out.println("---------------------------------------------------");
                     System.out.println("Displaying the Computer Grid");
                     if(computerShipsVisible == true)
                       computerShips.displayGrid(gridSize);    //if visible display grid
                     else
                        computerShips.displayNonVisibleGrid(gridSize);  //if non visible display non visible grid
                     
                     System.out.println("Player to make a guess");
                     boolean isHit = getPlayerGuess(gridSize);     // ask the user to make guess about computer ship position
                     if(isHit == true)   //if true update player score
                     {
                         playerScore  = playerScore  + 10;
                     }
                     
                     isHit = false;
                     System.out.println("Computer to make a guess");
                     isHit = getComputerGuess(gridSize);        // ask the computrt to make guess about user ship position
                     if(isHit == true)//if true update player score
                     {
                         computerScore  = computerScore  + 10;
                     }
                     System.out.println("Press any key to continue..");
                     System.in.read();
                     round++;
                     gameBegin = true;
                }
                else if(playerShips.checkAllShipsDestroyed(noOfShips))   //if all player ships are destroyed display score and write to file
                {
                     System.out.println("--------------------------------------------");
                     System.out.println("Congratulations!! Computer wins!!!");
                     System.out.println("Final Scores:");
                     System.out.println("Player Score: "+playerScore);
                     System.out.println("Computer Score: "+computerScore);
                     String contents = "Computer Wins.Final Score Player:("+playerScore+")"+" and Computer:("+computerScore+")"; 
                     FileIO io = new FileIO();
                     io.writeToFile(contents, filename);  //write score to file
                     gameBegin = false;
                }
                else if(computerShips.checkAllShipsDestroyed(noOfShips)) //if all computer ships are destroyed display score and write to file
                {
                    System.out.println("----------------------------------------");
                    System.out.println("Congratulations!! Player wins!!!");
                    System.out.println("Final Scores:");
                    System.out.println("Player Score: "+playerScore);
                    System.out.println("Computer Score: "+computerScore);
                    String contents = "Player Wins.Final Score Player:("+playerScore+")"+" and Computer:("+computerScore+")";
                    FileIO io = new FileIO();
                    io.writeToFile(contents, filename);   //write score to file
                    gameBegin = false;
                }
              
            }while(gameBegin == true);
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + " not found.");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O exception occured");
        }
        catch(Exception e)
        {
            System.out.println("Unexpected exception occured");
        }
      
    }
    
    /**
     * This method is used to read the game setting from the specified file.
     * @param      none
     * @return     No return type
    */

    private void readGameSetting()
    {
        int grid_size = 0;
        int no_of_ships = 0;
        boolean multipleHitsAllowed = false;
        boolean computerShipsVisible = false;
        try
        {
            
            FileIO file = new FileIO();
            file.setFilename("gamesetting.txt");                       //read from the setting file
            ArrayList<String> fileContents = file.readFromFile();      //get list of contents of file
            String content1 = fileContents.get(0);
            String content2 = fileContents.get(1);
            String content3 = fileContents.get(2);
            String content4 = fileContents.get(3);
            
            grid_size = Integer.parseInt(content1);
            if( content2.equalsIgnoreCase("true") || content2.equalsIgnoreCase("false") )    //check if boolean values are specified or not
               multipleHitsAllowed = Boolean.parseBoolean(content2);
            else
               throw new IllegalArgumentException("Value passed is not a boolean value.");
           
            no_of_ships = Integer.parseInt(content4);
            
            if( content3.equalsIgnoreCase("true") || content3.equalsIgnoreCase("false") )   //check if boolean values are specified or not
                computerShipsVisible =  Boolean.parseBoolean(content3);
            else
               throw new IllegalArgumentException("Value passed is not a boolean value.");
               
            displayFileContents(grid_size,multipleHitsAllowed,computerShipsVisible,no_of_ships); //display file contents..
            System.out.println("Press any key to continue......... ");
            System.in.read();
            initializeGame(grid_size,multipleHitsAllowed,computerShipsVisible,no_of_ships);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Please add an integer value in gamesetting.txt");
            System.out.println("Error:"+e);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Error invalid value in game file:"+e);
        }
        catch(Exception e)
        {
            System.out.println("Unknown error occured:"+e);
        }
    } 
}
