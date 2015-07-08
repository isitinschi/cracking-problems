import java.util.List;
import java.util.ArrayList;

public class Inventory {
	
	private static final int DAYS_PER_MONTH = 30;
	private static final double E = 0.000000001;
	
	public int monthlyOrder(int[] sales, int[] daysAvailable) {
		double expectedSales = 0;
		int num = 0;
		for (int i = 0; i < sales.length; ++i) {
			if (daysAvailable[i] != 0) {
				expectedSales += sales[i] * DAYS_PER_MONTH / (double) daysAvailable[i];
				++num;
			}
		}
		expectedSales -= E;
		int avg = (int) expectedSales / num;
		if (expectedSales / num > avg) {
			++avg;
		}
		return avg;
	}
	
	public static void main(String [] args) {
		Inventory inventory = new Inventory();
		int[] sales = new int [] {1115,7264,3206,6868,7301};
		int[] daysAvailable = new int [] {1,3,9,4,18};
		System.out.println("Expected number of sales: " + inventory.monthlyOrder(sales, daysAvailable));
	}
	
}