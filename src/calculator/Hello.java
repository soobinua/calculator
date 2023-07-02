package calculator;

public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello");

		// calculator
		// 계산기 종료 방식 고려 enter, =
		// 문법을 지정해줘야 한다.
		// 수식 문법 내 유의미한 것 token : 2, +, 3, *, 4, =
		// token 아닌 것 : 공백 whitespace, tab, enter (enter 토큰으로 정할 수 있음. 문법 정하기 나름)
		// 2 +
		// 3 * 4 =
		// 21 - 3 * 64

		// 수식 안에서 token을 뽑아서 문법에 맞으면 계산을 해야한다.
		// lexical analysis : 어휘 분석
		// lexer : 어휘 분석을 통해 토큰 뽑아내는 작업. 주작업이 어휘 분석 == tokenizer
		// tokenizer : 사용자 입력 안에서 유의미한 토큰을 뽑아내는 작업. 주작업이 토큰 분리 == lexer
		// linter : 토큰이 문법에 맞는지 확인
		// syntactic error : 문법 잘못되었다면 에러
		// parser : 에러가 없다면 구문을 분석
		// semantic analysis : 파서가 의미 분석
		// 계산

		// 사용자에게 중위표기식 받음
		// 토큰 뽑은 뒤 후위표기식으로 변경
		// 이후 계산
		// 계산 결과값 출력
	}
}
