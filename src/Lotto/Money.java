package Lotto;

public class Money {
	private int reward;// 총 상금액
	private int userMoney;// 현재 유저 금액
	private int win;// 당첨 개수
	private int bounsWin;// 당첨 개수

	public int getreward() {
		return reward;
	}
	
	public void setreward(int reward) {
		this.reward = reward;
	}

	public int getuserMoney() {
		return userMoney;
	}

	public void setuserMoney(int userMoney) {
		this.userMoney = userMoney;
	}

	public void setwin(int win) {
		this.win = win;
	}

	public int getwin() {
		return win;
	}

	public int makWin1(int[] lottoNumber, int[] ticket) {// 당첨 횟수 계산
		win = 0;
		for (int number = 0; number < lottoNumber.length; number++) {
			for (int number1 = 0; number1 < ticket.length; number1++) {
				if (lottoNumber[number1] == ticket[number])// 추천번호와 당첨번호 비교
					win++;// 당첨 증가
			}
		}
		return win;

	}

	public int getbounsWin() {
		return bounsWin;
	}

	public int makWin2(int bonusNum, int myBounsNum) {// 보너스 번호 비교
		bounsWin = 0;
		if (bonusNum == myBounsNum) {
			bounsWin++;// 당첨 증가
		}
		return bounsWin;
	}

	public void print()// 당첨 출력
	{
		if (win == 3) {
			System.out.println("축하합니다. 5등입니다.");
		} else if (win == 4) {
			System.out.println("축하합니다. 4등입니다.");
		} else if (win == 5) {
			System.out.println("축하합니다. 3등입니다.");
		} else if (win == 5 && bounsWin == 1) {
			System.out.println("!축하합니다. 2등입니다.!");
		} else if (win == 6) {
			System.out.println("!!축하합니다. 1등입니다.!!");
		}
	}

	public int setaward() {// 당첨 횟수(win)에 따라 상금액 설정
		int winnings = 0;// winnings= 당첨금
		if (win == 3) {
			winnings = 5000;
		} else if (win == 4) {
			winnings = 50000;
		} else if (win == 5) {
			winnings = 1500000;
		} else if (win == 5 && bounsWin == 1) {
			winnings = 30000000;
		} else if (win == 6) {
			winnings = 2000000000;
		}
		win = 0;// 당첨 개수 중첩 방지
		bounsWin = 0;// 보너스 당첨 중첩 방지
		reward = reward + winnings;
		return winnings;
	}

	public int moneyResult(int opportunity) {// 현재금액 계산(당첨금,실행횟수*1000 차감
		userMoney += reward;// 총 상금액
		userMoney -= (opportunity * 1000);// 실행 횟수
		reward = 0;
		return userMoney;// 최종 금액
	}
}