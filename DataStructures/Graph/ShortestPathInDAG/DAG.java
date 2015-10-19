import java.util.Stack;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

public class DAG {
	
	private int [][] adjMatrix;
	
	public DAG(int [][] adjMatrix) {
		if (adjMatrix == null || adjMatrix.length == 0 || adjMatrix[0].length == 0) {
			throw new IllegalArgumentException("Empty adjacency matrix");
		}
		if (adjMatrix.length != adjMatrix[0].length) {
			throw new IllegalArgumentException("Wrong adjacency matrix");
		}
		this.adjMatrix = adjMatrix;
	}
	
	public void printShortestPath(int v1, int v2) {
		if (v1 < 0 || v2 < 0 || v1 >= adjMatrix.length || v2 >= adjMatrix.length || v1 == v2) {
			throw new IllegalArgumentException("Wrong input values");
		}
		
		Queue<Integer> queue = topologicalSort();
		
		int [] distance = new int[adjMatrix.length];
		int [] predecessor = new int[adjMatrix.length];
		distance[v1] = 0;
		predecessor[v1] = v1;
		for (int i = 0; i < adjMatrix.length; ++i) {
			if (i != v1) {
				distance[i] = Integer.MAX_VALUE;
				predecessor[i] = i;
			}
		}
		
		while (!queue.isEmpty()) {
			int v = queue.poll();
			for (int i = 0; i < adjMatrix.length; ++i) {
				if (v != i && adjMatrix[v][i] != 0) {
					if (distance[v] != Integer.MAX_VALUE && distance[v] + adjMatrix[v][i] < distance[i]) {
						distance[i] = distance[v] + adjMatrix[v][i];						
						predecessor[i] = v;
					}					
				}
			}
		}
		
		if (predecessor[v2] == v2) {
			System.out.println("There is no path between these nodes.");
		} else {
			System.out.println("Shortest path is " + distance[v2] + ":");
			int i = v2;
			System.out.println(v2);
			while (predecessor[i] != i) {
				System.out.println(predecessor[i]);
				i = predecessor[i];
			}
		}
	}
	
	private Queue<Integer> topologicalSort() {
		Queue<Integer> output = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
				
		for (int i = 0; i < adjMatrix.length; ++i) {
			if (!visited.contains(i)) {
				process(visited, output, i, new HashSet<Integer>());
			}
		}
		
		return output;
	}
	
	private void process(Set<Integer> visited, Queue<Integer> output, int v, HashSet<Integer> cycleDetection) {
		if (cycleDetection.contains(v)) {
			throw new RuntimeException("Cycle detected.");
		}
		
		if (!visited.contains(v)) {
			output.add(v);
			visited.add(v);
			cycleDetection.add(v);
			for (int i = 0; i < adjMatrix.length; ++i) {
				if (i != v && adjMatrix[v][i] != 0) {
					process(visited, output, i, new HashSet<Integer>(cycleDetection));
				}
			}
		}
	}
		
	public static void main(String [] args) {
		int size = 5;
		int [][] adjMatrix = new int[][] {
			{0,1,0,0,0},
			{0,0,3,2,0},
			{0,0,0,1,0},
			{0,0,0,0,1},
			{0,0,0,0,0},
		};
		System.out.println("Adjacency matrix: ");
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				System.out.print(" " + adjMatrix[i][j]);
			}
			System.out.println();
		}
		
		DAG dag = new DAG(adjMatrix);
		dag.printShortestPath(0, size - 1);
	}
	
}