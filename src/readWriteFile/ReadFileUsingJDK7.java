package readWriteFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Following all methods are being used to read and write text files in JDK 7 and above.
 * If you pay close attention, closing resources is taken care by Java in all methods below.
 * We need to define the char sets on JDK 7 and above method to read and write text files.
 *
 */
public class ReadFileUsingJDK7 {
	  final static String FILE_NAME = "C:\\Temp\\input.txt";
	  final static String OUTPUT_FILE_NAME = "C:\\Temp\\output.txt";
	  final static Charset ENCODING = StandardCharsets.UTF_8;
	  
	  //For smaller files
	  /**
	   * Note: the java doc of Files.readAllLines says it's intended for small
	   * files. But its implementation uses buffering, so it's likely good 
	   * even for fairly large files.
	   * 
	   * @param aFile - file name
	   * @throws IOException
	   */  

	List<String> readSmallTextFile(String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    return Files.readAllLines(path, ENCODING);
	  }
	  
	/**
	 * Following method is being use to write small files.
	 * 
	 * @param aLines
	 * @param aFileName
	 * @throws IOException
	 */
	 void writeSmallTextFile(List<String> aLines, String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    Files.write(path, aLines, ENCODING);
	  }
	
	 
	 /**
	  * Following method is used to read larger files
	  *  
	  * @param aFileName
	  * @throws IOException
	  */
	  void readLargerTextFile(String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    try (Scanner scanner =  new Scanner(path, ENCODING.name())){
	      while (scanner.hasNextLine()){
	        //process each line in some way
	        log(scanner.nextLine());
	      }      
	    }
	  }
	  
	  /**
	   * Another way to read large files using BufferedReader
	   * @param aFileName
	   * @throws IOException
	   */
	  void readLargerTextFileAlternate(String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
	      String line = null;
	      while ((line = reader.readLine()) != null) {
	        //process each line in some way
	        log(line);
	      }      
	    }
	  }
	  
	  /**
	   * Following method is being used to write large files
	   * @param aFileName
	   * @param aLines
	   * @throws IOException
	   */
	  void writeLargerTextFile(String aFileName, List<String> aLines) throws IOException {
	    Path path = Paths.get(aFileName);
	    try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)){
	      for(String line : aLines){
	        writer.write(line);
	        writer.newLine();
	      }
	    }
	  }
	
	  private static void log(Object aMsg){
	    System.out.println(String.valueOf(aMsg));
	  }
}
