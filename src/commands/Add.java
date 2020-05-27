package commands;

import java.util.ArrayList;

import interfaces.Command;
import managers.RegisterManager;
import models.Expression;

public class Add implements Command {

	@Override
	public void action(String terms, ArrayList<Expression> expressions) {
		String[] params = terms.split(" ");
		RegisterManager.registers[Integer.valueOf(params[0])]
				.setValue(RegisterManager.registers[Integer.valueOf(params[0])].getValue()
						+ RegisterManager.registers[Integer.valueOf(params[1])].getValue());

	}

	@Override
	public void parse(String terms) throws Exception {
		// TODO Auto-generated method stub

	}
}
