//Just some code to practice some io


import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.stream.XMLStreamException;

public class Learn {

	public static void main(String[] args) throws IOException, XMLStreamException {
		
		//create a text file named yasinsTextFile.txt and save some data to it
		Path textPath = Paths.get("/Users/yasin/Documents/yasinsTextFile.txt");
		File textFile = textPath.toFile();
		String timeStamp = new SimpleDateFormat("MM.dd.HH.mm").format(new Date());
		System.out.println("Creating Text File \"yasinsTextFile\".");
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(textFile)))) {
			out.println("Successfully created and wrote to the text file named " + textPath + "\nThis file was created at: " + timeStamp);
			System.out.println("Successfully created and wrote to the text file named " + textPath + "\nThis file was created at: " + timeStamp);
			out.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		//append to an existing text file
		try (PrintWriter outAppend = new PrintWriter(new BufferedWriter(new FileWriter(textFile, true)))) {
			outAppend.println("This line was appended to the file on " + timeStamp );
			System.out.println("Successfully Appended to the text file name " + textPath + "\nThis appended text is \"This line was added on " + timeStamp + "\"");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//read from a text file
		try (BufferedReader inText = new BufferedReader(new FileReader(textFile))) {
			String line;
			while ((line = inText.readLine()) != null) {
				System.out.println("Read from the file:\n" + line);
			}
		inText.close();
		} catch (IOException e) {
			
		} 
		
		//create a csv file named yasinsCsvFile.csv and save some data to it
		//added throws to main method so i wouldnt have to use try catch block on this one
		
		Path csvPath = Paths.get("/Users/yasin/Documents/yasinsCsvFile.txt");
		File csvFile = csvPath.toFile();
		PrintWriter out3 = new PrintWriter(new BufferedWriter(new FileWriter(csvFile)));
			int i = 0;
			while (i < 30 ){
				out3.print(SomeObject.getCount() + ",");
				out3.println(SomeObject.updateCount(SomeObject.getCount()) + ",");
				System.out.print(SomeObject.getCount() + ",");
				System.out.println(SomeObject.updateCount(SomeObject.getCount()) + ",");
				i++;
			}
		out3.close();
		
		//read each line from csv file and count how many lines by creating an object that takes in both numbers
		BufferedReader inCsv = new BufferedReader(new FileReader(csvFile));
		String line = inCsv.readLine();
		while (line != null){
			String[] columns = line.split(",");
			String num1 = columns[0];
			String num2 = columns[1];
			new SomeObject(num1, num2);
			line = inCsv.readLine();
			//System.out.println(S);
			
		}
		inCsv.close();
	
		//read each number from a csv and create an object from it and count how many numbers are in the file
		BufferedReader inCsv2 = new BufferedReader(new FileReader(csvFile));
		String line2 = inCsv2.readLine();
		while (line2 != null){
			String[] columns = line2.split(",");
			String num1 = columns[0];
			new SomeObject(num1);
			line2 = inCsv2.readLine();
			//System.out.println(S2);
			
		}inCsv2.close();
	}
}

