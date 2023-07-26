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
			index = position; // global state, invariant 문제
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
			skipSpaces();
			token = switch (charInput) { //switch expression. global state, invariant문제로 switch식 사용. invariant 불변속성(변하지 않는 속성이 아니라 변하는 불변이라는 속성값으로 모두 생각하고 사용하는것) 이로 인해 묹제 발생
			case '+' -> new Token(String.valueOf(charInput), TokenType.OPERATOR); // 한 줄인 경우 {}와 yield 생략 가능. yield new Token...
			case '-' -> new Token(String.valueOf(charInput), TokenType.OPERATOR);
			case '*' -> new Token(String.valueOf(charInput), TokenType.OPERATOR);
			case '/' -> new Token(String.valueOf(charInput), TokenType.OPERATOR);
			// 숫자
			case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> getNumberToken();
			case ';' -> new Token(String.valueOf(charInput), TokenType.EOF);
			// 공백 구분자 외 부적합 처리
			default -> new Token(String.valueOf(charInput), TokenType.ILLEGAL); //default는 언제든지 invariant 될 수 있으므로 사용 지양해야 한다.
			}; // expression 문장 하나로 생각하기에 ; 필수
			tokenQueue.enQueue(token);
			if (token.getTokenType() != TokenType.OPERAND) {
				readCharacter();
			}
		}
		return tokenQueue;
	}

	private void skipSpaces() {
		if (isSpace()) {
			while (isSpace()) {
				readCharacter();
			}
		}
	}

	private boolean isSpace() {
		if (charInput == ' ' || charInput == '\t') {
			return true;
		}
		return false;
	}

	private Token getNumberToken() {
		int start = this.index; // 시작 index

		while (isNumber()) { // 숫자면 계속 다음 값 읽음
			readCharacter();
		}

		int end = index; // 숫자 아닌 index

		String str = "";
//		for (int i = start; i < end; i++) {
//			str += input.charAt(i); // str = str + String.valueOf(input.charAt(i));
//		}
		str = input.substring(start, end); // [start, end) start는 포함하고 end는 포함하지 않는다는 표기법
		return new Token(str, TokenType.OPERAND);
	}

	private boolean isNumber() {
		// if (charInput == '0' || charInput == '2' ... '9') // 동일

		String abc = "abc";
		char def = 'a'; // char타입 메모리 저장 유니코드로 저장되며 유니코드는 2바이트로 저장됨
		char efg = 65; // 값변수
		String kkk = "가나다";
		char[] gg = { 'a', 'b', 'c' };
		String[] yy = { "a", "b", "c" }; // 참조변수 stack에 4바이트로 변수에 힙 주소값 저장 -> 힙 12바이트 만들어져서 4바이트당 문자열 저장하는 주소 값 저장.(32비트 컴퓨터. 64비트인 경우 24바이트)
		String[] zz = { "a1234", "b1234", "c1234", "d1234" }; // 참조변수 stack에 4바이트로 변수에 힙 주소값 저장 -> 힙 16바이트 만들어져서 4바이트당 문자열 저장하는 주소 값 저장

		if (charInput >= '0' && charInput <= '9') { // 아스키코드로 이용하면 코드 간편
			// 2바이트 charInput과 Integer 4바이트 비교 가능한 이유
			// promotion. 수식에서 Integer가 나오는 경우 다른 타입 Integer로 바꿔서 비교
			// 원래 57 숫자 한바이트지만 Integer이므로 4바이트
			// promotion. 기본 정수는 Integer 4바이트. 부동 소수점 double 8바이트로 바꿔서 비교
			return true;
		} else {
			return false;
		}
	}

}
