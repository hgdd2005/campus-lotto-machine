package Lotto;

public class Money {
	private int reward;// 총 상금액
	private int userMoney;// 현재 유저 금액
	private int win;// 당첨 개수

	public int setreward() {
		return reward;
	}

	public void getreward(int reward) {
		this.reward = reward;
	}

	public int setuserMoney() {
		return userMoney;
	}

	public void getuserMoney(int userMoney) {
		this.userMoney = userMoney;
	}

	public void getwin(int win) {
		this.win = win;
	}

	public int setwin(int[] lottoNumber, int[] ticket) {// 당첨 횟수 계산
		win = 0;
		for (int number = 0; number < lottoNumber.length; number++) {
			for (int number1 = 0; number1 < ticket.length; number1++) {
				if (lottoNumber[number1] ==ticket [number])// 같은지 비교
					win++;// 당첨 증가
			}
		}
		return win;
	}

	public int setaward() {// 당첨 횟수(win)에 따라 상금액 설정
		int winnings = 0;// winnings= 당첨금
		if (win == 3) {
			winnings = 5000;
		} else if (win == 4) {
			winnings = 50000;
		} else if (win == 5) {
			winnings = 1500000;
		} else if (win == 6) {
			winnings = 30000000;
		} else if (win == 7) {
			winnings = 2000000000;
		}
		win = 0;
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