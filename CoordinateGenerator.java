import java.util.Random;
/*
 * The main purpose of the class is to randomly generate minimun and maximum quantity
*/

public class CoordinateGenerator
{
    public int minimumValue;
    public int maximumValue;
    
    
    /**
    * Default constructor with default minimum and maximum values
    * @param    None
    * @return   None
    */ 
    public CoordinateGenerator()
    {
        minimumValue = 0;
        maximumValue = 14; 
    }
    
    /**
    * Non-Default constructor that sets the minimum and maximum values by specified values
    * @param    min  minimum range for generating randomn value
    * @param    max  maximum range for generating value 
    * @return   None
    */ 
   public CoordinateGenerator(int min,int max)
   {
        minimumValue = min;
        maximumValue = max; 
   }
   
   /**
     * This method is used to get the minimum range for generating randomn value
     * @param      none
     * @return     int    minimum range for generating randomn value
   */
   public int minimumValue()
   {
        return minimumValue;
   }
    
   /**
     * This method is used to get the maximum range for generating randomn value
     * @param      none
     * @return     int    maximum range for generating randomn value
   */
   public int maximumValue()
   {
        return maximumValue;
   }
   
   /**
     * This method is used to randomly generate integer value within the minimum and maximum range
     * @param      none 
     * @return     int   randomly generated value
   */
   public int generateRandomnValue()
   {
       return minimumValue + (int)(Math.random() * maximumValue);
    
   }
   
   /**
     * This method is used to display the minimum and maximum range of values
     * @param      none
     * @return     none
   */
   public void display()
   {
        System.out.println("MinimumValue:"+minimumValue);
        System.out.println("MaximunValue :"+maximumValue);
   }
   
   /**
     * This method is used to set the minimum range for generating randomn value
     * @param      int    maximum range for generating randomn value
     * @return     none
   */
   public void setMinimumValue(int min)
   {
        minimumValue = min;
   }
   
   /**
     * This method is used to set the maximum range for generating randomn value
     * @param      int    maximum range for generating randomn value
     * @return     none
   */
   public void setMaximumValue(int max)
   {
        maximumValue = max;
   } 
   
}
