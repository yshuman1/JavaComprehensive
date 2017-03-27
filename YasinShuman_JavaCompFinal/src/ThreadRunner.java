
public class ThreadRunner extends Thread{
	String name = "";
	int restPercentage;
	int runnersSpeed;
	int distance;
	
	ThreadRunner(String name, int restPercentage, int runnersSpeed){
		this.setName(name);
		this.restPercentage = restPercentage;
		this.runnersSpeed = runnersSpeed;
		System.out.println("thread object created " + this.getName()); 
	}

	public void run() {
		System.out.println("run method called from thread " + this.getName());
			
				for (distance = 0; distance <= 1000; distance += runnersSpeed){
					System.out.println(this.getName() + " " + distance);
					if((int) (Math.random() *100) > restPercentage) Thread.yield();
				}
				System.out.println(this.getName() + " is resting");
			
	}
}

