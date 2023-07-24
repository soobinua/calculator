package calculator;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) throws FileNotFoundException {

		//File create and write
//		try {
			// Java 는 Writer가 있으면 Reader가 있다.
			// FileWriter <-> FileReader : 문자를 다룬다. ex)BufferedWriter, BufferedReader
			// File : binary 다룬다. ex)BufferedStream
		
//			Files.writeString(Paths.get("xyz.txt"), "calculator", StandardCharsets.UTF_8);
			
			//FileWriter 이용
//			FileWriter fw = new FileWriter("def.txt");
//			fw.write("hello fileWriter");
//			fw.close();
			
			//PrintWriter 이용
//			PrintWriter pw = new PrintWriter(new FileWriter("ghi.txt"));
//			PrintWriter pw = new PrintWriter(System.out);
//			pw.println("hello PrintWriter"); //System.out의 멤버함수들 사용 가능
//			pw.print("hello System out");
//			pw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//File input
//		File file = new File("abc.txt");
//		Scanner scanner = new Scanner(file);
		//KeyBoard input
		Scanner scanner = new Scanner(System.in);
		
		Input inputClass = new Input(scanner);
		
		System.out.println("계산할 수식을 입력하세요. (종료 : q)");
		while(true) {
			String input = inputClass.getInput();
			
			if(input.equals("q")) {
				break;
			}
			
			Lexer lexer = new Lexer(input);
			TokenQueue tokenQueue = lexer.lex();
			
			tokenQueue.display();
		}
		scanner.close();

		System.out.println("프로그램이 종료되었습니다.");
	}
	
	// OOP 방식의 프로그램 작성하기
	// 1. 객체 간의 메시지 전달로 프로그램 동작하게 하기
	// 2. 중복 제거
	// TDD 방식
}
