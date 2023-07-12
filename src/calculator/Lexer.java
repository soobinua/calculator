package calculator;

public class Lexer {

	private String input;
	private char charInput;
	private int index; // 현재 charInput 인덱스
	private int position; // 다음 charInput 인덱스

	public Lexer(String input) {
		this.input = input;
		this.position = -1;
	}

	public void next() {
		// position++; 읽지 않았는데 position 값 증가하고 싶지 않다.
		if (position > input.length() - 2) { // position 위치에 따라 length() - 1
			// 마지막 인덱스 초과 읽을 수 없다.
			throw new RuntimeException();
		}
		position++;
		charInput = input.charAt(position);
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
			// TODO
			// 현재 한 자릿수 토큰은 생성 가능하나 두자릿수부터 토큰 생성 불가
			// token 생성하기 전에 다음 문자를 읽고 판단한 뒤 토큰 생성해야한다.
			// switch문 안에서 ' '체크가 아닌 이전에 공백문자 체크 후 다음 문자 읽고 진행.
			// tab키도 체크하지 않고 있다.
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
