package com.hayden.calculator;
import java.util.ArrayList;

public class Calculator implements java.io.Serializable {
	private ArrayList<Object> operation = new ArrayList<Object>();
	private double results;
	private double operandOne;
	private double operandTwo;
	private String operator;
	private boolean hasOperand;
	private int indexTracker = 0;
	
	public Calculator() {
		
	}
	
	public double performOperation(Object entry) {
		// If the string value is not "=", assume we're still performing a calc and add it to the ArrayList
//		System.out.println("Value: "+value);
//		double operand = 0;
		String operator;
		
		if (!entry.equals("=")) {
			setOperation(entry); // Add the value to the ArrayList
			indexTracker++; // Increment the counter
			System.out.println("indexTracker: "+indexTracker);
			// Check if multiplication or division (for order of operations)
			if (entry.equals("*") || entry.equals("/")) {
				setOperator((String) entry);
				Double op1 = (Double) getOperation().get((indexTracker - 2));
//				System.out.println("op1: "+op1);
				setOperandOne(op1); // Get previous number
				setHasOperand(true); // Flag so that next number is sent to the subCalc
			}
			else if (getHasOperand()) {
//				System.out.println("value: "+value);
//				 Cast int to double
				if (entry.getClass() == Integer.class) {
					double newVal = (Integer)entry*1.0;
					setOperandTwo(newVal);
				}
				else {
					setOperandTwo((Double) entry);					
				}
				double subTotal = subCalc(getOperandOne(), getOperandTwo(), getOperator());
				operation.add(indexTracker-3, subTotal);
				indexTracker++;
				for (int i = operation.size()-1; i>indexTracker-2; i--) {
//					System.out.println("i: "+i);
					operation.remove(i); // Clear out the values that were just dealt with in the subCalc
					System.out.print("operation removal: "+operation);
				}
				setIndexTracker(indexTracker-3); // reset the indexTracker
				setOperation(subTotal); // Add the new subtotal to the ArrayList
			}
		}
		else {
			// Loop through the ArrayList and pull out the numbers and operators
			for (int i=0; i<operation.size(); i++) {
				Class<? extends Object> type = operation.get(i).getClass();
//				if (type == Double.class || type == Integer.class) {
//					setOperandOne((Double) operation.get(i)); // Cast any number to a double and set it as the first operand
//				}
				if (type == String.class) {
					operator = (String) operation.get(i);
					if (operator.equals("+")) {
						double num1 = (Double) operation.get((i-1));
						double num2 = (Double) operation.get((i+1));
						setResults(getResults() + (num1+num2));
					}
					else if (operator.equals("-")) {
						double num1 = (Double) operation.get((i-1));
						double num2 = (Double) operation.get((i+1));
						setResults(getResults()+(num1-num2));
					}
				}
			}
		}
		
		
		
//		// Check operator type
//		if (operator.equals("+")) {
//			this.setResults(d + e);
//		}
//		else if (operator.equals("-")) {
//			this.setResults(d - e);
//		}
//		else if (operator.equals("*")) {
//			this.setResults(d * e);
//		}
//		else if (operator.equals("/")) {
//			this.setResults(d / e);
//		}
//		else {
//			System.out.println("Invalid operator");
//			return -1;
//		}
		
		return getResults();
		
	}
	
	private double subCalc(double num1, double num2, String operator) {
		double subCalc = 0;
		if (operator.equals("*")) {
			subCalc = num1*num2;
			setHasOperand(false);
			setOperator("");
		}
		if (operator.equals("/")) {
			subCalc = num1/num2;
			setHasOperand(false);
			setOperator("");
		}
//		if (operator.equals("+")) {
//			subCalc = num1+num2;
//			setOperator("");
//		}
//		if (operator.equals("-")) {
//			subCalc = num1-num2;
//			setOperator("");
//		}
		
		return subCalc;
	}
	
	// Getters and Setters

	public ArrayList<Object> getOperation() {
		return operation;
	}

	public void setOperation(Object value) {
//		System.out.println("in setOperation");
//		System.out.println("value: "+value);
		operation.add(value);
		System.out.println("operation: "+operation);
	}

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public double getResults() {
		return results;
	}

	public void setResults(double results) {
		this.results = results;
	}

	public boolean getHasOperand() {
		return hasOperand;
	}

	public void setHasOperand(boolean hasOperand) {
		this.hasOperand = hasOperand;
	}

	public int getIndexTracker() {
		return indexTracker;
	}

	public void setIndexTracker(int indexTracker) {
		this.indexTracker = indexTracker;
	}

}
