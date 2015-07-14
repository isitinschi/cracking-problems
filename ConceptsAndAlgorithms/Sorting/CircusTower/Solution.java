import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
	
	private static class Person {
		int height;
		int weight;
		
		Person(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}
	}
	
	public static void main(String... args) {
		Person [] input = new Person [] {new Person(65, 100), new Person(70, 150), new Person(56, 90), 
				new Person(75, 190), new Person(60, 95), new Person(68, 110)};
		List<Person> output = new ArrayList<Person>();
		
		System.out.println("The longest possible tower is: " + findLongestTower(Arrays.asList(input), output));
		for (Person p : output) {
			System.out.println("(" + p.height + ", " + p.weight + ")");
		}
	}
	
	private static int findLongestTower(List<Person> input, List<Person> output) {
		Collections.sort(input, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				if (p1.height < p2.height) {
					return -1;
				} else if (p1.height > p2.height) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		Collections.sort(input, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				if (p1.weight < p2.weight) {
					return -1;
				} else if (p1.weight > p2.weight) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		
		int maxN = 0;
		for (int i = 1; i < input.size(); ++i) {
			int curN = 1;
			List<Person> curOutput = new ArrayList<Person>();
			curOutput.add(input.get(i - 1));
			while (i < input.size() &&
					input.get(i - 1).height <= input.get(i).height &&
					input.get(i - 1).weight <= input.get(i).weight) {
				curOutput.add(input.get(i));
				++curN;
				++i;
			}
			if (curN > maxN) {
				maxN = curN;
				output.clear();
				output.addAll(curOutput);
			}
		}
		
		return maxN;
	}	
		
}