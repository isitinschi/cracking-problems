import java.awt.Point;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
	
	public static void main(String... args) {
		List<Point> graph = new ArrayList<Point>();
		graph.add(new Point(1, 2));
		graph.add(new Point(2, 3));
		graph.add(new Point(-1, 3));
		graph.add(new Point(0, 1));
		graph.add(new Point(-2, 2));
		graph.add(new Point(1, 0));
		
		Line line = find(graph);
		System.out.println("Best line: y=" + line.slope + "x " + (line.interceptor > 0 ? "+ " + line.interceptor : line.interceptor));
	}
	
	private static Line find(List<Point> graph) {
		Map<Line, Integer> map = new HashMap<Line, Integer>();
		Line bestLine = null;
		for (Point p1 : graph) {
			for (Point p2 : graph) {
				if (!p1.equals(p2)) {
					Line line = new Line(p1, p2);
					if (!map.containsKey(line)) {
						map.put(line, 0);
					} else {
						map.put(line, map.get(line) + 1);
					}
					if (bestLine == null || map.get(line) > map.get(bestLine)) {
						bestLine = line;
					}
				}
			}
		}
		return bestLine;
	}
	
	private static class Line {
		
		private static final double epsilon = 0.00000001;
		
		double slope;
		double interceptor;
		boolean isInfiniteSlope = false;
		
		Line(Point p1, Point p2) {
			if (p2.x - p1.x == 0) {
				slope = 0;
				interceptor = 0;
				isInfiniteSlope = true;
			} else {
				slope = (p2.y - p1.y) / (p2.x - p1.x);
				interceptor = p1.y - slope * p1.x;
			}
		}
		
		@Override
		public int hashCode() {
			return (int) slope * 1717 | (int) interceptor * 1717;
		}
		
		@Override
		public boolean equals(Object o) {
			Line line = null;
			if (o instanceof Line) {
				line = (Line) o;
			} else {
				return false;
			}
			if (Math.abs(line.slope - slope) < epsilon &&
					Math.abs(line.interceptor - interceptor) < epsilon &&
					line.isInfiniteSlope == isInfiniteSlope) {
				return true;
			}
			return false;
		}
	}
		
}