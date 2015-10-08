import java.lang.Runnable;

public class Player implements Runnable {
	
	private PlayList playList = null;
	
	@Override
	public void run() {
		if (playList == null || playList.isEmpty()) {
			System.out.println("Nothing to play. Play list is empty.");
			return;
		}
		
		for (Song song : playList) {
			System.out.println("Starting to play song " + song.getName() + "...");
			System.out.println("Playing...");
			
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Song " + song.getName() + " finished.");
		}
	}
	
	public void play(PlayList playList) {
		this.playList = playList;
		(new Thread(this)).start();
	}
}