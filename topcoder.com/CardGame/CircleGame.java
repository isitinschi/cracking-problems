public class CircleGame {
	
	private static final int TARGET_SUM = 13;
	
	public int cardsLeft(String cards) {
		StringBuilder builder = new StringBuilder(cards);
		boolean removed = true;
		while (removed) {
			removed = false;
			for (int i = 0; i < builder.length(); ++i) {
				if (getCardValue(builder, i) == TARGET_SUM) {
					removeCard(builder, i);
					removed = true;
					break;
				}
				if (getCardValue(builder, i - 1) + getCardValue(builder, i) == TARGET_SUM) {
					removeCard(builder, i - 1);
					removeCard(builder, i);
					removed = true;
					break;
				}
				if (getCardValue(builder, i + 1) + getCardValue(builder, i) == TARGET_SUM) {
					removeCard(builder, i + 1);
					removeCard(builder, i);
					removed = true;
					break;
				}
			}
		}
		return builder.length();
	}
	
	private int getCardValue(StringBuilder cards, int i) {
		return getValue(cards.charAt(getIndex(cards, i)));
	}
	
	private int getValue(char c) {
		switch (c) {
			case 'A':
				return 1;
			case '2':
				return 2;
			case '3':
				return 3;
			case '4':
				return 4;
			case '5':
				return 5;
			case '6':
				return 6;
			case '7':
				return 7;
			case '8':
				return 8;
			case '9':
				return 9;
			case 'T':
				return 10;
			case 'J':
				return 11;
			case 'Q':
				return 12;
			case 'K':
				return 13;
		}
		
		throw new IllegalArgumentException();
	}
	
	private void removeCard(StringBuilder cards, int i) {
		int index = getIndex(cards, i);
		cards.delete(index, index + 1);
	}
	
	private int getIndex(StringBuilder cards, int i) {
		int num = cards.length();
		int index = i;
		if (i == -1) {
			index = num - 1;
		} else if (i == num) {
			index = 0;
		}
		return index;
	}
	
	public static void main(String[] args) {
		CircleGame game = new CircleGame();
		String cards = "KKK";
		System.out.println("Cards: " + cards + ". After game remained " + game.cardsLeft(cards) + " cards");
	}
	
}