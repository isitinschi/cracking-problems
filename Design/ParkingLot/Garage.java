import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Garage {
	
	private static final int DEFAULT_NUMBER_OF_LEVELS = 3;
	private static final int DEFAULT_NUMBER_OF_SPOTS_ON_EACH_LEVEL = 10;
	
	private List<Level> levels;
	
	public Garage() {
		this(DEFAULT_NUMBER_OF_LEVELS, DEFAULT_NUMBER_OF_SPOTS_ON_EACH_LEVEL);
	}
	
	public Garage(int nLevels, int nSpotsOnEachLevel) {
		levels = new ArrayList<Level>();
		for  (int i = 0; i < nLevels; ++i) {
			Level level = new Level(i);
			for (int j = 0; j < nSpotsOnEachLevel; ++j) {
				ParkingSpotType type = null;
				if (j < nSpotsOnEachLevel / 3) {
					type = ParkingSpotType.MINI;
				} else if (j < nSpotsOnEachLevel / 3 * 2) {
					type = ParkingSpotType.STANDART;
				} else {
					type = ParkingSpotType.LARGE;
				}
				level.addSpot(new ParkingSpot(j, type, level));
			}
			levels.add(level);
		}
	}
	
	public ParkingSpot findParkingSpot(ParkingSpotType type) {
		ParkingSpot spot = null;
		
		for (Level level : levels) {
			for (ParkingSpot ps : level.getSpots()) {
				if (ps.getType() == type && !ps.isOccupied()) {
					spot = ps;
					break;
				}
			}
		}
		
		if (spot != null) {
			spot.setOccupied(true);
			System.out.println("Found " + spot.getType() + " spot for you. Address: level " + spot.getLevel().getId() + ", spot " + spot.getId());
		} else {
			System.out.println("All parking spots of type " + type + " are occupied.");
		}
		
		return spot;
	}
	
	public void leaveParkingSpot(ParkingSpot spot) {
		spot.setOccupied(false);
		System.out.println("" + spot.getType() + " spot with address: level " + spot.getLevel().getId() + ", spot " + spot.getId() + " is not occupied any more.");
	}
	
	public static void main(String [] args) {
		Garage garage = new Garage();
		List<ParkingSpot> spots = new ArrayList<>();
		Random random = new Random();
		
		for (int i = 0; i < 100; ++i) {
			ParkingSpotType type = null;
			int r = random.nextInt(3);
			switch(r) {
				case 0: type = ParkingSpotType.MINI;break;
				case 1: type = ParkingSpotType.STANDART;break;
				case 2: type = ParkingSpotType.LARGE;break;
			}
			ParkingSpot spot = garage.findParkingSpot(type);
			if (spot != null) {
				spots.add(spot);
			}
		}
		
		for (ParkingSpot spot : spots) {
			garage.leaveParkingSpot(spot);
		}
	}
	
}