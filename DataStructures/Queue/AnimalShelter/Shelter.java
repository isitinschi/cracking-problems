import java.util.Queue;
import java.util.LinkedList;
import java.util.Date;

public class Shelter {
	
	private Queue<Node> dogs;
	private Queue<Node> cats;
	
	class Node {
		long time;
		String name;
		Node next;
		
		Node(String name, long time) {
			this.name = name;
			this.time = time;
		}
	}
	
	public void enqueue(String name, boolean dog) {
		Node animal = new Node(name, System.nanoTime());
		if (dog) {
			if (dogs == null) {
				dogs = new LinkedList<Node>();
			}
			dogs.add(animal);
		} else {
			if (cats == null) {
				cats = new LinkedList<Node>();
			}
			cats.add(animal);
		}
	}
	
	public String dequeueAny() {
		if (!dogs.isEmpty() && !cats.isEmpty()) {
			Node dog = dogs.peek();
			Node cat = cats.peek();
			if (dog.time < cat.time) {
				return dogs.poll().name;
			} else {
				return cats.poll().name;
			}
		} else if (dogs.isEmpty()) {
			return cats.poll().name;
		} else if (cats.isEmpty()) {
			return dogs.poll().name;
		}
		
		return null;
	}
	
	public String dequeueCat() {
		if (!cats.isEmpty()) {
			return cats.poll().name;
		}
		
		return null;
	}
	
	public String dequeueDog() {
		if (!dogs.isEmpty()) {
			return dogs.poll().name;
		}
		
		return null;
	}
	
	public static void main(String ... args) {
		Shelter shelter = new Shelter();
		for (int i = 0; i < 10; ++i) {
			if (i % 2 == 0) {
				shelter.enqueue("dog " + i, true);
			} else {
				shelter.enqueue("cat " + i, false);
			}
		}
		
		for (int i = 0; i < 10; ++i) {
			if (i < 5) {
				System.out.println("Dequeue any: " + shelter.dequeueAny());
			} else if (i % 2 == 0) {
				System.out.println("Dequeue dog: " + shelter.dequeueDog());
			} else {
				System.out.println("Dequeue cat: " + shelter.dequeueCat());
			}
		}
	}
	
}