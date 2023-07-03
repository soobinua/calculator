package calculator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) throws FileNotFoundException {

		Input inputClass = new Input();

		//File create and write
//		try {
//			Files.writeString(Paths.get("xyz.txt"), "calculator", StandardCharsets.UTF_8);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//File input
//		File file = new File("abc.txt");
//		Scanner fileScanner = new Scanner(file);
		
		//KeyBoard input
		Scanner scanner = new Scanner(System.in);
		System.out.println("계산할 수식을 입력하세요. (종료 : q)");
		while(true) {
//			String input = inputClass.getFileInput(file, fileScanner);
//			System.out.println("파일 내용 : " + input);
			String input = inputClass.getInput(scanner);
			
			if(input.equals("q")) {
				break;
			}
			
			Lexer lexer = new Lexer(input);
			TokenQueue tokenQueue = lexer.lex();
			
			while (!tokenQueue.isEmpty()) {
				System.out.println("token : " + tokenQueue.deQueue().getLiteral());
			}
		}
//		fileScanner.close();
		scanner.close();

		System.out.println("입력이 종료되었습니다.");
	}

}
