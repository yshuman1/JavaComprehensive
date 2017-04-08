import java.util.ArrayList;
import java.util.Scanner;

//marathon class is the heart of this app. displays menu prompts user for choices for configuration of the race and then loops back to begin again or exits


public class Marathon implements CallBackFromThread {

	private static final int exitCondition = 5;
	private ArrayList<Thread> listRunners = new ArrayList<Thread>();
	private ArrayList<String> listNames = new ArrayList<String>();
	private CallBackFromThread callBackFromThread = this;
	private Scanner sc = new Scanner(System.in);
	private boolean raceOver = false;
	private boolean raceStarted = false;
	private int choice;
	private String menu = "\n\nWelcome to the Marathon Race Runner Program\n\n1.  "
			+ "Derby database\n2.  "
			+ "XML file\n3.  "
			+ "Text file\n4.  "
			+ "Default two runners\n5.  "
			+ "Exit\n\n"
			+ "Enter your choice: ";
	private Thread mainThread;

	/**
	 * main constructor of class
	 */
	public Marathon() {
		mainThread = Thread.currentThread();
		choice = Validator.validChoice(sc, menu);
		while (choice != 5) {
			if (choice < 5){
				switch(choice){
				case 1:
					readFromDb();
					break;
				case 2:
					readXmlFile();
					break;
				case 3:
					readTextFile();
					raceStarted= true;
					break;
				case 4:
					defaultTwoRunners();
					raceStarted = true;
					break;
				default:
					choice = Validator.validChoice(sc, menu);
					break;
				}
				try {
					Thread.sleep(Long.MAX_VALUE);
				} catch (InterruptedException e) {
					pressAnyKeyToContinue();
				}
			}

		}
		System.out.println("\nThank you for using my Marathon Race Program");
		return;
	}

	private void pressAnyKeyToContinue() {
		System.out.println("Press enter to continue . . . ");
		try
		{
			System.in.read();
			choice = Validator.validChoice(sc, menu);
			
		}  
		catch(Exception e)
		{}  

	}

	private void readFromDb() {
		@SuppressWarnings("unused")
		DerbyReader derbyReader = new DerbyReader(listNames, listRunners, callBackFromThread);
		for (Thread runner : listRunners) {
			runner.start();
		}

	}


	private void readXmlFile() {
		Validator.validXmlFile(sc, listNames, listRunners, callBackFromThread);
		for (Thread runner : listRunners) {
			runner.start();
		}

	}


	private void readTextFile() {
		Validator.validFile(sc, listNames, listRunners, callBackFromThread);
		for (Thread runner : listRunners) {
			runner.start();
		}
	}


	private void defaultTwoRunners() {

		listNames = new ArrayList<String>();
		listRunners = new ArrayList<Thread>();
		listNames.add("Tortoise");
		listNames.add("Hare");
		ThreadRunner tortoise = new ThreadRunner(listNames.get(0), 10, 0);
		Thread tortoiseThread = new Thread(tortoise);
		ThreadRunner hare = new ThreadRunner(listNames.get(1), 100, 90);
		Thread hareThread = new Thread(hare);
		listRunners.add(tortoiseThread);
		listRunners.add(hareThread);
		tortoise.delegate(callBackFromThread);
		hare.delegate(callBackFromThread);
		tortoiseThread.start();
		hareThread.start();
	}


	@Override
	public void finished(String name) {
		for (Thread runner : listRunners) {
			runner.interrupt();
		}
		System.out.println("The race is over! The " + name + " is the winner.");
		for (String loser : listNames) {
			if (!loser.equals(name)) {
				System.out.println(loser + " : You beat me fair and square.");
			}
		}
		raceOver = true;
		mainThread.interrupt();
		raceStarted = false;
	}
}

