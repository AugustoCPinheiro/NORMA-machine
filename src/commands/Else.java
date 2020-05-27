package commands;

import java.util.ArrayList;

import interfaces.Command;
import models.Expression;

public class Else implements Command {
	@Override
	public void action(String terms, ArrayList<Expression> expressions) {
		for (Expression expression : expressions) {
			expression.getCommand().action(expression.getTerms(), expression.getExpressions());
		}
	}

	@Override
	public void parse(String terms) throws Exception {
		// TODO Auto-generated method stub

	}


}
