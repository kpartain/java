package calculatorAssignment;

public class Runner {

	public static void main(String[] args) {
		Calculator myCalculator = new Calculator();
		myCalculator.setOperandOne(10.5);
		myCalculator.setOperation('+');
		myCalculator.setOperandTwo(5.2);
		myCalculator.performOperation();
		System.out.println(myCalculator.getResults());
		
	}

}
