package Lotto;

import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class AutoView {
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
				money.setuserMoney(Integer.parseInt(usermoney));
				if (Integer.parseInt(usermoney) < 1000) {// 입력 금액이 1000원 이하면 다시
					System.out.println("금액이 너무 적습니다. 다시 입력 합니다.");
				} else {
					break;
				}
			}
		}

		while (true) {
			System.out.println("현재 당신 금액은 " + money.getuserMoney() + "원 입니다.");// getuserMoney로 현재 머니 출력
			System.out.println("몇장 구매 하시겠습니까?(한장 에 1000원):");
			String opportunity = scan.next();// opportunity는 로또 장수
			if (error.isInteger(opportunity)) {// 입력이 정수인지 판단
				if (money.getuserMoney() - (Integer.parseInt(opportunity) * 1000) < 0) {// 로또 구매후 마이너스면 다시 실행
					System.out.println("금액초과 입니다.");
					System.out.println("현재 당신 금액은 " + money.getuserMoney() + "원 입니다.");// getuserMoney로 현재 머니 출력
				} else {

					machine.lottoNumber();// 당첨 번호생성및 출력
					machine.bonusNum();// 보너스당첨 번호 생성
					for (int isTicket = 0; isTicket < Integer.parseInt(opportunity); isTicket++) {// 실행횟수(isTicket)만큼로또생성

						System.out.println((isTicket + 1) + "번째" + "추천 번호:" + Arrays.toString(machine.makeMyNumber())
								+ "보너스 번호:" + machine.myBonusNum());// 나의로또번호생성및출력
						money.makWin1(machine.getlottoNumber(), machine.getmyNumber());// 추첨 번호 비교
						money.makWin2(machine.getbonusNum(), machine.getmyBonusNum());// 보너스 번호 비교
						System.out.println("당첨 번호" + "	   " + Arrays.toString(machine.getlottoNumber()) + "보너스 번호:"
								+ machine.getbonusNum());
						System.out.println("당첨 갯수는" + money.getwin() + "개 입니다.");
						if (money.getwin() > 2) {
							money.print();
						}
						// getlottoNumber은 로또당첨번호 getmyNumber은 나의 로또번호를 setwin으로 당첨개수 파악
						System.out.println("당첨 금액은:" + money.setaward() + "원 입니다.\n");
					}
					System.out.println("총 당첨 금액은:" + money.getreward());// getreward는 총 상금액
					System.out.println("현재 당신 금액은 " + money.moneyResult(Integer.parseInt(opportunity)) + "원 입니다.");
					if (money.getuserMoney() <= 0) {
						System.out.println("당신은 파산 했습니다");
						break;
					}
				}
				re.retry();
			}
		}

	}
}