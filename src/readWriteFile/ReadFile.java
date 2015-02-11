package readWriteFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFile {
	
	/**
	 * Static method to read file using BufferedReader, InputStreamReader and FileInputStream
	 * @param aFile
	 */
	public static void readFileMethod1(File aFile) {
		try {
			//Construct BufferedReader from InputStreamReader for fast reading
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(aFile)));
		 
			String line = null;
			while ((line = br.readLine()) != null) {
				/**
				 * You can split each line here, if you need but you need to know
				 * the data splitter a head of time.
				 */
				System.out.println(line);
			}
		 
			//Closing resources. Always good idea to close resource when we don't need
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(aFile +" file is not found in the path that you provided");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Static method to read file using BufferedReader, FileReader
	 * @param aFile
	 */
	public static void readFileMethod2(File aFile) {
		// Construct BufferedReader from FileReader
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(aFile));
	 
			String line = null;
			while ((line = br.readLine()) != null) {
				/**
				 * You can split each line here if you need but you need to know
				 * the data splitter a head of time.
				 */
				System.out.println(line);
			}
		 
			//Closing resources. Always good idea to close resource when we don't need
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Static method to read file using Scanner and FileInputStream
	 * @param aFile
	 */
	public static void readFileMethod3(File aFile) throws FileNotFoundException {
		
		//String builder is just to append/concat the each line to the text
	    StringBuilder text = new StringBuilder();
	    Scanner scanner = new Scanner(new FileInputStream(aFile), "UTF-8");
	    while (scanner.hasNextLine()){
	    	/**
			 * You can split each line here if you need but you need to know
			 * the data splitter a head of time.
			 */
	        text.append(scanner.nextLine() + System.getProperty("line.separator"));
	      }
	    System.out.println("The text that we read: " + text);
	    scanner.close();
	  }
	
	public static void main(String[] args) {
		//reading file using scanner
		try {
			ReadFile.readFileMethod3(new File("../MyWebProjectCodes/myTest.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//reading file FileReader and buffered reader
		ReadFile.readFileMethod2(new File("../MyWebProjectCodes/myTest.txt"));
		System.out.println();
		
		//reading file in fileinputstreadm
		ReadFile.readFileMethod1(new File("../MyWebProjectCodes/myTest.txt"));
		System.out.println();
	}

}
