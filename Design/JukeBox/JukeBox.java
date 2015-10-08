import java.util.Map;
import java.util.HashMap;

public class JukeBox {
	
	private PlayList playList = null;
	private Player player = null;
	private int paid = 0;
	private Map<Integer, Song> map;
	
	public JukeBox() {
		playList = new PlayList();
		player = new Player();
		map = new HashMap<Integer, Song>();		
		map.put(1, new Song(1, "The beatles - Yesterday", "03:25", 5));
		map.put(2, new Song(2, "Deep purple - Smoke on the water", "04:12", 5));
		map.put(3, new Song(3, "Rammstein - Do hast", "01:45", 5));
		map.put(4, new Song(4, "DJ Amazoner - I'm sexy and I know it", "05:56", 15));
		map.put(5, new Song(5, "The queen - We will rock you", "03:03", 10));
	}
	
	public void insertCoin(Coin coin) {
		if (coin != null) {
			paid += coin.getValue();
			printSongs();
		} else {
			System.err.println("Wrong coin");
		}
	}
	
	public void addToPlayList(int id) {
		Song song = map.get(id);
		if (song == null) {
			System.err.println("Song not found");
		} else if (song.getPrice() <= paid) {
			playList.add(song);
			paid -= song.getPrice();
		} else {
			System.err.println("Not enough money to play this song");
		}	
	}
	
	public void start() {
		if (!playList.isEmpty()) {
			play();			
		} else {
			System.err.println("No songs to play");
		}
	}
	
	private void play() {
		player.play(playList);
	}
	
	public void printSongs() {
		System.out.println("Your money: " + paid);
		for (Song song : map.values()) {
			System.out.print("Id: " + song.getId());
			System.out.print(", name: " + song.getName());
			System.out.println(", duration: " + song.getDuration());
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		JukeBox jukeBox = new JukeBox();
		jukeBox.insertCoin(new Coin(5));
		jukeBox.addToPlayList(1);
		jukeBox.addToPlayList(3);
		
		jukeBox.start();
	}
		
}