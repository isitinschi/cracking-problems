public class Song {
	
	private int id;
	private String name;
	private String duration;
	private int price;
	
	public Song(int id, String name, String duration, int price) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public int getPrice() {
		return price;
	}
	
}