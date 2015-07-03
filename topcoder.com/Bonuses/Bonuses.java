import java.util.PriorityQueue;
import java.util.Collections;

public class Bonuses {
	
	public int [] getDivision(int [] points) {
		int total = calcTotal(points);
		return calcDivisions(points, total);
	}
	
	private int calcTotal(int [] points) {
		int total = 0;
		for (int i = 0; i < points.length; ++i) {
			total += points[i];
		}
		return total;
	}
	
	private int [] calcDivisions(int [] points, int total) {
		int [] divisions = new int[points.length];
		int sum = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(50, Collections.reverseOrder());
		for (int i = 0; i < points.length; ++i) {
			int point = points[i];
			float fPerc = (float) point / total;
			int perc = (int) (fPerc * 100);
			sum += perc;
			divisions[i] = perc;
			queue.add(points[i]);
		}
		
		while (100 - sum > 0) {
			int max = queue.poll();
			for (int i = 0; i < points.length; ++i) {
				if (points[i] == max && 100 - sum > 0) {
					++divisions[i];
					++sum;
				}
			}
			while (!queue.isEmpty() && queue.peek() == max) {
				queue.remove();
			}
		}
		
		return divisions;
	}
	
	public static void main(String... args) {
		int [] divisions = new Bonuses().getDivision(new int [] {1,2,3,4,5});
		for (int i = 0; i < divisions.length; ++i) {
			System.out.print(divisions[i] + " ");
		}
	}
	
}