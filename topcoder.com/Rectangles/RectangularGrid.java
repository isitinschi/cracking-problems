public class RectangularGrid {
	
	public long countRectangles(int width, int height) {
		long sum = 0;
		
		int n = height - 1;
		for (int w = 1; w <= width && n >= 1; ++w, --n) {
				sum += n * (1 + n) / 2 * (width - w + 1);
		}
		
		n = width - 1;
		for (int h = 1; h <= height && n >= 1; ++h, --n) {
				sum += n * (1 + n) / 2 * (height - h + 1);
		}
		
		return sum;
	}
	
	public static void main(String [] args) {
		int width = 592;
		int height = 964;
		RectangularGrid rect = new RectangularGrid();
		System.out.println("Counted " + rect.countRectangles(width, height) + " for rectangle " + width + "x" + height);
	}
	
}