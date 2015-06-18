import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class TowersOfHanoi {
	
	public static void main(String...args) {
		int N = readN();
		List<Stack<Integer>> towers = populateTowers(N);
		System.out.println("Initial state :");
		print(towers);
		
		processTowers(towers, N);
		System.out.println("Final state :");
		print(towers);
	}
	
	public static int readN() {
		Scanner s = new Scanner(System.in);
		System.out.print("N = ");
		int N = s.nextInt();
		if (N < 1) {
			throw new IllegalArgumentException();
		}
		return N;
	}
	
	public static List<Stack<Integer>> populateTowers(int N) {
		Stack<Integer> tower = new Stack<Integer>();
		for (int i = N; i > 0; --i) {
			tower.push(i);
		}
		
		List<Stack<Integer>> towers = new ArrayList<Stack<Integer>>();
		towers.add(tower);
		towers.add(new Stack<Integer>());
		towers.add(new Stack<Integer>());
		
		return towers;
	}
	
	public static void processTowers(List<Stack<Integer>> towers, int N) {
		move(towers.get(0), towers.get(1), towers.get(2), N);
	}
	
	public static void move (Stack<Integer> source, Stack<Integer> buffer, Stack<Integer> dest, int N) {
		if (N > 0) {
			move(source, dest, buffer, N - 1);
			dest.push(source.pop());
			move(buffer, source, dest, N - 1);
		}
	}
	
	public static void print(List<Stack<Integer>> towers) {
		int index = 1;
		for (Stack<Integer> tower : towers) {
			System.out.println("Tower " + index++ + ":");
			Stack<Integer> buffer = new Stack<Integer>();
			while (!tower.isEmpty()) {
				int value = tower.pop();
				System.out.println(value);
				buffer.push(value);
			}
			while (!buffer.isEmpty()) {
				tower.push(buffer.pop());
			}
			System.out.println();
		}
	}
}