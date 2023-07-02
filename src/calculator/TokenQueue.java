package calculator;

import java.util.ArrayList;

public class TokenQueue {

	private ArrayList<Token> queue;
	private int front;
	private int size;

	public TokenQueue() {
		front = 0;
		size = 0;
		queue = new ArrayList<Token>();
	}

	public void enQueue(Token token) {
		queue.add(token);
		size++;
	}

	public Token deQueue() {
		Token token = queue.get(front);
		front++;
		size--;
		return token;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}
}
