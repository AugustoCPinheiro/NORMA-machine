package commands;

import java.util.ArrayList;

import interfaces.Command;
import managers.ExecutionManager;
import managers.FunctionsManager;
import models.Expression;

public class Goto implements Command {
	@Override
	public void action(String terms, ArrayList<Expression> expressions) {
		ExecutionManager.execute(Integer.parseInt(terms));
	}

	@Override
	public void parse(String terms) throws Exception {
		// TODO Auto-generated method stub

	}
}
