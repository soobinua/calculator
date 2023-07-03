package calculator;

public class Lexer {

	public String input;

	public Lexer(String input) {
		this.input = input;
	}

	public TokenQueue lex() {
		
		TokenQueue tokenQueue = new TokenQueue();
		// lexical analysis 어휘 분석
		// 결과 : 여러개 token 나온다.
		Token token = new Token(input, TokenType.OPERAND);
		tokenQueue.enQueue(token);
		return tokenQueue;
		
	}

}
