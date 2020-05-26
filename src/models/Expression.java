package models;
import java.util.Arrays;

import interfaces.Command;

public  class Expression {
	private Command command;
	private String terms;
	private Expression[] expressions;
	
	public Expression(Command command, String terms) {
		this.command = command;
		this.terms = terms;
	}

	public Expression(Command command, String terms, Expression[] expressions) {	
		this.command = command;
		this.terms = terms;
		this.expressions = expressions;
	}

	@Override
	public String toString() {
		return "Expression [command=" + command + ", terms=" + terms + ", expressions=" + Arrays.toString(expressions)
				+ "]";
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	
}
