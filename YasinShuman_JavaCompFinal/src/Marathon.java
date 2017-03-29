import java.util.ArrayList;
import java.util.Scanner;




public class Marathon implements CallBackFromThread {

	private static final int exitCondition = 5;
	ArrayList<Thread> listRunners = new ArrayList<Thread>();
	ArrayList<String> listNames = new ArrayList<String>();
	CallBackFromThread callBackFromThread = this;

	public Marathon() {
		Scanner sc = new Scanner(System.in);
		String menu = "Welcome to the Marathon Race Runner Program\n\n1.  "
				+ "Derby database\n2.  "
				+ "XML file\n3.  "
				+ "Text file\n4.  "
				+ "Default two runners\n5.  "
				+ "Exit\n\n"
				+ "Enter your choice: ";
		//String xmlPrompt = "Enter XML file name: ";
		//String textPrompt = "Enter text file name: ";

		int choice = Validator.validChoice(sc, menu);
		while (choice < 5){
			switch(choice){
			case 1:
				break;
			case 2:
				break;
			case 3:
				readTextFile();
				break;
			case 4:
				defaultTwoRunners();
				break;
			default:
				break;

			}
			choice = Validator.validChoice(sc, menu);

		}
		System.out.println("Good Bye!");
		return;

	}


	private void readTextFile() {
		// TODO Auto-generated method stub
		String fileName = Validator.validFile();		
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
		listRunners.get(0).interrupt();
		listRunners.get(1).interrupt();
		System.out.println("The race is over! The " + name + " is the winner.");
		for (String loser : listNames) {
			if (!loser.equals(name)) {
				System.out.println(loser + " : You beat me fair and square.");
			}
		}
	}
}

