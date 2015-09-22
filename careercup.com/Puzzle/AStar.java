import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.PriorityQueue;

public class AStar {
	
	private Queue<Point> queue;
	private Map<Integer, Point> points;
	private Set<Point> visited;
	private int [][] adjacencyMatrix;
	private Point end;
	
	class Point implements Comparable<Point> {
		int x;
		int y;
		int min; // min distance
		int hash; // approximate distance to end point
		Point predeccessor;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
			min = Integer.MAX_VALUE;
			
			if (end != null) {
				hash = (int) Math.sqrt(Math.pow(x - end.x, 2) + Math.pow(y - end.y, 2));
			}
		}
		
		@Override
		public int compareTo(Point p) {
			return Integer.valueOf(min + hash).compareTo(p.min + p.hash);
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == null || o.getClass() != Point.class) {
				return false;
			}
			Point p = (Point) o;
			if (x == p.x && y == p.y) {
				return true;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return 13*x + 23*y;
		}
		
	}
	
	public int findShortestPath(int [][] adjacencyMatrix, int x1, int y1, int x2, int y2) {
		if (adjacencyMatrix == null) {
			throw new IllegalArgumentException("Matrix is null");
		}
		
		queue = new PriorityQueue<>();
		points = new HashMap<>();
		visited = new HashSet<>();
		this.adjacencyMatrix = adjacencyMatrix;		
		end = new Point(x2, y2);
		
		Point start = new Point(x1, y1);
		start.min = 0;
		
		queue.add(start);		
		points.put(x1*adjacencyMatrix.length + y1, start);
				
		Point cur = null;
		while (!(cur = queue.poll()).equals(end)) {
			if (!visited.contains(cur)) {				
				visit(cur, cur.x - 1, cur.y);
				visit(cur, cur.x, cur.y - 1);
				visit(cur, cur.x, cur.y + 1);
				visit(cur, cur.x + 1, cur.y);
				visited.add(cur);
			}
		}
		
		cur = points.get(x2*adjacencyMatrix.length + y2); // end point
		int shortestDistance = cur.min;
		
		System.out.println("Shortest path: ");
		while (cur != null) {
			System.out.print(" (" + cur.x + ", " + cur.y + ")");
			cur = cur.predeccessor;
		}
		
		return shortestDistance;
	}
	
	private void visit(Point cur, int i, int j) {
		if (i >= 0 && i < adjacencyMatrix.length && j >= 0 && j < adjacencyMatrix[0].length && adjacencyMatrix[i][j] != 0) {
			Point p = points.get(i*adjacencyMatrix.length + j);
			boolean fUpdate = false;
			if (p == null) {
				p = new Point(i, j);
				fUpdate = true;				
			} else if (cur.min + adjacencyMatrix[i][j] < p.min) {				
				fUpdate = true;
				queue.remove(p);				
			}
			if (fUpdate) {
				p.min = cur.min + adjacencyMatrix[i][j];
				p.predeccessor = cur;				
				points.put(i*adjacencyMatrix.length + j, p);
				queue.add(p);
			}
		}
	}
	
	public static void main(String[] args) {
		AStar aStar = new AStar();
		int [][] matrix = new int [][] {
			{0,0,0,1,0},
			{1,0,0,1,0},
			{0,1,0,1,1},
			{1,0,0,0,1},
			{1,1,1,0,1},
			{1,1,1,1,1}
		};
		int shortestDistance = aStar.findShortestPath(matrix, 5, 0, 0, 3);
		System.out.println("Shortest distance: " + shortestDistance);
	}
	
}