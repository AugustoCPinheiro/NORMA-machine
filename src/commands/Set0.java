package commands;
import interfaces.Command;
import managers.RegisterManager;

public class Set0 implements Command {

	@Override
	public void action(String terms) {
		RegisterManager.registers[Integer.valueOf(terms)].setValue(0); 
	}
	@Override
	public void parse(String terms) throws Exception {
		// TODO Auto-generated method stub
		
	}
}

