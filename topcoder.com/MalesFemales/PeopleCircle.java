public class PeopleCircle {
	
	public String order(int m, int f, int k) {
		int num = f + m;
		StringBuilder builder = new StringBuilder(num);
		for (int i = 0; i < num; ++i) {
			setMale(builder, i);
		}
		
		int restored = 0;
		int pos = 0;
		while (restored != f) {
			pos = (pos + k) % num;			
			if (pos == 0) {
				setFemale(builder, num - 1); // last
			} else {
				setFemale(builder, pos - 1);
			}
			++restored;
		}
		
		return builder.toString();
	}
	
	private void setMale(StringBuilder builder, int i) {
		builder.replace(i, i + 1, "M");
	}
	
	private void setFemale(StringBuilder builder, int i) {
		builder.replace(i, i + 1, "F");
	}
	
	public static void main(String [] args) {
		PeopleCircle circle = new PeopleCircle();
		int m = 5;
		int f = 3;
		int k = 2;
		System.out.println("Restored sequence: " + circle.order(m, f, k));
	}
	
}