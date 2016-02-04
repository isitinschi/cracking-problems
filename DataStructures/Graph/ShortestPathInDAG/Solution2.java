import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Solution2 {
	
	public static void main(String [] args) {
		Solution2 s = new Solution2();
		
		int [][] adjMatrix = new int [][] {
			{0,0,2,3,0},
			{0,0,0,0,2},
			{0,0,0,2,0},
			{0,0,0,0,1},
			{1,0,0,0,0},
		};
		
		s.printShortestPath(adjMatrix, 0, 4);
	}
	
	public void printShortestPath(int [][] adjMatrix, int source, int dest) {
		if (source == dest) {
			System.out.println("Source equals destination!");
			return;
		}
		
		if (source < 0 || dest < 0) {
			System.out.println("Wrong parameters!");
			return;
		}
		
		if (adjMatrix == null || adjMatrix.length < Math.max(source, dest) || adjMatrix[0].length < Math.max(source, dest)) {
			System.out.println("Wrong adjacency matrix!");
			return;
		}
		
		Queue<Integer> queue = topologicalSort(adjMatrix, source);
		
		int [] dist = new int [adjMatrix.length];
		int [] pred = new int [adjMatrix.length];
		for (int i = 0; i < adjMatrix.length; ++i) {
			dist[i] = -1;
			pred[i] = -1;
		}
		
		dist[source] = 0;
		pred[source] = source;
		
		while (!queue.isEmpty()) {
			int v = queue.poll();
			if (dist[v] != -1) {
				for (int i = 0; i < adjMatrix[0].length; ++i) {
					if (i != v && adjMatrix[v][i] != 0) {
						if (dist[i] == -1 || dist[i] > dist[v] + adjMatrix[v][i]) {
							dist[i] = dist[v] + adjMatrix[v][i];
							pred[i] = v;
						}
					}
				}
			}
		}
		
		if (dist[dest] != -1) {
			System.out.println("Distance is " + dist[dest]);
			
			System.out.println("Route:");
			int i = dest;
			
			System.out.println(dest);
			while (pred[i] != source) {
				System.out.println(pred[i]);
				i = pred[i];
			}
			System.out.println(source);
		} else {
			System.out.println("There is no route between source and destination!");
		}
	}
	
	private Queue<Integer> topologicalSort(int [][] adjMatrix, int source) {
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		
		sort(source, queue, visited, adjMatrix);
		for (int i = 0; i < adjMatrix.length; ++i) {
			if (i != source && !visited.contains(i)) {
				sort(i, queue, visited, adjMatrix);
			}
		}
		
		return queue;
	}
	
	private void sort(int v, Queue<Integer> queue, Set<Integer> visited, int [][] adjMatrix) {
		if (!visited.contains(v)) {
			queue.add(v);
			visited.add(v);
			
			for (int i = 0; i < adjMatrix.length; ++i) {
				if (i != v && adjMatrix[v][i] != 0) {
					sort(i, queue, visited, adjMatrix);
				}
			}
		}
	}
	
}