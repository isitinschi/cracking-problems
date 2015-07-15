import java.awt.Point;

class Solution {
	
	private static final double E = 0.0000000001;
	
	public static void main(String... args) {
		Point p1 = new Point(0, 2);
		Point p2 = new Point(1, 3);
		
		Point q1 = new Point(1, 1);
		Point q2 = new Point(3, 3);
		
		System.out.println(isIntersectedLines(p1, p2, q1, q2));
	}
	
	private static boolean isIntersectedLines(Point p1, Point p2, Point q1, Point q2) {
		if (p2.y - p1.y != 0 && q2.y - q1.y != 0) {
			double slope1 = (p2.x - p1.x) / (p2.y - p1.y);
			double slope2 = (q2.x - q1.x) / (q2.y - q1.y);
			return Math.abs(slope2 - slope1) < E;
		} else if (p2.y - p1.y == 0 && q2.y - q1.y == 0) {
			return true;
		} else {
			return false;
		}
	}
		
}