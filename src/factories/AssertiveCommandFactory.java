package factories;

import commands.Is0;
import interfaces.AssertiveCommand;

public class AssertiveCommandFactory {
	public static AssertiveCommand getCommand(String command) {
		switch(command) {
		case "is0": return new Is0();
		default: return null;
		}
		
	}
}
