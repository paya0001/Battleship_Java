import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.lang.*;
public class FileIO
{
  /**
   * indicates the Name of the file
  */
  private String filename = null;
  
  /**
   * Default Constructor with file name set to gamesettings.txt
   * @param     none
   * @return    none
  */
  public FileIO()
  {
   filename = "gamesettings.txt"; 
  }
  
  /**
   * Non-Default Constructor used to set file name with specified file name
   * @param     name  Name of file
   * @return    none
  */
  public FileIO(String name)
  {
   filename = name;    
  }
  
  /**
   * It is used to get the file name
   * @param     none
   * @return    String  Name of file
  */
  public String getFilename()
  {
      return filename;
  }
  
  /**
   * It is used to set the file name
   * @param     fileName  Name of file
   * @return    none
  */
  public void setFilename(String filename)
  {
      this.filename = filename;
  }
  
  
  /**
     * This method is used to read contents from file and return the contents in array list of string.
     * @param     none
     * @return    ArrayList<String>  returns the contents of file
  */
    
  public ArrayList<String> readFromFile()
  {
    String[] contents = null;
    String data = "";
    ArrayList<String> fileContents = new  ArrayList<String>();
    
      try
      {
         FileReader inputFile = new FileReader(filename);
           try
           {
               Scanner console = new Scanner(inputFile);
               while( console.hasNextLine() )
               {
                 data = data + console.nextLine();
               }
               contents = data.split(","); 
               for(String item: contents)
               {
                   fileContents.add(item);
               }
           }
           finally
           {
               inputFile.close();
           }
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
      
     return fileContents;
  }
  
  /**
     * This method is used to write the final score in the specified file.
     * @param   fileContents   indicates contents to be written in file
     * @param   file           indicates the name of the file
     * @return  none
  */
  public void writeToFile(String fileContents,String file)//first set filename and then write to the file
  {
      try
      {
          PrintWriter outputFile = new PrintWriter(file);
          try
           {
               outputFile.println(fileContents);
           }
           finally
           {
               outputFile.close();
           }
      }
      catch(IOException exception)
      {
          System.out.println("Unexpected I/O exception occurs");
      }
      catch(Exception e)
      {
          System.out.println("Unexpected exception occurs");
      }  
  }
}
