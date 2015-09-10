import java.util.List;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;

public class Solution {
	
	private static class Box {
		int width;
		int height;
		int depth;
		
		Box(int width, int height, int depth) {
			this.width = width;
			this.height = height;
			this.depth = depth;
		}
		
		boolean isGreater(Box box) {
			return width > box.width && height > box.height && depth > box.depth;
		}
		
		@Override
		public String toString() {
			return "Box [width " + width + ", height " + height + ", depth" + depth + "]";
		}
	}
	
	public static void main(String ... args) {
		Box box5 = new Box(5,5,5);
		Box box4 = new Box(4,4,4);
		Box box3 = new Box(3,3,3);
		Box box2 = new Box(2,2,2);
		Box box1 = new Box(1,1,1);
		List<Box> boxes = new ArrayList<Box>();
		boxes.add(box1);
		boxes.add(box2);
		boxes.add(box3);
		boxes.add(box4);
		boxes.add(box5);
		findTallest(boxes);
	}
	
	private static void findTallest(List<Box> boxes) {
		if (boxes == null || boxes.isEmpty()) {
			System.out.println("0");
		} else {
			int max = findTallest(boxes, new LinkedList<Box>());
			System.out.println(max);
		}
	}
	
	private static int findTallest(List<Box> boxes, Deque<Box> stack) {
		boolean added = false;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < boxes.size(); ++i) {
			Box box = boxes.get(i);
			if (stack.isEmpty() || stack.getLast().isGreater(box)) {
				Deque<Box> newStack = new LinkedList<Box>(stack);
				newStack.addLast(boxes.get(i));
				int height = findTallest(boxes, newStack);
				if (height > max) {
					max = height;
				}
				added = true;
			}
		}
		if (!added) {
			return stack.size();
		} else {
			return max;
		}
	}
		
}