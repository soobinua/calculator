package calculator;

import java.util.Scanner;

public class Input {

	private Scanner scanner;

	public Input(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getInput() {
		System.out.print("> "); // prompt
		return scanner.nextLine();
	}

}
