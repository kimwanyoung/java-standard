package thread;

public class ThreadEx1 {
	public static void main(String[] args) {
		/**
		 * Thread를 구현하는 두 가지 방법
		 * 1. Thread 클래스 상속
		 * 2. Runnable 인터페이스 구현
		 * 일반적으로 Runnable 인터페이스를 구현함, 재사용성이 높고 코드의 일관성을 유지할 수 있기 때문에
		 */

		ThreadEx1_1 t1 = new ThreadEx1_1();

		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);
		// 한 줄로 Thread t2 = new Thread(new ThreadEx1_2());
		
		t1.start();
		t2.start();
	}
}

class ThreadEx1_1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(getName());
		}
	}
}

class ThreadEx1_2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
