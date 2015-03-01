package readWriteFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWriteFile {
	
	/**
	 * Static method to read file using BufferedReader, InputStreamReader and FileInputStream
	 * @param aFile
	 */
	public static void readWriteFileMethod1(File aFile) {
		//reading from a file and writing into another file
		try {
			//Construct BufferedReader from InputStreamReader for fast reading
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(aFile)));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("myWriteFile.txt"))));
		 
			String line = null;
			while ((line = br.readLine()) != null) {
				/**
				 * You can split each line here, if you need but you need to know
				 * the data splitter a head of time.
				 */
				System.out.println(line);
				
				//writing each line to the myWriterFile.txt
				bw.write(line);
			}
		 
			//Closing resources. Always good idea to close resource when we don't need
			br.close();
			bw.close();
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
	public static void readWriteFileMethod2(File aFile) {
		// Construct BufferedReader from FileReader
		BufferedReader br;
		BufferedWriter bw;
		try {
			br = new BufferedReader(new FileReader(aFile));
			bw = new BufferedWriter(new FileWriter(new File("mySecondFile.txt")));
	 
			String line = null;
			while ((line = br.readLine()) != null) {
				/**
				 * You can split each line here if you need but you need to know
				 * the data splitter a head of time.
				 */
				System.out.println(line);
				bw.write(line);
			}
		 
			//Closing resources. Always good idea to close resource when we don't need
			br.close();
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Static method to read file using Scanner and FileInputStream
	 * @param aFile
	 * @throws IOException 
	 */
	public static void readWriteFileMethod3(File aFile) throws IOException {
		
		//String builder is just to append/concat the each line to the text
	    StringBuilder text = new StringBuilder();
	    Scanner scanner = new Scanner(new FileInputStream(aFile), "UTF-8");
	    PrintWriter pw = new PrintWriter(new FileWriter(new File("outputFile.txt")));
	    while (scanner.hasNextLine()){
	    	/**
			 * You can split each line here if you need but you need to know
			 * the data splitter a head of time.
			 */
	        text.append(scanner.nextLine() + System.getProperty("line.separator"));
	        pw.write(scanner.nextLine());
	      }
	    System.out.println("The text that we read: " + text);
	    scanner.close();
	    pw.close();
	  }
	
	public static void main(String[] args) throws IOException {
		//reading file using scanner
		try {
			ReadWriteFile.readWriteFileMethod3(new File("../MyWebProjectCodes/resources/myTest.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//reading file FileReader and BufferedReader
		ReadWriteFile.readWriteFileMethod2(new File("../MyWebProjectCodes/resources/myTest.txt"));
		System.out.println();
		
		//reading file in fileInputStream
		ReadWriteFile.readWriteFileMethod1(new File("../MyWebProjectCodes/resources/myTest.txt"));
		System.out.println();
	}

}
