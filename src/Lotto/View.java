package Lotto;

import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class View {
	Machine machine = new Machine();
	Money money = new Money();
	Scanner scan = new Scanner(System.in);
	Error error = new Error();
	Retry re = new Retry();

	public void display() {
		while (true) {
			System.out.println("현재 금액을 입력 하십시오(천원 단위 이상):");
			String usermoney = scan.next();// getusermoney 시작 금액 입력
			if (error.isInteger(usermoney)) {// 정수인지 판단
				money.getuserMoney(Integer.parseInt(usermoney));
				if (Integer.parseInt(usermoney) < 1000) {// 입력 금액이 1000원 이하면 다시
					System.out.println("금액이 너무 적습니다. 다시 입력 합니다.");
				} else {
					break;
				}
			}
		}

		while (true) {
			System.out.println("현재 당신 금액은 " + money.setuserMoney() + "원 입니다.");// setuserMoney로 현재 머니 출력
			System.out.println("몇장 구매 하시겠습니까?(한장 에 1000원):");
			String opportunity = scan.next();// opportunity는 로또 장수
			if (error.isInteger(opportunity)) {// 입력이 정수인지 판단
				if (money.setuserMoney() - (Integer.parseInt(opportunity) * 1000) < 0) {// 로또 구매후 마이너스면 다시 실행
					System.out.println("금액초과 입니다.");
					System.out.println("현재 당신 금액은 " + money.setuserMoney() + "원 입니다.");// setuserMoney로 현재 머니 출력
				} else {
					// System.out.println("당첨 번호:" + Arrays.toString(machine.lottoNumber()));//
					// lottoNumber로 번호생성및 출력
					machine.lottoNumber();
					for (int isTicket = 0; isTicket < Integer.parseInt(opportunity); isTicket++) {// 실행횟수(isTicket)만큼로또생성

						System.out.println(
								(isTicket + 1) + "번째" + "추천 번호:" + Arrays.toString(machine.makeMyNumber()) + "");// 나의로또번호생성및출력
						
						System.out.println("당첨 번호" + "	  " + Arrays.toString(machine.getlottoNumber()));
						System.out.println(
								"당첨 갯수는" + money.setwin(machine.getlottoNumber(), machine.getmyNumber()) + "개 입니다.");
						// getlottoNumber은 로또당첨번호 getmyNumber은 나의 로또번호 입력 후 setwin으로 당첨개수 파악
						System.out.println("당첨 금액은:" + money.setaward() + "원 입니다.\n");
					}
					// System.out.println(Arrays.toString(machine.getlottoNumber()));
					System.out.println("총 당첨 금액은:" + money.setreward() + "원 입니다.");// setreward는 총 상금액
					System.out.println("현재 당신 금액은 " + money.moneyResult(Integer.parseInt(opportunity)) + "원 입니다.");
					if (money.setuserMoney() <= 0) {
						System.out.println("당신은 파산 했습니다");
						break;
					}
				}
				re.retry();
			}
		}

	}
}