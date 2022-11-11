package BaseballGame;

import java.util.Scanner;

public class javaBaseballGame {
	public static void main(String[] args) {
		int[] a = new int[3];
		int[] d = new int[3];
		int scount = 0;
		int bcount = 0;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < a.length; i++) { // 랜덤숫자를 a배열 i번째에 주입
			a[i] = (int) (Math.random() * 10);
		}
		boolean eq = false;

		do {
			eq = false;
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < i; j++) {
					if (a[i] == a[j]) { // 중복 검사
						eq = true;
						a[i] = (int) (Math.random() * 10);

					}
				}
			}
		} while (eq);

		for (int i = 0; i < a.length; i++) { // 정답
			System.out.print(a[i] + " ");
		}
		System.out.println();

		for (;;) {
			bcount = 0;
			scount = 0;

			for (int i = 0; i < a.length; i++) {
				d[i] = sc.nextInt();
			}
			for (int i = 0; i < a.length; i++) { // strike check
				if (a[i] == d[i]) {
					scount++;
				}
			}
			for (int i = 0; i < a.length; i++) { // ball check
				for (int j = 0; j < a.length; j++) {
					if (a[i] == d[j] && i != j) {
						bcount++;
					}

				}
			}

			if (a[0] == d[0] && a[1] == d[1] && a[2] == d[2]) {
				System.out.print("축하합니다. 게임 종료");
				sc.close();
				break;
			} else if (bcount == 3) {
				System.out.println("out");
			} else if (scount == 3) {
				break;
			} else {
				System.out.printf("%d Strike %d Ball\n", scount, bcount);
			}
		}

	}

}
