package calculator;

public class Lexer {

	private String input;
	private char charInput;
	private int index; // 현재 charInput 인덱스
	private int position; // 다음 charInput 인덱스

	public Lexer(String input) {
		this.input = input;
		this.position = 0;

		if (input.length() == 0) {
			throw new RuntimeException();
		} else {
			readCharacter();
		}
	}

	public void readCharacter() {
		if (position > input.length() - 1) {
			charInput = ';';
		} else {
			charInput = input.charAt(position);
			index = position;
			position++;
		}
	}

	public void peekCharacter() {
		if (position > input.length() - 1) {
			charInput = ';';
		} else {
			charInput = input.charAt(position);
			position++;
		}
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
		while (charInput != ';') {
			switch (charInput) {
			case '+':
				token = new Token(String.valueOf(charInput), TokenType.OPERATOR);
				break;
			case '-':
				token = new Token(String.valueOf(charInput), TokenType.OPERATOR);
				break;
			case '*':
				token = new Token(String.valueOf(charInput), TokenType.OPERATOR);
				break;
			case '/':
				token = new Token(String.valueOf(charInput), TokenType.OPERATOR);
				break;
			case ' ': // 빈문자열은 가능하나 빈문자 불가능. 빈문자 표현 = '\0' (이스케이프문자)
				token = null;
				break; // 스페이스바 저장 X
			default:
				token = new Token(String.valueOf(charInput), TokenType.OPERAND);
			}
			if (token != null) {
				tokenQueue.enQueue(token);
			}
			readCharacter();
		}
		return tokenQueue;

	}

}
