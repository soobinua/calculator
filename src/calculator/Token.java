package calculator;

public class Token {

	private String literal;
	private TokenType tokenType;

	public Token(String literal, TokenType tokenType) {
		this.literal = literal;
		this.tokenType = tokenType;
	}

	public String getLiteral() {
		return literal;
	}

}
