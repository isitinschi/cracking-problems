import java.util.List;
import java.util.ArrayList;

public class LeaguePicks {
	
	private boolean increment = true;
	
	public int [] returnPicks(int position, int friends, int picks) {
		List<Integer> picksList = new ArrayList<Integer>();
		int counter = 1;
		int curPos = 1;
		while (counter <= picks) {
			if (curPos == position) {
				picksList.add(counter);
			}
			curPos = smartIncrementDecrement(curPos, friends);
			++counter;
		}
		return picksList.stream().mapToInt(i->i).toArray();
	}
	
	private int smartIncrementDecrement(int pos, int friends) {
		if (increment) {
			if (pos == friends) {
				increment = false;
				return pos;
			} else {
				return pos + 1;
			}
		} else {
			if (pos == 1) {
				increment = true;
				return pos;
			} else {
				return pos - 1;
			}
		}
	}
	
	public static void main(String [] args) {
		LeaguePicks leaguePicks = new LeaguePicks();
		int position = 3;
		int friends  = 6;
		int picks = 20;
		System.out.println("Position " + position + ", friends " + friends + ", picks " + picks + ". Picks for position: ");
		int [] picksForPosition = leaguePicks.returnPicks(position, friends, picks);
		for (int i = 0; i < picksForPosition.length; ++i) {
			System.out.print(picksForPosition[i] + " ");
		}
	}
	
}