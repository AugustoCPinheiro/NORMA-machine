package commands;

import java.util.ArrayList;

import interfaces.Command;
import managers.RegisterManager;
import models.Expression;

public class Dec implements Command {

	@Override
	public void action(String terms, ArrayList<Expression> expressions) {
		RegisterManager.registers[Integer.valueOf(terms)]
				.setValue(RegisterManager.registers[Integer.valueOf(terms)].getValue() - 1);
	}

	@Override
	public void parse(String terms) throws Exception {
		// TODO Auto-generated method stub

	}
}
