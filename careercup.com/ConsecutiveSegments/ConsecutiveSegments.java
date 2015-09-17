public class ConsecutiveSegments {
	
	public void print(int [] array) {
		if (array == null || array.length == 0) {
			System.out.println("Nothing to print!");
		} else if (array.length == 1) {
			System.out.println(array[0]);
		} else {	
			boolean	consecutive = false;
			for (int i = 1; i < array.length; ++i) {
				if (array[i] != array[i - 1] + 1) {
					if (consecutive) {
						System.out.print("-");
					}
					System.out.print(array[i - 1] + ", ");
					consecutive = false;
				} else if (!consecutive) {
					consecutive = true;
					System.out.print(array[i - 1]);
				}
			}
			if (consecutive) {
				System.out.print("-");
			}
			System.out.print(array[array.length - 1]);
		}
	}
	
	public static void main(String[] args) {
		(new ConsecutiveSegments()).print(new int [] {1,3,6,8,9,12,13,14,18,19,20,23,26,29,30});
	}
}