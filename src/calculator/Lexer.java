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

	public void readCharacter() { // 다음 값 읽는 메소드
		if (position > input.length() - 1) {
			charInput = ';';
			index = position; //global state, invariant 문제
		} else {
			charInput = input.charAt(position); // 다음 값 저장
			index = position; // index 값을 charInput 값으로 변경
			position++; // position 다음값으로 증가
		}
	}

	public TokenQueue lex() {
		TokenQueue tokenQueue = new TokenQueue();
		// lexical analysis 어휘 분석
		// 결과 : 여러개 token 나온다.
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
			case '\t': // 이스케이프 문자 tab
				token = null;
				break; // 스페이스바 저장 X
			// 숫자
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				// token = new Token(String.valueOf(charInput), TokenType.OPERAND);
				token = getNumberToken();
				tokenQueue.enQueue(token);
				continue;
			}
			if (token != null) {
				tokenQueue.enQueue(token);
			}
			readCharacter();
		}
		return tokenQueue;

	}

	private Token getNumberToken() {
		int start = this.index; // 시작 index

		while (isNumber()) { // 숫자면 계속 다음 값 읽음
			readCharacter();
		}

		int end = index; // 숫자 아닌 index
		
		String str = "";
//		for (int i = start; i < end; i++) {
//			str += input.charAt(i);
//		}
		str = input.substring(start, end); // [start, end) start는 포함하고 end는 포함하지 않는다는 표기법
		return new Token(str, TokenType.OPERAND);
	}

	private boolean isNumber() {
		// if (charInput == '0' || charInput == '2' ... '9') // 동일
		if (charInput >= 48 && charInput <= 57) { // 아스키코드로 이용하면 코드 간편
			return true;
		} else {
			return false;
		}
	}

}
