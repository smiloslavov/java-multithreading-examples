
public class TestRunnable {

	public static void main(String[] args) {
		RunnableDemo R1 = new RunnableDemo("Thread 1");
		R1.runnableStart();
		
		RunnableDemo R2 = new RunnableDemo("Thread 2");
		R2.runnableStart();
	}

}
