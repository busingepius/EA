package jms;
import java.io.Serializable;

public class CalcInstruction implements Serializable {
	private static final long serialVersionUID = 1L;

	private char operator;
	private int number;

	public CalcInstruction() {
	}

	public CalcInstruction(char operator, int number) {
		this.operator = operator;
		this.number = number;
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "CalcInstruction{" +
				"operator=" + operator +
				", number=" + number +
				'}';
	}
}
