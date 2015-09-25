public class Solution {
	
	private boolean [] versions;
	
	public Solution(boolean [] versions) {
		this.versions = versions;
	}

    public int firstBadVersion(int n) {
        int l = 1;
        int g = n;
        while (l <= g) {
            int m = l + (g - l) / 2;
            boolean cur = isBadVersion(m);
            if (cur && (m == 1 || !isBadVersion(m - 1))) {
                return m;
            }
            if (cur) {
                g = m - 1;
            } else {
                l = m + 1;
            }
        }        

        return -1; // all good
    }
	
	private boolean isBadVersion(int m) {
		return !versions[m - 1];
	}
	
	public static void main(String []args) {
		Solution solution = new Solution(new boolean [] {true, true, false, false, false});
		System.out.println(solution.firstBadVersion(5));
	}

}