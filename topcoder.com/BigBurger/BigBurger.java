public class BigBurger {
	
	public int maxWait(int[] arrival, int[] service) {
		int curTime = 0;
		int max = 0; // first one
		
		int waitTime = 0;
		for (int i = 1; i < arrival.length; ++i) {
			curTime = arrival[i - 1] + service[i - 1] + waitTime;
			waitTime = 0;
			if (curTime <= arrival[i]) {
				waitTime = 0;
			} else {
				waitTime = curTime - arrival[i];
			}
			
			if (waitTime > max) {
				max = waitTime;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		BigBurger bigBurger = new BigBurger();
		int[] arrival = new int [] {3,3,9};
		int[] service = new int [] {2,15,14};
		System.out.println("Max wait is " + bigBurger.maxWait(arrival, service));
	}
	
}