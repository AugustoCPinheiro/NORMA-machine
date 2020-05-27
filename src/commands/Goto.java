package commands;

import java.util.ArrayList;

import interfaces.Command;
import managers.FunctionsManager;
import models.Expression;

public class Goto implements Command {
	@Override
	public void action(String terms, ArrayList<Expression> expressions) {
		System.out.println(FunctionsManager.functions.get(terms));
		ArrayList<Expression> functionExpressions = FunctionsManager.functions.get(terms);
		for (Expression expression : functionExpressions) {
			expression.getCommand().action(expression.getTerms(), expression.getExpressions());
		}

	}

	@Override
	public void parse(String terms) throws Exception {
		// TODO Auto-generated method stub

	}
}
