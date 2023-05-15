package Lotto;

import java.util.Scanner;

public class Retry {

	public void retry() {
		Scanner scan = new Scanner(System.in);
		System.out.println("계속 진행을 하시겠습니까?(종료를 원할시 n을 입력하십시오):");
		String no = scan.next();
		if (no.equals("n")) {
			System.out.println("종료");
			System.exit(0);	
		}
	}
}