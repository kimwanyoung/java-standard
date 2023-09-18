package thread;

import javax.swing.*;

/**
 * 하나의 쓰레드로 사용자의 입력을 받는 작업 -> 입력을 받은 후에 숫자 출력 작업을 처리함
 */

public class ThreadEx6 {

	public static void main(String[] args) throws Exception {
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");

		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
		}
	}
}
