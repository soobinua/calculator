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
//		char charInput;
//		for(int i = 0; i <= input.length() - 1; i++) {
//			charInput = input.charAt(i); //charAt(index)
//			System.out.println("/" + charInput + "/");
//		}
		
		String[] inputArr = input.split(""); //구분자 "" 빈문자열
		String tokenInput = "";
		Token token = null;
		for(int i = 0; i <= inputArr.length - 1; i++) {
			tokenInput = inputArr[i];
			token = new Token(tokenInput, TokenType.OPERAND);
			tokenQueue.enQueue(token);
		}
		return tokenQueue;
		
	}

}
