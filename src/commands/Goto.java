package commands;

import java.util.ArrayList;

import interfaces.Command;
import managers.FunctionsManager;
import models.Expression;

public class Goto implements Command{
 @Override
public void action(String terms) {
	 System.out.println( FunctionsManager.functions.get(terms));
	ArrayList<Expression> expressions = FunctionsManager.functions.get(terms);
	for (Expression expression : expressions) {
		expression.getCommand().action(expression.getTerms());
	}
	
}
 @Override
	public void parse(String terms) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
