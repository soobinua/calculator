package calculator;

import java.util.ArrayList;

public class TokenQueue {

	private ArrayList<Token> queue;
	private int size;

	public TokenQueue() {
		size = 0;
		queue = new ArrayList<Token>();
	}

	public void enQueue(Token token) {
		queue.add(token);
		size++;
	}

	public Token deQueue() {
		Token token = queue.remove(0);
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

	public void display() {
		while (!isEmpty()) {
			Token token = deQueue();
			System.out.println("token:/" + token.getLiteral() + "/" + token.getTokenType());
		}
	}
}
