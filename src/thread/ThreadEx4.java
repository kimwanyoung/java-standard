package thread;

public class ThreadEx4 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("-"));
		}

		System.out.println();
		System.out.println(System.currentTimeMillis() - startTime);

		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("|"));
		}

		System.out.println();
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
