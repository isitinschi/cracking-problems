import java.lang.Runnable;
import java.lang.Thread;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {
	
	private final String name;
	private final Chopsteak left;
	private final Chopsteak right;
	
	public Philosopher(String name, Chopsteak left, Chopsteak right) {
		this.name = name;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				if (left.acquire(name)) {
					if (right.acquire(name)) {
						System.out.println("Philosopher " + name + " is eating...");
						Thread.sleep(10); // eating
						System.out.println("Philosopher " + name + " finished eating!");					
					} else {
						right.free(name);
						left.free(name);
					}
				} else {
					left.free(name);
				}
				
				Thread.sleep(20); // thinking...
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class Chopsteak {
		
		private final int id;
		private final Lock lock;
		
		public Chopsteak(int id) {
			this.id = id;
			lock = new ReentrantLock();
		}
		
		public boolean acquire(final String name) {
			if (lock.tryLock()) {
				System.out.println("Chopsteak #" + id + " was acquired by " + name);
				return true;
			}
			return false;
		}
		
		public void free(final String name) {
			try {
				lock.unlock();
				System.out.println("Chopsteak #" + id + " is free! Philosopher " + name + " doesn't need it any more.");
			} catch (IllegalMonitorStateException e) {
				System.err.println("Philosopher " + name + " tried to free chopsteak #" + id + " which is not in his hand!");
			}
		}
		
	}
	
	public static void main(String[] args) {
		Chopsteak c1 = new Chopsteak(1);
		Chopsteak c2 = new Chopsteak(2);
		Chopsteak c3 = new Chopsteak(3);
		Chopsteak c4 = new Chopsteak(4);
		
		Philosopher p1 = new Philosopher("Joe", c1, c2);
		Philosopher p2 = new Philosopher("Mike", c2, c3);
		Philosopher p3 = new Philosopher("Tom", c3, c4);
		Philosopher p4 = new Philosopher("Will", c4, c1);
		
		(new Thread(p1)).start();
		(new Thread(p2)).start();
		(new Thread(p3)).start();
		(new Thread(p4)).start();
	}
	
}