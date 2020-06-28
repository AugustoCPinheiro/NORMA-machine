package commands;

import java.util.ArrayList;

import interfaces.FunctionCommand;
import models.Expression;

public class Function implements FunctionCommand{
	private String funcName;
	
	public Function(String funcName) {
		
		this.funcName = funcName;
	}
	
	@Override
		public void action(String terms, ArrayList<Expression> expressions) {
			FunctionCommand.super.action(funcName, expressions);
		}
@Override
public void parse(String terms) throws Exception {
	// TODO Auto-generated method stub
	
}
}
