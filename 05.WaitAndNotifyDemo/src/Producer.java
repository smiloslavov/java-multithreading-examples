import java.util.List;

public class Producer implements Runnable {

	private final List<Integer> taskQueue;
	private final int MAX_CAPACITY;
	
	public Producer(List<Integer> sharedQueue, int size) {
		this.taskQueue = sharedQueue;
		this.MAX_CAPACITY = size;
	}
	
	@Override
	public void run() {
		int counter = 0;
		while (true) {
			try {
				Thread.sleep(1000);
				produce(counter++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void produce(int i) throws InterruptedException {
		synchronized (taskQueue) {
			
			while(taskQueue.size() == MAX_CAPACITY) {
				System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting, size: " + taskQueue.size());
				taskQueue.wait();
			}
			
			taskQueue.add(i);
			System.out.println("Produced: " + i);
			taskQueue.notifyAll();
		}
	}

}
