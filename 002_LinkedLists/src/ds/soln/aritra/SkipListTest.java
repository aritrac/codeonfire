package ds.soln.aritra;

public class SkipListTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		SkipList s = new SkipList();
		s.add(1, 100);
		System.out.println(s.get(1));
	}
}
