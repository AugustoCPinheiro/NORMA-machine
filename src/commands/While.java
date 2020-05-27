package commands;

import java.util.ArrayList;

import factories.AssertiveCommandFactory;
import interfaces.AssertiveCommand;
import interfaces.ControlCommand;
import models.Expression;

public class While implements ControlCommand {
	@Override
	public void action(String terms, ArrayList<Expression> expressions) {
		String[] localTerms = terms.split(" ");
		AssertiveCommand command = AssertiveCommandFactory.getCommand(localTerms[0]);
		if(command.action(localTerms[1])) {
			postAction(terms, expressions);
		}
	}

	@Override
	public void postAction(String terms, ArrayList<Expression> expressions) {
		for (Expression expression : expressions) {
			expression.getCommand().action(expression.getTerms(), expression.getExpressions());
		}
		action(terms, expressions);
	}

	@Override
	public void parse(String terms) throws Exception {
		// TODO Auto-generated method stub

	}

}
