import java.util.Random;
import java.util.Arrays;

public abstract class Game {
	
	private static final int DEFAULT_NUM = 52;
	
	private int num;
	private Card[] cards;
	
	private int top;
	
	public Game(Card.Suit ...suits) {
		num = DEFAULT_NUM;
		cards = new Card [num];
		int index = 0;
		for (Card.Suit suit : suits) {
			for (int i = 1; i <= 13; ++i) {
				Card card = new Card(suit, i);
				cards[index++] = card;
			}
		}
		newGame();
	}
	
	protected void shuffle() {
		Random random = new Random();
		for (int i = 0; i < cards.length; ++i) {
			int j = random.nextInt(cards.length - i);
			Card t = cards[j];
			cards[j] = cards[i];
			cards[i] = t;
		}
	}
	
	protected void newGame() {
		top = cards.length - 1;
		shuffle();
	}
	
	protected boolean hasMore() {
		return top >= 0;
	}
	
	protected Card takeCard() {
		if (top >= 0) {
			return cards[top--];
		} else {
			throw new RuntimeException("No more cards");
		}
	}
	
	protected Card [] takeCards(int n) {
		if (top - n >= -1) {
			return Arrays.copyOfRange(cards, top - n + 1, top + 1);
		} else if (top >= 0) {
			return Arrays.copyOfRange(cards, 0, top + 1);
		} else {
			throw new RuntimeException("No more cards");
		}
	}
	
}
