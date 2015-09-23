public class Log {
	
	private static final int MAX = 123124;
	
	private int start;
	private int end;
	private int usage;
		
	public Log(int start, int end, int usage) {
		this.start = start;
		this.end = end;
		this.usage = usage;
	}
	
	public static int findPeak(Log... logs) {
		int [] usageArray = new int[MAX + 2];
		for (int i = 0; i < logs.length; ++i) {
			usageArray[logs[i].start] += logs[i].usage;
			usageArray[logs[i].end + 1] -= logs[i].usage;
		}
		
		int maxSoFar = usageArray[0];
		int time = 0;
		for (int i = 1; i <= MAX; ++i) {
			usageArray[i] += usageArray[i - 1];
			if (usageArray[i] > maxSoFar) {
				maxSoFar = usageArray[i];
				time = i;
			}
		}
		
		return time;
	}
	
	public static void main(String[] args) {		
		Log log1 = new Log(100207, 100208, 2);
		Log log2 = new Log(100305, 100307, 5);
		Log log3 = new Log(100207, 100209, 4);
		Log log4 = new Log(111515, 121212, 1);
		
		System.out.println("Peak time is " + Log.findPeak(log1, log2, log3, log4));
	}
	
}