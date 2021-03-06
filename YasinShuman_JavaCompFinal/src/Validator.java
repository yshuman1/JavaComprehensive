import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Validator {
	public static int validChoice(Scanner sc, String menu) {
		while (true) {
			System.out.print(menu);
			if (sc.hasNextInt()) {
				int choice = sc.nextInt();
				sc.nextLine();
				if (choice >= 1 && choice <= 5) {
					return choice;
				}
			}   
			System.out.println("\nError! Invalid value. Try again.");
			sc.nextLine();
		}
	}

	public static void validFile(Scanner sc, ArrayList<String> listNames, 
			ArrayList<Thread> listRunners, CallBackFromThread callBackFromThread) {
		System.out.println("Enter text file name: ");
		if (sc.hasNextLine()) {
			String fileName = sc.nextLine();
			File textFile = new File(fileName);
			//read from a text file
			try (BufferedReader inText = new BufferedReader(new FileReader(textFile))) {
				String line;
				while ((line = inText.readLine()) != null) {
					boolean valid = createLists(listNames, listRunners, line, callBackFromThread);
				}
				inText.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}

	}

	private static boolean createLists(ArrayList<String> listNames, ArrayList<Thread> listRunners, String line, CallBackFromThread callBackFromThread) {
		// TODO Auto-generated method stub
		String[] runnersData = line.split(" ");
		if (runnersData.length != 3) 
			return false;
		listNames.add(runnersData[0].trim());
		ThreadRunner runner = new ThreadRunner(
				runnersData[0].trim(),
				Integer.valueOf(runnersData[1].trim()), 
				Integer.valueOf(runnersData[2].trim()));
		runner.delegate(callBackFromThread);
		Thread runnerThread = new Thread(runner);
		listRunners.add(runnerThread);
		return true;
	}

	public static void validXmlFile(Scanner sc, ArrayList<String> listNames, ArrayList<Thread> listRunners,
			CallBackFromThread callBackFromThread) {
		// TODO Auto-generated method stub
		System.out.print("Enter XML file name: ");
		if (sc.hasNextLine()) {
			String fileName = sc.nextLine();
			File XmlFile = new File(fileName);
			//read from a xml file
			XMLInputFactory inputFactory =
					XMLInputFactory.newFactory();
			try
			{
				// create an XMLStreamReader object
				FileReader fileReader =
						new FileReader(XmlFile);
				XMLStreamReader reader =
						inputFactory.createXMLStreamReader(fileReader);
				// Read XML here
				String name = null;
				int runnersSpeed = 0;
				int restPercentage = 0;
				while (reader.hasNext()) {
					int eventType = reader.getEventType();
					switch (eventType)
					{
					case XMLStreamConstants.START_ELEMENT:
						String elementName = reader.getLocalName();
		                  if (elementName.equals("Runner")) {
		                	name = reader.getAttributeValue(0);
							System.out.println("XML complete");
		                  }
		                  if (elementName.equals("RunnersMoveIncrement")) {
		                	  String increment = reader.getElementText();
		                	  runnersSpeed = Integer.valueOf(increment);
		                  }
		                  if (elementName.equals("RestPercentage")) {
		                	  String percent = reader.getElementText();
		                	  restPercentage = Integer.valueOf(percent);
		                  }
		                break;
					case XMLStreamConstants.END_ELEMENT:
						elementName = reader.getLocalName();
						if (elementName.equals("Runner")) {
							listNames.add(name);
							ThreadRunner runner = new ThreadRunner(
									name,
									runnersSpeed,
									restPercentage);
							runner.delegate(callBackFromThread);
							Thread runnerThread = new Thread(runner);
							listRunners.add(runnerThread);
						}
						break;
					default:
						break; }
					reader.next();
					
				}
			}
			catch (IOException | XMLStreamException e)
			{
				System.out.println(e);
			}
			System.out.println("end");
		}

	}


}


