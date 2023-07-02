package calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {

	public String getFileInput() throws FileNotFoundException {
		File file = new File("abc.txt");

		Scanner scanner = new Scanner(file); // 파일 입력 받는 방법
		String fileInput = scanner.nextLine(); // 파일 내용 더 받고 싶으면 nextLine 더 추가하면 된다
//		String fileInputNext= scanner.nextLine(); // enter 분리자. 다음줄, 다음줄 ... 반복문 돌리면 된다.

		scanner.close();
		return fileInput;
	}

	public String getInput() {
		System.out.println("입력하세요."); // System.out : 표준출력

		Scanner scanner = new Scanner(System.in); // System.in : 표준입력 enter 종료
		String input = scanner.nextLine();

		scanner.close();
		return input;

	}

}
