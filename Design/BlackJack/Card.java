public class Card {
	
	private Suit suit;
	private int value;
	
	public Card(Suit suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public static enum Suit {
		SPADE, HEART, DIAMOND, CLUB;
	}
	
}