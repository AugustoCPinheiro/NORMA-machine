package commands;

import java.util.ArrayList;

import factories.AssertiveCommandFactory;
import interfaces.AssertiveCommand;
import interfaces.ControlCommand;
import models.Expression;

public class If implements ControlCommand {
	@Override
	public void action(String terms, ArrayList<Expression> expressions) {
		System.out.println(expressions);
		String[] localTerms = terms.split(" ");
		AssertiveCommand command = AssertiveCommandFactory.getCommand(localTerms[0]);
		if (command.action(localTerms[1])) {
			postAction(terms, expressions);
		} else {
			for (Expression expression : expressions) {
				if (expression.getCommand() instanceof Else) {
					expression.getCommand().action(expression.getTerms(), expression.getExpressions());
				}
			}
		}

	}

	public void parse(String terms) throws Exception {
	};

	@Override
	public void postAction(String terms, ArrayList<Expression> expressions) {

		for (Expression expression : expressions) {
			if (!(expression.getCommand() instanceof Else)) {
				expression.getCommand().action(expression.getTerms(), expression.getExpressions());
			}
		}
	}
}
