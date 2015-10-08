public class Coin {
	
	private int value;
	
	public Coin(int value) {
		if (value <= 0) {
			throw new RuntimeException("Where have you seen such coins?!");
		}
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}