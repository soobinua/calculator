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
//		String[] inputArr = input.split(""); //구분자 "" 빈문자열
//		String tokenInput = "";
//		for(int i = 0; i <= inputArr.length - 1; i++) {
//			tokenInput = inputArr[i];
//		}

		Token token = null;
		char tokenInput;
		for (int i = 0; i <= input.length() - 1; i++) {
			tokenInput = input.charAt(i); // charAt(index)
			switch (tokenInput) {
			case '+':
				token = new Token(String.valueOf(tokenInput), TokenType.OPERATOR);
				break;
			case '-':
				token = new Token(String.valueOf(tokenInput), TokenType.OPERATOR);
				break;
			case '*':
				token = new Token(String.valueOf(tokenInput), TokenType.OPERATOR);
				break;
			case '/':
				token = new Token(String.valueOf(tokenInput), TokenType.OPERATOR);
				break;
			case ' ': // 빈문자열은 가능하나 빈문자 불가능. 빈문자 표현 = '\0' (이스케이프문자)
				token = null;
				break; // 스페이스바 저장 X
			default:
				token = new Token(String.valueOf(tokenInput), TokenType.OPERAND);
			}
			if (token != null) {
				tokenQueue.enQueue(token);
			}
		}
		return tokenQueue;

	}

}
