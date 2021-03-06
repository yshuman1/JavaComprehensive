import java.util.Random;

public class ThreadRunner implements Runnable{
	private String name = "";
	private int restPercentage;
	private int runnersSpeed;
	private int distance;
	private Random random;
	private static final int GOAL = 1000;
	private CallBackFromThread callBackFromThread;
	private boolean raceOver = false;
	
	ThreadRunner(String name, int runnersSpeed, int restPercentage){
		this.setName(name);
		this.restPercentage = restPercentage;
		this.runnersSpeed = runnersSpeed;
		random = new Random(System.currentTimeMillis());
	}

	public int getRunnersSpeed() {
		return runnersSpeed;
	}

	public void setRunnersSpeed(int runnersSpeed) {
		this.runnersSpeed = runnersSpeed;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getRestPercentage() {
		return restPercentage;
	}

	public void setRestPercentage(int restPercentage) {
		this.restPercentage = restPercentage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (distance < GOAL) {
			if (raceOver) return;
			int restPeriod = random.nextInt(100);
			if (restPeriod > restPercentage){
				race();
			} else {
				rest();
			}
			sleep();
		}
		raceOver = true;
		System.out.println(name + " : I finished!\n");
		callBackFromThread.finished(name);
	}

	private void sleep() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			raceOver = true;
		}
		
	}

	private void rest() {
		
	}

	private void race() {
		distance += runnersSpeed;
		System.out.println(name + " : " + distance );
	}

	public void delegate(CallBackFromThread callBackFromThread) {
		this.callBackFromThread = callBackFromThread;
		
	}
}

