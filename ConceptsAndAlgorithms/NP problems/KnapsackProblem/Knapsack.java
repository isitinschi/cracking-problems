import java.util.Random;

public class Knapsack {
	
	private double limit = 0;
	
	public Knapsack(double limit) {
		this.limit = limit;
	}
	
	public double pack(double[] values, double[] weights) {
		if (values.length != weights.length) {
			return -1; // wrong input
		}
		
		int n = values.length;
		double maxValue = 0;
		for (int mask = 1; mask < (1 << n); ++mask) {
			double valueSum = 0;
			double weightSum = 0;
			for (int j = 0; j < n; ++j) {
				if ((mask & (1 << j)) != 0) {
					valueSum += values[j];
					weightSum += weights[j];
				}
			}
			if (weightSum <= limit) {
				maxValue = Math.max(valueSum, maxValue);
			}
		}
		
		return maxValue;
	}
	
	public static void main(String [] args) {
		Random random = new Random();
		int n = random.nextInt(10);
		double [] values = new double[n];
		double [] weights = new double[n];
		System.out.println("Items count: " + n);
		for (int i = 0; i < n; ++i) {
			values[i] = random.nextDouble() * 10;
			weights[i] = random.nextDouble() * 10;
			System.out.print(values[i] + "(" + weights[i] + ") ");
		}
		System.out.println();
		
		double limit = random.nextDouble() * 15;
		Knapsack knapsack = new Knapsack(limit);
		System.out.println("Max value for knapsack with limit " + limit + " is " + knapsack.pack(values, weights));
	}
	
}