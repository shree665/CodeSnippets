package readWriteFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This example demonstrates using Scanner to read a file containing lines of structured data. 
 * One Scanner is used to read in each line, and a second Scanner is used to parse each line 
 * into a simple name-value pair. The Scanner class is only used for reading, not for writing.
 */
public class ReadWriteWithScannerUsingJDK7 {
	
	  //local variables 
	  private static Path filepath;
	  private final static Charset ENCODING = StandardCharsets.UTF_8;  
	  
	  /**
	   * Reading file using Scanner
	   * 
	   * @throws IOException
	   */
	  public final static void processLineByLine() throws IOException {
		  Scanner scanner =  new Scanner(filepath, ENCODING.name());
	      while (scanner.hasNextLine()){
	        processLine(scanner.nextLine());
	      } 
	      
	      //closing resource
	      scanner.close();
	  }
	  
	  /**
	   * It is processing the each line which has name value pair like 
	   * apple = red
	   * 
	   * @param aLine
	   */
	  public static void processLine(String aLine){
	    //use a second Scanner to parse the content of each line 
	    Scanner scanner = new Scanner(aLine);
	    scanner.useDelimiter("=");
	    if (scanner.hasNext()){
	      //assumes the line has a certain structure
	      String name = scanner.next();
	      String value = scanner.next();
	      log("Name is : " + name.trim() + ", and Value is : " + value.trim());
	    }
	    else {
	      log("Empty or invalid line. Unable to process.");
	    }
	    scanner.close();
	  }
	  
	  private static void log(Object object){
	    System.out.println(object.toString());
	  }
	  

	  public Path getFilePath() {
			return filepath;
	  }
	  
	  //getting the file path from the file
	  public void setFilePath(String filename) {
		  filepath = Paths.get(filename);
	  }
	  
	  public static void main(String... aArgs) throws IOException {
		  processLineByLine();
		  log("Done.");
	  }
}
