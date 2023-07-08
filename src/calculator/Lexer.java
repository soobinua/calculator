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
		String[] inputArr = input.split(""); //구분자 "" 빈문자열
		String tokenInput = "";
		for(int i = 0; i <= inputArr.length - 1; i++) {
			tokenInput = inputArr[i];
		}
		Token token = new Token(tokenInput, TokenType.OPERAND);
		tokenQueue.enQueue(token);
		return tokenQueue;
		
	}

}
