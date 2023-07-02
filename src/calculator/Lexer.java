package calculator;

public class Lexer {

	public String input;

	public Lexer(String input) {
		this.input = input;
	}

	public TokenQueue lex() {
		// input = 2 + 3 * 4;

		TokenQueue tokenQueue = new TokenQueue();
		// lexical analysis 어휘 분석
		// 결과 : 여러개 token 나온다.
		Token token = new Token("4", TokenType.OPERAND);
		tokenQueue.enQueue(token);
		token = new Token("5", TokenType.OPERAND);
		tokenQueue.enQueue(token);
		token = new Token("+", TokenType.OPERATOR);
		tokenQueue.enQueue(token);
		token = new Token("-", TokenType.OPERATOR);
		tokenQueue.enQueue(token);
		token = new Token("*", TokenType.OPERATOR);
		tokenQueue.enQueue(token);

		return tokenQueue;
	}

}
