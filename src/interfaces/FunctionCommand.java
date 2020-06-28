package interfaces;

import java.util.ArrayList;

import managers.FunctionsManager;
import models.Expression;

public interface FunctionCommand extends Command{
 @Override
 	default void action(String terms, ArrayList<Expression> expressions) {
	
		System.out.println(FunctionsManager.functions.get(terms));
		ArrayList<Expression> functionExpressions = FunctionsManager.functions.get(terms);
		for (Expression expression : functionExpressions) {
			expression.getCommand().action(expression.getTerms(), expression.getExpressions());
		}
 	}
}
