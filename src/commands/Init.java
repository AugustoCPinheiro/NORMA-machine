package commands;

import java.util.ArrayList;

import interfaces.Command;
import managers.RegisterManager;
import models.Expression;

public class Init implements Command{
@Override
	public void action(String terms, ArrayList<Expression> expressions) {
	String[] params = terms.split(" ");
	RegisterManager.registers[Integer.valueOf(params[0])]
			.setValue(Integer.valueOf(params[1]));
	
	}
	@Override
	public void parse(String terms) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
