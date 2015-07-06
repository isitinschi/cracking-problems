public class Archimedes {
	
	public double approximatePi(int numSides) {
		double radius = 1;
		double angle = (180.0 - 360.0 / numSides) / 2.0;
		double sideLength = 2 * radius * Math.cos(Math.toRadians(angle));
		return numSides * sideLength / 2 * radius;
	}
	
	public static void main(String[] args) {
		Archimedes archimedes = new Archimedes();
		int n = 8;
		System.out.println("Pi calculated by inscribed polygone with " + n + " sides approximately equals " + archimedes.approximatePi(n));
	}
	
}