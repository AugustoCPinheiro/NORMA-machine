package commands;

import java.util.ArrayList;

import interfaces.Command;
import managers.RegisterManager;
import models.Expression;

public class Set0 implements Command {

	@Override
	public void action(String terms, ArrayList<Expression> expressions) {
		RegisterManager.registers[Integer.valueOf(terms)].setValue(0);
	}

	@Override
	public void parse(String terms) throws Exception {
		// TODO Auto-generated method stub

	}
}
