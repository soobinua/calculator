package calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {

	public String getFileInput(File file, Scanner fileScanner) throws FileNotFoundException {
		String fileInput;
		fileInput = fileScanner.nextLine();
		return fileInput;
	}

	public String getInput(Scanner scanner) {
		System.out.print("> "); //prompt
		String input = scanner.nextLine();
		return input;
	}

}
