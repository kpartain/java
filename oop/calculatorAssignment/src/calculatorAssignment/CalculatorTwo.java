package calculatorAssignment;

import java.util.ArrayList;

public class CalculatorTwo implements java.io.Serializable {
	@SuppressWarnings("rawtypes")
	private ArrayList functionsToExecute = new ArrayList();;
	private Double results;
	
	public CalculatorTwo() {
	}
	
	public ArrayList getFunctionsToExecute(){
		return this.functionsToExecute;
	}
	
	public void setResults (Double newValue) {
		this.results = newValue;
	}
	
	//if a double is given, add as double
	@SuppressWarnings("unchecked")
	public void performOperation(Double numericalValue) {
		this.functionsToExecute.add(numericalValue);
	}
	//if integer is input, cast to double and add
	@SuppressWarnings("unchecked")
	public void performOperation(Integer numericalValue) {
		Double addAsDouble = Double.valueOf(numericalValue);
		this.functionsToExecute.add(addAsDouble);
	}
	//if an operation is given, cast as double
	@SuppressWarnings("unchecked")
	public void performOperation(String operationToExecute) {
		if(operationToExecute != "=" ) {
			this.functionsToExecute.add(operationToExecute);
		}
	}
	
	
	public Double getResults() {
		Double theAnswer = 0.00;
		//while we don't have one index (when length is 1, we have our answer)
		while(functionsToExecute.size() > 1) {
			
			//Multiplication
			while(functionsToExecute.contains("*")) {
				//store the index where * occurs each time it exists
				int indexOfSymbol = functionsToExecute.indexOf("*");
				//index before is object, cast to Double
				Object objectBefore = functionsToExecute.get(indexOfSymbol - 1);
				Double numberBefore = (Double) objectBefore;
				
				//index after is object, cast to Double
				Object objectAfter = functionsToExecute.get(indexOfSymbol + 1);
				Double numberAfter = (Double) objectAfter;
				
				//new number - put back in as an object so above code works
				Object newNumber = (Object) (numberBefore * numberAfter);
				//replace left operand with new value
				functionsToExecute.set((indexOfSymbol-1), newNumber);
				//delete operand to the right of operation symbol
				functionsToExecute.remove(indexOfSymbol + 1);
				//delete operation symbol last
				functionsToExecute.remove(indexOfSymbol);
				
			}
			//Division
			while(functionsToExecute.contains("/")) {
				//store the index where * occurs each time it exists
				int indexOfSymbol = functionsToExecute.indexOf("/");
				//index before is object, cast to Double
				Object objectBefore = functionsToExecute.get(indexOfSymbol - 1);
				Double numberBefore = (Double) objectBefore;
				
				//index after is object, cast to Double
				Object objectAfter = functionsToExecute.get(indexOfSymbol + 1);
				Double numberAfter = (Double) objectAfter;
				
				//new number - put back in as an object so above code works
				Object newNumber = (Object) (numberBefore / numberAfter);
				//replace left operand with new value
				functionsToExecute.set((indexOfSymbol-1), newNumber);
				//delete operand to the right of operation symbol
				functionsToExecute.remove(indexOfSymbol + 1);
				//delete operation symbol last
				functionsToExecute.remove(indexOfSymbol);
				
			}
			//Addition
			while(functionsToExecute.contains("+")) {
				//store the index where * occurs each time it exists
				int indexOfSymbol = functionsToExecute.indexOf("+");
				//index before is object, cast to Double
				Object objectBefore = functionsToExecute.get(indexOfSymbol - 1);
				Double numberBefore = (Double) objectBefore;
				
				//index after is object, cast to Double
				Object objectAfter = functionsToExecute.get(indexOfSymbol + 1);
				Double numberAfter = (Double) objectAfter;
				
				//new number - put back in as an object so above code works
				Object newNumber = (Object) (numberBefore + numberAfter);
				//replace left operand with new value
				functionsToExecute.set((indexOfSymbol-1), newNumber);
				//delete operand to the right of operation symbol
				functionsToExecute.remove(indexOfSymbol + 1);
				//delete operation symbol last
				functionsToExecute.remove(indexOfSymbol);
				
			}
			//Subtraction
			while(functionsToExecute.contains("-")) {
				//store the index where * occurs each time it exists
				int indexOfSymbol = functionsToExecute.indexOf("-");
				//index before is object, cast to Double
				Object objectBefore = functionsToExecute.get(indexOfSymbol - 1);
				Double numberBefore = (Double) objectBefore;
				
				//index after is object, cast to Double
				Object objectAfter = functionsToExecute.get(indexOfSymbol + 1);
				Double numberAfter = (Double) objectAfter;
				
				//new number - put back in as an object so above code works
				Object newNumber = (Object) (numberBefore - numberAfter);
				//replace left operand with new value
				functionsToExecute.set((indexOfSymbol-1), newNumber);
				//delete operand to the right of operation symbol
				functionsToExecute.remove(indexOfSymbol + 1);
				//delete operation symbol last
				functionsToExecute.remove(indexOfSymbol);
			}
		}
		//reassign the value of the answer to the only remaining index
		theAnswer = (Double) functionsToExecute.get(0);
		//set this as the calculators current result
		this.setResults(theAnswer);
		//return the double value of this result
		return this.results;
	}
}
