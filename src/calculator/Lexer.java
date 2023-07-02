package calculator;

public class Lexer {

	public String input;

	public Lexer(String input) {
		this.input = input;
	}

	public String lex() {
		// input = 2 + 3 * 4;
		Token token = new Token("2", TokenType.OPERAND);

		TokenQueue tokenQueue = new TokenQueue();
		tokenQueue.enQueue(token);
		if (tokenQueue.isEmpty()) {
			tokenQueue.deQueue();
		}

		return input;
	}

}
