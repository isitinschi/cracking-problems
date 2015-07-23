import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Genetic approach
public class Solution2 {
	
	private static int ITERATIONS = 100;
	
	private static Random random = new Random();
	
	public static void main (String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("N = ");
		int n = scanner.nextInt();
		int [][] adjacencyTable = getAdjacencyTable(n, scanner);
		
		int [] list = findShortest(adjacencyTable);
		
		System.out.print("Shortest found path: ");
		for (int i = 0; i < list.length; ++i) {
			System.out.print(list[i] + " ");
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
		
		int [] p1 = new int[n];
		int [] p2 = new int[n];
		for (int i = 0; i < n; ++i) {
			p1[i] = i;
			p2[n - i - 1] = i;
		}
		
		int iteration = 0;		
		while (iteration++ < ITERATIONS) {
			int [] child = cross(p1, p2, adjacencyTable);
			if (random.nextInt(100) < 50) { // 50% possibility of mutations
				child = mutation(child, adjacencyTable);
			}
			if (distance(child, adjacencyTable) < distance(p1, adjacencyTable) && 
					distance(p1, adjacencyTable) >= distance(p2, adjacencyTable)) {
				p1 = child;
			} else if (distance(child, adjacencyTable) < distance(p2, adjacencyTable) && 
					distance(p2, adjacencyTable) >= distance(p1, adjacencyTable)) {
				p2 = child;
			}
		}
		
		if (distance(p1, adjacencyTable) < distance(p2, adjacencyTable)) {
			return p1;
		} else {
			return p2;
		}
	}
	
	private static int [] cross(int [] p1, int [] p2, int [][] adjacencyTable) {
		int n = p1.length;
		int [] child = new int[n];
		boolean [] visited = new boolean[n];
		
		int index = random.nextInt(n);
		child[0] = p1[index];
		visited[p1[index]] = true;
		int i = 1;
		while (i < n) {
			int fromP1 = -1;
			int fromP2 = -1;
			for (int j = 0; j < n; ++j) {
				if (p1[j] == child[i - 1] && !visited[p1[j]]) {
					fromP1 = p1[j];
				}
				if (p2[j] == child[i - 1] && !visited[p2[j]]) {
					fromP2 = p2[j];
				}
			}
			
			if (fromP1 != -1) {
				if (fromP2 != -1) {
					if (adjacencyTable[child[i - 1]][fromP1] < adjacencyTable[child[i - 1]][fromP2]) {
						child[i] = fromP1;
						visited[fromP1] = true;							
					} else {
						child[i] = fromP2;
						visited[fromP2] = true;
					}
				} else {
					child[i] = fromP1;
					visited[fromP1] = true;	
				}
			} else if (fromP2 != -1) {
				// from parent 2
				child[i] = fromP2;
				visited[fromP2] = true;	
			} else {
				// first unvisited
				for (int j = 0; j < n; ++j) {
					if (!visited[j]) {
						child[i] = j;
						visited[j] = true;
						break;
					}
				}
			}
			
			++i;
		}
		
		return child;
	}
	
	private static int [] mutation(int [] child, int [][] adjacencyTable) {
		int [] mutant = Arrays.copyOf(child, child.length);
		int i = 0;
		while (distance(mutant, adjacencyTable) >= distance(child, adjacencyTable) && i++ < ITERATIONS) {
			int i1 = random.nextInt(child.length);
			int i2 = random.nextInt(child.length);
			int t = mutant[i1];
			mutant[i1] = mutant[i2];
			mutant[i2] = t;
		}
		return mutant;
	}
	
	private static int distance(int [] p, int [][] adjacencyTable) {
		int distance = 0;
		
		for (int i = 0; i < p.length - 1; ++i) {
			distance += adjacencyTable[p[i]][p[i + 1]];
		}
		
		return distance;
	}
	
}