public class FoxAndMp3Easy {
	
	private static final int SONGS_LIMIT = 50;
	
	public String[] playList(int n) {		
		String[] songs = new String[SONGS_LIMIT];
		
		int x = 1;
		for (int i = 0; i < songs.length; ++i) {
			songs[i] = "" + x + ".mp3";
			if (x * 10 <= n) {
				x *= 10;
			} else {
				while (x % 10 == 9 || x == n) {
					x /= 10;
				}
				++x;
			}			
		}
		
		return songs;
	}
	
	public static void main(String[] args) {
		FoxAndMp3Easy mp3 = new FoxAndMp3Easy();
		String [] songs = mp3.playList(200);
		if (songs.length != SONGS_LIMIT) {
			throw new RuntimeException();
		}
		for (int i = 0; i < songs.length; ++i) {
			System.out.println(songs[i]);
		}
	}
}