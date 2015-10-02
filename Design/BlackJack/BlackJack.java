import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack extends Game {
	
	private static final int MAX_POINTS = 21;
	
	private int min;
	private int best;
	
	private List<Card> cards;
	
	public BlackJack() {
		super(Card.Suit.SPADE, Card.Suit.HEART, Card.Suit.DIAMOND, Card.Suit.CLUB);
		min = 0;
		best = 0;		
	}
	
	@Override
	public void newGame() {
		super.newGame();
		min = 0;
		best = 0;
		if (cards == null) {
			cards = new ArrayList<Card>();
		} else {
			cards.clear();
		}
	}
	
	@Override	
	public Card takeCard() {
		Card card = super.takeCard();
		cards.add(card);
		System.out.println("You take card: " + card.getValue() + " " + card.getSuit());
		
		min = calcMin(cards);
		if (min > MAX_POINTS) {
			lose();
		} else {
			best = calcBest(cards);
			System.out.println("Your best points: " + best);
			if (best == MAX_POINTS) {
				win();
			}
		}
		
		return null;
	}
	
	private int calcMin(List<Card> cards) {
		min = 0;
		for (Card c : cards) {
			min += c.getValue();
		}
		return min;
	}
	
	private int calcBest(List<Card> cards) {
		return calcBest(0, 0, 0, cards);		
	}
	
	private int calcBest(int i, int sum, int best, List<Card> cards) {
		if (i == cards.size()) {
			if (sum <= MAX_POINTS && sum > best) {
				return sum;
			} else {
				return 0;
			}
		}
		
		best = Math.max(best, calcBest(i + 1, sum + cards.get(i).getValue(), best, cards));
		
		if (cards.get(i).getValue() == 1) {// ace
			best = Math.max(best, calcBest(i + 1, sum + 11, best, cards));
		}
		
		return best;
	}
	
	private void win() {
		System.out.println("You win");
		System.exit(0);
	}
	
	private void lose() {
		System.out.println("You lose");
		System.exit(0);
	}
		
	public void skip() {
		int aiMin = 0;
		int aiBest = 0;
		List<Card> aiCards = new ArrayList<>();
		while (hasMore()) {
			Card card = super.takeCard();
			aiCards.add(card);
			System.out.println("AI takes card: " + card.getValue() + " " + card.getSuit());
						
			aiMin = calcMin(aiCards);
			aiBest = calcBest(aiCards);
			System.out.println("AI best points: " + aiBest);
			
			if (aiMin > MAX_POINTS) {
				win();
			}
			if (aiBest > best) {
				lose();
			}
		}
		
		if (best > aiBest) {
			win();
		} else {
			lose();
		}
	}
	
	public static void main(String [] args) {
		Game game = new BlackJack();
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1 - Take card\n2 - Skip");
			int c = scanner.nextInt();
			if (c == 1) {
				game.takeCard();
			} else if (c == 2) {
				((BlackJack) game).skip();
			}
		}
	}
	
}