
public class ThreadRunner extends Thread{
	String name = "";
	int restPercentage;
	int runnersSpeed;
	int distance;
	ThreadRunner() {
		
	}
	ThreadRunner(String name, int restPercentage, int runnersSpeed){
		this.setName(name);
		this.restPercentage = restPercentage;
		this.restPercentage = runnersSpeed;
		System.out.println("thread object created " + this.getName()); 
	}

	public void run() {
		System.out.println("run method called from thread " + this.getName());
		/*if((int) (Math.random() *100) > restPercentage) {
			for (distance = 0; distance <= 1000; distance += runnersSpeed){
				System.out.println(distance);
			} 
			System.out.println("resting");
		}*/
	}
}
