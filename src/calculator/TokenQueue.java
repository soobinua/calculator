package calculator;

public class TokenQueue {

	public void enQueue(Token token) {

	}

	public Token deQueue() {
		Token token = new Token("+", TokenType.OPERATOR);
		return token;
	}

	public boolean isEmpty() {
		return false;
	}
}
