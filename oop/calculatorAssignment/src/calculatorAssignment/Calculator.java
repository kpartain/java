package calculatorAssignment;

public class Calculator  implements java.io.Serializable {
	private Double operandOne;
	private Double operandTwo;
	private char operation;
	private Double results;
	
	public Calculator() {
		
	}
	
	public void setOperandOne(Double newValue) {
		this.operandOne = newValue;
	}
	public void setOperandTwo(Double newValue) {
		this.operandTwo = newValue;
	}
	public void setOperation(char newValue) {
		this.operation = newValue;
	}
	public void setResults (Double newValue) {
		this.results = newValue;
	}
	public Double getOperandOne() {
		return this.operandOne;
	}
	public Double getOperandTwo() {
		return this.operandTwo;
	}
	public char getOperation() {
		return this.operation;
	}
	public Double getResults() {
		return this.results;
	}
	public void performOperation() {
		char operationBeingExecuted = this.getOperation();
		switch(operationBeingExecuted) {
			case '+':
				this.setResults(this.getOperandOne() + this.getOperandTwo());
				break;
			case '-':
				this.setResults(this.getOperandOne() - this.getOperandTwo());
				break;
		}
	}
}
