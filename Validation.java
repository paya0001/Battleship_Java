
/**
 *These class is used to validate the input taken from the user
 */
public class Validation
{
   /**
    * Default constructor
    * @param    None
    * @return   None
   */ 
   public Validation()
   {
   }
   
   /**
     * This method is used to check whether the enter integer is between the specified length and return the result.
     * @param     inputData Ship cordinate accepted from user
     * @param     gridSize   Maximum  grid size. 
     * @param     msg   Message to be displayed. 
     * @return     boolean
   */
    public boolean  validateInteger(int inputData,int gridSize,String msg)
    {
        if(inputData >= 0 && inputData <= gridSize )
        {
            return true;
        }
        else
        {
            System.out.println("Ship "+msg+" Position must be between 0 and "+gridSize+".");
        }
        return false;
    }
    
   /**
     * This method is used to check whether the enter string is between the specified length and return the result.
     * @param      input Ship name accepted from user
     * @param      min   Minimum Ship name length. 
     * @param      max   Maximum Ship name length. 
     * @return     boolean 
   */
    public boolean validateString(String input,int min,int max)
    {
        if(input.length() >= min && input.length()<= max && input != "")
        {
            return true;
        }
        else if(input.isEmpty())
        {
            System.out.println("Ship Name cannot be empty.");
        }
        else
        {
            System.out.println("Ship Name should be "+min+" and "+max+" characters long.");
        }
        
        return false;
    }
    
  
}
