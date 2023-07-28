package calculator;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void test() {
//		char[] javaCharArray = { 'a', 'b', 'c' }; // Java
		char abc[] = { 'a', 'b', 'c' }; // C. C언어 문법 사용 가능
		for (int i = 0; i < abc.length; i++) {
			System.out.println(abc[i]);
		}
	}

	@Test
	void sumFor() {
		// 1~10까지 더하기 - for
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("1에서 10까지의 합 : " + sum);
	}

	@Test
	void sumWhile() {
		// 1~10까지 더하기 - while
		int sum = 0;
		int i = 1;
		while (i <= 10) {
			sum += i;
			i++;
		}
		System.out.println("1에서 10까지의 합 : " + sum);

	}

}
