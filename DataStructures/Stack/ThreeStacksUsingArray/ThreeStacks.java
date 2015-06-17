import java.lang.reflect.Array;

public class ThreeStacks<T> {

	private static final int DEFAULT_CAPACITY = 10;

	private T[] array;
	private int[] stacksStart;
	private int[] stacksTop;

	public ThreeStacks() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ThreeStacks(int capacity) {
		array = (T[]) new Object[capacity];
		stacksStart = new int[3];
		stacksTop = new int[3];
		int step = capacity / 3;
		stacksStart[1] = step;
		stacksTop[1] = step;
		stacksStart[2] = 2 * step;
		stacksTop[2] = 2 * step;
	}

	public void push(int stack, T value) {
		if (stack < 0 || stack > 2) {
			throw new IllegalArgumentException();
		}
		int threshold;
		if (stack < 2) {
			threshold = stacksStart[stack + 1];
		} else {
			threshold = array.length;
		}
		if (stacksTop[stack] < threshold) {
			array[stacksTop[stack]] = value;
			++stacksTop[stack];
		} else {
			throw new RuntimeException("Stack " + stack + " is full");
		}
	}

	public T pop(int stack) {
		if (stack < 0 || stack > 2) {
			throw new IllegalArgumentException();
		}
		int threshold;
		if (stack > 0) {
			threshold = stacksStart[stack - 1];
		} else {
			threshold = 0;
		}
		if (stacksTop[stack] - 1 >= threshold) {
			--stacksTop[stack];
			return array[stacksTop[stack]];
		} else {
			throw new RuntimeException("Stack " + stack + " is empty");
		}
	}

	public static void main(String... args) {
		ThreeStacks<Integer> stacks = new ThreeStacks<Integer>(20);

		for (int stack = 0; stack < 3; ++stack) {
			for (int value = 0; value < 5; ++value) {
				stacks.push(stack, value);
			}
		}

		for (int stack = 0; stack < 3; ++stack) {
			for (int value = 4; value >= 0; --value) {
				int stackValue = stacks.pop(stack);
				if (stackValue != value) {
					throw new RuntimeException(
							"pop method of ThreeStacks returned wrong value");
				}
			}
		}
		
		System.out.println("Finished");
	}
}