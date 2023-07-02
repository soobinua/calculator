package calculator;

public class ExpressionNotation {

	public static void main(String[] args) {
		// calculator
		// 계산기 알고리즘
		// expression notation 수식 표기법

		// 연산자 우선순위가 첫번째 고려
		// 2 + 3 * 4

		// 같은 연산자일 때 결합법칙도 고려 (좌결합, 우결합)
		// 3 + 4 + 2

		// 결합법칙 오른쪽부터 하는 경우
		// x = y = 3 (할당연산자, 대입연산자)
		// y = (x > 4) ? 3 : 7 //삼항연산자
		// y = (x > 90) ? "수" : (x >=80) ? "우" : "미"

		// 2항연산자. 2개의 피연산자 계산을 하기 위한 연산자 위치에 따라 나뉨
		// + 3 4 전위표기식 // 전위연산자 prefix notation ++a // 전위연산자 뒤에 피연산자 2개
		// 3 4 + 후위표기식 // 후위연산자 postfix notation a++ // 후위연산자 앞에 피연산자 2개
		// 3 + 4 중위표기식 // 중위연산자 infix notation a + b

		// 숫자의 위치는 똑같으나 연산자의 위치만 다름
		// 2 + 3 * 4 = 2 + (3 * 4) // 중위표기식
		// + 2 * 3 4 // 전위표기식
		// 2 3 4 * + // 후위표기식

		// (2 + 3) * 4 // 중위표기식에서는 연산자 우선순위를 바꾸고 싶다면 ()를 무조건 사용해야한다.
		// * + 2 3 4 // ()없이 전위표기식으로 표현
		// 2 3 + 4 * // ()없이 후위표기식으로 표현

		// 2 + 3 * 4 / (3 * 4 - 2 * 3) - 4 // 중위표기식
		// ((2 + ((3 * 4) / ((3 * 4) - (2 * 3)))) - 4) // 중위표기식 ()추가
		// - + 2 / * 3 4 - * 3 4 * 2 3 4 // 전위표기식
		// 2 3 4 * 3 4 * 2 3 * - / + 4 - // 후위표기식
		// 값 0

		// 컴퓨터로 계산할때는 중위표기식을 전위 또는 후위로 바꾼 뒤 계산
		// 주로 후위 사용. 순서대로 계산해야하므로 후위가 편하고 빠름
	}

}