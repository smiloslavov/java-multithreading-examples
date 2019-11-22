
public class TheadGuessDemo {

	public static void main(String[] args) {
		Runnable hello = new DisplayMessage("Hello");
		Thread tread1 = new Thread(hello);
		tread1.setName("hello");
		tread1.setDaemon(true);
		tread1.setPriority(Thread.MIN_PRIORITY);
		tread1.start();
		
		Thread thread2 = new GuessANumber(27);
		thread2.start();
		
		System.out.println("main() is ending...");
	}

}
