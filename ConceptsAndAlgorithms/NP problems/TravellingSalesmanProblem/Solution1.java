import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

// Nearest neighbour
public class Solution1 {
	
	public static void main (String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("N = ");
		int n = scanner.nextInt();
		int [][] adjacencyTable = getAdjacencyTable(n, scanner);
		
		List<Integer> list = findShortest(adjacencyTable);
		
		System.out.print("Shortest found path: ");
		for (Integer city : list) {
			System.out.print(city + " ");
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
	
	private static List<Integer> findShortest(int [][] adjacencyTable) {
		List<Integer> list = new ArrayList<Integer>();
		boolean [] visited = new boolean[adjacencyTable.length];
		
		int curCity = 0;
		visited[curCity] = true;
		list.add(curCity);
		
		while (true) {
			int min = Integer.MAX_VALUE;
			int nearestCity = -1;
			for (int i = 0; i < adjacencyTable.length; ++i) {
				if (i != curCity && !visited[i]) {
					if (adjacencyTable[curCity][i] < min) {
						min = adjacencyTable[curCity][i];
						nearestCity = i;
					}
				}
			}
			if (nearestCity != -1) {
				visited[nearestCity] = true;
				list.add(nearestCity);
				curCity = nearestCity;
			} else {
				break;
			}
		}
		
		return list;
	}
	
}