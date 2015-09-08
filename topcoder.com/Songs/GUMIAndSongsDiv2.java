public class GUMIAndSongsDiv2 {
	
	public int maxSongs(final int[] duration, final int[] tone, int T) {
		if (duration.length != tone.length) {
			return -1; //error
		}
		
		int best = 0;
		for(int mask = 1; mask < (1<<duration.length); ++mask) {
			int minTone = Integer.MAX_VALUE;
			int maxTone = Integer.MIN_VALUE;
			int time = 0;
			int count = 0;
			for (int i = 0; i < duration.length; ++i) {				
				if ((mask & (1 << i)) != 0) {
					minTone = Math.min(minTone, tone[i]);
					maxTone = Math.max(maxTone, tone[i]);
					time += duration[i];
					++count;
				}
			}
			if (time + maxTone - minTone <= T) {
				best = Math.max(best, count);
			}
		}
		
		return best;
	}
	
	public static void main(String[] args) {
		GUMIAndSongsDiv2 gumi = new GUMIAndSongsDiv2();
		int result = gumi.maxSongs(new int [] {3, 5, 4, 11}, new int[] {2, 1, 3, 1}, 17);
		if (result != 3) {
			throw new RuntimeException("Wrong result! Expected 3, but was" +result);
		}
		result = gumi.maxSongs(new int [] {100, 200, 300}, new int[] {1, 2, 3}, 10);
		if (result != 0) {
			throw new RuntimeException("Wrong result! Expected 0, but was" +result);
		}
		result = gumi.maxSongs(new int [] {10, 10, 10}, new int[] {58, 58, 58}, 30);
		if (result != 3) {
			throw new RuntimeException("Wrong result! Expected 3, but was" +result);
		}
		result = gumi.maxSongs(new int [] {8, 11, 7, 15, 9, 16, 7, 9}, new int[] {3, 8, 5, 4, 2, 7, 4, 1}, 14);
		if (result != 1) {
			throw new RuntimeException("Wrong result! Expected 1, but was" +result);
		}
		result = gumi.maxSongs(new int [] {5611,39996,20200,56574,81643,90131,33486,99568,48112,97168,5600,49145,73590,3979,94614}, 
			new int[] {2916,53353,64924,86481,44803,61254,99393,5993,40781,2174,67458,74263,69710,40044,80853}, 
			302606);
		if (result != 8) {
			throw new RuntimeException("Wrong result! Expected 8, but was" +result);
		}
	}
	
}