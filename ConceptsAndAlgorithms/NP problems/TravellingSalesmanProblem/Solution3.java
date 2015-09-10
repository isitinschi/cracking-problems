import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// Straightforward approach (checking all permutations)
public class Solution3 {
	
	public static void main (String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("N = ");
		int n = scanner.nextInt();
		int [][] adjacencyTable = getAdjacencyTable(n, scanner);
		
		int [] list = findShortest(adjacencyTable);
		
		if (list != null) {
			System.out.print("Shortest found path: ");
			for (int i = 0; i < list.length; ++i) {
				System.out.print(list[i] + " ");
			}
		}
	}
	
	private static int [][] getAdjacencyTable(int n, Scanner scanner) {
		int [][] table = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i == j) {
					table[i][j] = 0;
				} else {
					table[i][j] = scanner.nextInt();
				}
			}
		}
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
		
		return table;
	}
	
	private static int [] findShortest(int [][] adjacencyTable) {
		int n = adjacencyTable.length;
		
		List<Integer> cities = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			cities.add(i);
		}
		List<List<Integer>> permutations = permutations(cities);
		int min = Integer.MAX_VALUE;
		int [] result = null;
		for (List<Integer> permutation : permutations) {
			int distance = distance(permutation, adjacencyTable);
			if (distance < min) {
				min = distance;
				result = permutation.stream().mapToInt(i->i).toArray();
			}
		}
		
		return result;
	}
	
	private static List<List<Integer>> permutations(List<Integer> cities) {
		if (cities.isEmpty()) {
			return new ArrayList<List<Integer>>();
		} else if (cities.size() == 1) {
			List<List<Integer>> newPermutations = new ArrayList<>();
			newPermutations.add(cities);
			return newPermutations;
		}
		
		int city = cities.remove(0);
		List<List<Integer>> permutations = permutations(cities);
		List<List<Integer>> newPermutations = new ArrayList<>();
		for (List<Integer> permutation : permutations) {
			for (int i = 0; i <= permutation.size(); ++i) {
				List<Integer> newPermutation = new ArrayList<>(permutation);
				newPermutation.add(i, city);
				
				newPermutations.add(newPermutation);
			}
		}
		
		return newPermutations;
	}
	
	private static int distance(List<Integer> p, int [][] adjacencyTable) {
		int distance = 0;
		
		for (int i = 0; i < p.size() - 1; ++i) {
			distance += adjacencyTable[p.get(i)][p.get(i + 1)];
		}
		
		return distance;
	}
	
}