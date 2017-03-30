import java.util.ArrayList;
import java.util.Scanner;




public class Marathon implements CallBackFromThread {

	private static final int exitCondition = 5;
	private ArrayList<Thread> listRunners = new ArrayList<Thread>();
	private ArrayList<String> listNames = new ArrayList<String>();
	private CallBackFromThread callBackFromThread = this;
	private Scanner sc = new Scanner(System.in);
	private boolean raceOver = false;
	private boolean raceStarted = false;
	private int choice;
	private String menu = "Welcome to the Marathon Race Runner Program\n\n1.  "
			+ "Derby database\n2.  "
			+ "XML file\n3.  "
			+ "Text file\n4.  "
			+ "Default two runners\n5.  "
			+ "Exit\n\n"
			+ "Enter your choice: ";
	
	public Marathon() {
		
		
		//String xmlPrompt = "Enter XML file name: ";
		//String textPrompt = "Enter text file name: ";

		choice = Validator.validChoice(sc, menu);
		while (choice < 5){
			switch(choice){
			case 1:
				break;
			case 2:
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
//			while (raceStarted) {
//				if (raceOver) 
//					choice = Validator.validChoice(sc, menu);
//			}
			

		}
		System.out.println("Good Bye!");
		return;

	}


	private void readTextFile() {
		// TODO Auto-generated method stub
		Validator.validFile(sc, listNames, listRunners, callBackFromThread);
		for (Thread runner : listRunners) {
			runner.start();
		}
	}


	private void defaultTwoRunners() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		raceStarted = false;
		choice = Validator.validChoice(sc, menu);
	}
}

