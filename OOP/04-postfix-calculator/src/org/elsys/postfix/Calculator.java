package org.elsys.postfix;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

import org.elsys.postfix.operations.*;

public class Calculator {

	private Map<String, Operation> operations = new HashMap<>();

	private List<Double> stack = new LinkedList<>();

	private InputStream in;

	private PrintStream out;
	
	public Calculator(InputStream in, PrintStream out) {
		this.in = in;
		this.out = out;
		addOperation(new Negate(this));
		addOperation(new Dup(this));
		addOperation(new Sin(this));
		addOperation(new Cos(this));
		addOperation(new Plus(this));
		addOperation(new Minus(this));
		addOperation(new Multi(this));
		addOperation(new Divi(this));
		addOperation(new Ternar(this));
	}

	public void run() {
		String input;
		try (Scanner scanner = new Scanner(in)) {
			while (scanner.hasNext()) {
				out.print(stack.size() + ": ");
				input = scanner.next();
				if (isDouble(input)) {
					stack.add(Double.valueOf(input));
				} else {
					Operation operation = getOperation(input);
					if (operation != null) {
						operation.calculate();
					} else {
						throw new UnsupportedOperationException();
					}
				}
			}
		}
	}

	private static boolean isDouble(String input) {
		try {
			Double.valueOf(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public void addOperation(Operation operation) {
		operations.put(operation.getToken(), operation);
	}

	public Operation getOperation(String token) {
		return operations.get(token);
	}

	public Double popValue() {
		if(stack.size() == 0){
			throw new EmptyStackException();
		}

		int lastIndex = stack.size() - 1;
		Double value = stack.get(lastIndex);

		stack.remove(lastIndex);

		return value;
	}

	Double lastValue() {
		return stack.get(stack.size() - 1);
	}

	public void addValue(double value) {
		out.println(value);
		stack.add(value);
	}

	int stackSize() {
		return stack.size();
	}
}
