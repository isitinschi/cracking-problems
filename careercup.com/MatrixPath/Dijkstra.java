import java.util.Map;
import java.util.Set;
import java.util.Queue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.lang.Comparable;

public class Dijkstra {
	
	class Point implements Comparable<Point>{
		int x;
		int y;
		int min;
		Point predeccessor;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
			min = Integer.MAX_VALUE;
			predeccessor = null;
		}
		
		@Override
		public int compareTo(Point p) {
			if (min < p.min) {
				return -1;
			} else if (min > p.min) {
				return 1;
			} else {
				return 0;
			}
		}
		
		@Override
		public boolean equals(Object o) {
			if (o != null && o.getClass() == Point.class) {
				Point point = (Point) o;
				if (this.x == point.x && this.y == point.y) {
					return true;
				}
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
			return 13*x +23*y;
		}
	}
	
	public void printShortestPath(int [][] array, int x1, int y1, int x2, int y2) {
		Queue<Point> heap = new PriorityQueue<>();
		Point source = new Point(x1, y1);
		source.min = 0;
		Point dest = new Point(x2, y2);
		heap.add(source);
		
		Map<Integer, Point> map = new HashMap<>();
		map.put(x1*array.length + y1, source);
		Set<Point> visited = new HashSet<>();
		Point cur = null;
		while (!(cur = heap.poll()).equals(dest)) {			
			if (!visited.contains(cur)) {
				visit(cur, array, cur.x - 1, cur.y, map, heap);
				visit(cur, array, cur.x, cur.y - 1, map, heap);
				visit(cur, array, cur.x, cur.y + 1, map, heap);
				visit(cur, array, cur.x + 1, cur.y, map, heap);
				visited.add(cur);
			}
			if (heap.isEmpty()) {
				System.out.println("Point are not connected!");
				return;
			}
		}
		
		cur = map.get(x2*array.length + y2);
		while (cur != null) {
			System.out.println("(" + cur.x + ", " + cur.y + ")");
			cur = cur.predeccessor;
		}
	}
	
	private void visit(Point cur, int [][] array, int i, int j, Map<Integer, Point> map, Queue<Point> heap) {
		if (i >= 0 && i < array.length && j >= 0 && j < array[0].length && array[i][j] != 0) {
			Point p = map.get(i*array.length + j);
			boolean fUpdated = false;
			if (p == null) {
				p = new Point(i, j);
			p.min = cur.min + array[i][j];
				fUpdated = true;
			} else if (p.min > cur.min + array[i][j]) {
				p.min = cur.min + array[i][j];
				heap.remove(p);
				fUpdated = true;
			}
			if (fUpdated) {
				p.predeccessor = cur;			
				map.put(i*array.length + j, p);
				heap.add(p);
			}
		}
	}
	
	public static void main(String [] args) {
		int [][] array = new int [][] {
			{0,0,0,1,0,1},
			{0,0,0,1,0,1},
			{1,1,1,1,0,1},
			{0,0,1,1,0,1},
			{0,1,1,1,0,1},
			{1,1,0,1,0,1},
			{1,1,0,1,0,1}
		};
		
		Dijkstra dijkstra = new Dijkstra();
		dijkstra.printShortestPath(array, 6, 0, 0, 3);
	}
	
}