package managers;

import java.util.ArrayList;
import java.util.List;

import models.Expression;

public class ExecutionManager {
	public static ArrayList<Expression> instructions;

	public static void execute() {
		for (Expression expression : instructions) {
			expression.getCommand().action(expression.getTerms(), expression.getExpressions());
		}
	}
	
	public static void execute(int initialExpression) {
		List<Expression> currentInstructions = instructions.subList(initialExpression - 1, instructions.size() - 1);
		for (Expression expression : currentInstructions) {
			expression.getCommand().action(expression.getTerms(), expression.getExpressions());
		}
	}
	
}
