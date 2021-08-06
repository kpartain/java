package calculatorAssignment;

public class Runner {

	public static void main(String[] args) {
		//Calculator I
		// Calculator myCalculator = new Calculator();
		// myCalculator.setOperandOne(10.5);
		// myCalculator.setOperation('+');
		// myCalculator.setOperandTwo(5.2);
		// myCalculator.performOperation();
		// System.out.println("CALCULATOR I RESULTS");
		// System.out.println(myCalculator.getResults());
		
		//Calculator II
		CalculatorTwo secondCalculator = new CalculatorTwo();
		secondCalculator.performOperation(10.5);
		System.out.println(secondCalculator.getFunctionsToExecute());
		secondCalculator.performOperation("+");
		System.out.println(secondCalculator.getFunctionsToExecute());
		secondCalculator.performOperation(5.2);
		System.out.println(secondCalculator.getFunctionsToExecute());
		secondCalculator.performOperation("*");
		System.out.println(secondCalculator.getFunctionsToExecute());
		secondCalculator.performOperation(10);
		System.out.println(secondCalculator.getFunctionsToExecute());
		secondCalculator.performOperation("=");
		System.out.println(secondCalculator.getFunctionsToExecute());
		Double hopeThisWorks = secondCalculator.getResults();
		System.out.println("CALCULATOR II RESULTS");
		System.out.println(hopeThisWorks);
		
	}

}
