package commands;
import interfaces.Command;
import managers.RegisterManager;

public class Set implements Command {

	@Override
	public void action(String terms) {
		String[] params = terms.split(" ");
		RegisterManager.registers[Integer.valueOf(params[0])].setValue(RegisterManager.registers[Integer.valueOf(params[1])].getValue());
	}
	@Override
	public void parse(String terms) throws Exception {
		if(terms.split(" ").length != 2) {
			throw new Exception();
		}
		
	}
}
