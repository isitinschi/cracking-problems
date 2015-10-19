import java.util.List;
import java.util.ArrayList;

public class Level {
	
	private int id;
	private List<ParkingSpot> spots;
	
	public Level(int id) {
		this.id = id;
		spots = new ArrayList<ParkingSpot>();
	}
	
	public int getId() {
		return id;
	}
	
	public List<ParkingSpot> getSpots() {
		return spots;
	}
	
	public void addSpot(ParkingSpot spot) {
		spots.add(spot);
	}
	
}