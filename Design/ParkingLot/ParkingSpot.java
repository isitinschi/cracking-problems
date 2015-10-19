public class ParkingSpot {
	
	private final int id;
	private final ParkingSpotType type;
	private final Level level;
	private boolean occupied;
	
	public ParkingSpot(int id, ParkingSpotType type, Level level) {
		this.id = id;
		this.type = type;
		this.level = level;
		occupied = false;
	}
	
	public int getId() {
		return id;
	}
	
	public ParkingSpotType getType() {
		return type;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public boolean isOccupied() {
		return occupied;
	}
	
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
}