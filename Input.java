import java.util.Scanner;
/**
 * This class is used to get input of ship from the user
 */
public class Input
{
  Scanner console =new Scanner(System.in);
  /**
   * Default constructor of the Input Class
   */
  public Input()
  { 
  }
  
  /**
     * This method will accept the integer input from the user and return it to the calling object. .
     * @param      msg      indicate the input message to user
     * @param      grid     indicate the size of grid to be display
     * @return     Integer  input from user
  */
  public int getCordinate(String msg,int grid)
  {
      int value = 0;
      try
      {
          System.out.println("Ship "+msg+" Position (0-"+grid+")");
          String val = console.nextLine();
          value = Integer.parseInt(val);
          return value;
          
      }
      catch(NumberFormatException e)
      {
          System.out.println("Ship "+msg+" must be numeric.");
      }
      catch(Exception e)
      {
         System.out.println("Ship "+msg+" must be numeric.");
          console.next();
      }
      return 100;
  }
  
  /**
     * This method will accept the string input from the user and return it to the calling object. .
     * @param      none
     * @return     String ship name
  */
  public String getShipName()
  {
      String name = null;
      System.out.println("Please enter ShipName: ");
      name = console.nextLine();
  
      return name;
  }
  
  
  
}
