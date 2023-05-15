package Lotto;

public class Error {
	
	public static boolean isInteger(String judgment) { // 입력이 정수인지 판별
		try {
			Integer.parseInt(judgment);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("올바른 입력이 아닙니다.");
			return false;
		}
	}
}
