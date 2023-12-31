package thread;

import javax.swing.*;

/**
 * 두 개의 쓰레드로 작업을 나누어서 처리했기 때문에 입력을 마치지 않았어도 숫자 작업을 처리한다.
 */

public class ThreadEx7 {
	public static void main(String[] args) throws Exception {
		ThreadEx7_1 th1 = new ThreadEx7_1();
		th1.start();

		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
		System.out.println("입력하신 값은 " + input + "입니다.");
	}
}

class ThreadEx7_1 extends Thread {

	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);

			try {
				sleep(1000);
			} catch (Exception e) {

			}
		}
	}
}
