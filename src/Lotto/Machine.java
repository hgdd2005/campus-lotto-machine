package Lotto;

import java.util.Random;
import java.util.Arrays;//오름차순 정렬

public class Machine {
	private int[] lottoNumber = new int[6];// 당첨 반호
	private int[] myNumber = new int[6];// 자동 번호
	private int bonusNum;// 보너스 당첨 번호
	private int myBonusNum;// 자동 보너스 번호
	private Random random = new Random();// 랜덤 변수

	public int[] getlottoNumber() //
	{
		return lottoNumber;
	}

	public void setlottoNumber(int[] lottoNumber) {
		this.lottoNumber = lottoNumber; // 당첨 번호

	}

	public int[] lottoNumber() {
		for (int i = 0; i < lottoNumber.length; i++) {
			lottoNumber[i] = random.nextInt(45) + 1;// 당첨 번호 랜덤 생성

			for (int j = 0; j < i; j++) {// 중복 제거
				if (lottoNumber[i] == lottoNumber[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(lottoNumber);// 오름차순으로 정렬
		return lottoNumber;
	}

	public void setmyNumber(int[] myNumber) {
		this.myNumber = myNumber;
	}

	public int[] getmyNumber() //
	{
		return myNumber;
	}

	public int[] makeMyNumber() { // 추천번호
		for (int i = 0; i < myNumber.length; i++) {
			myNumber[i] = random.nextInt(45) + 1; // 추천 번호 생성

			for (int j = 0; j < i; j++) {// 중복 제거
				if (myNumber[i] == myNumber[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(myNumber);// 오름 차순으로 정렬
		return myNumber;
	}

	public int getbonusNum() //
	{
		return bonusNum;
	}

	public void setbonusNum(int bonusNum) {
		this.bonusNum = bonusNum;
	}

	public int bonusNum() {
		for (int i = 0; i < lottoNumber.length; i++) {
			bonusNum = random.nextInt(45) + 1;// 당첨 번호 랜덤 생성
			for (int j = 0; j < lottoNumber.length; j++) {
				if (bonusNum == lottoNumber[i]) {
					i--;
					break;
				}
			}
		}
		return bonusNum;
	}

	public int getmyBonusNum() //
	{
		return myBonusNum;
	}

	public void setmyBonusNum(int myBonusNum) {
		this.myBonusNum = myBonusNum;
	}

	public int myBonusNum() {
		for (int i = 0; i < lottoNumber.length; i++) {
			myBonusNum = random.nextInt(45) + 1;// 당첨 번호 랜덤 생성
			for (int j = 0; j < lottoNumber.length; j++) {
				if (myBonusNum == lottoNumber[i]) {
					i--;
					break;
				}
			}
		}
		return myBonusNum;
	}

}