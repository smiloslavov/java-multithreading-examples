import java.util.List;

public class Consumer implements Runnable {

	private final List<Integer> taskQueue;
	
	public Consumer(List<Integer> sharedQueue) {
		this.taskQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	
	private void consume() throws InterruptedException {
		synchronized(taskQueue) {
			while (taskQueue.isEmpty()) {
				System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting, size: " + taskQueue.size());
				taskQueue.wait();
			}
			
			int consumedValue = (Integer) taskQueue.remove(0);
			System.out.println("Consumed: " + consumedValue);
			
			taskQueue.notifyAll();
		}
	}
}
