
public class ThreadRunner extends Thread{
	String name = "";
	int restPercentage;
	int runnersSpeed;
	int distance;
	ThreadRunner() {
		
	}
	ThreadRunner(String name, int restPercent, int speed){
		this.name = name;
		this.restPercentage = restPercent;
		this.restPercentage = speed;
	}

	public void run() {
		System.out.println("run method called");
		if((int) (Math.random() *100) > restPercentage) {
			for (distance = 0; distance <= 1000; distance += runnersSpeed){
				System.out.println(distance);
			} 
			System.out.println("resting");
		}
	}
}