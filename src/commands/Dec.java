package commands;
import interfaces.Command;
import managers.RegisterManager;

public class Dec implements Command {

	@Override
	public void action(String terms) {
		RegisterManager.registers[Integer.valueOf(terms)].setValue(RegisterManager.registers[Integer.valueOf(terms)].getValue()-1); 
	}
	@Override
	public void parse(String terms) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
