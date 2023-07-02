package calculator;

import java.io.FileNotFoundException;

public class Calculator {

	public static void main(String[] args) throws FileNotFoundException {

		Input inputClass = new Input();

//		String fileInput = inputClass.getFileInput();
//		System.out.println("파일 내용 : " + fileInput);

		String input = inputClass.getInput();
//		System.out.println("입력하신 내용 : " + input);

		Lexer lexer = new Lexer(input);
		TokenQueue tokenQueue = lexer.lex();

		while (!tokenQueue.isEmpty()) {
			System.out.println("token : " + tokenQueue.deQueue().getLiteral());
		}

	}

}
