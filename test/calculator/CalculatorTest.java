package calculator;

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

}
