package commands;
import interfaces.AssertiveCommand;
import managers.RegisterManager;

public class Is0 implements AssertiveCommand {

	@Override
	public boolean action(String terms) {
		if(RegisterManager.registers[Integer.valueOf(terms)].getValue() == 0)
			return true;
		return false;
	}

}
