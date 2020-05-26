package factories;
import commands.Add;
import commands.Dec;
import commands.Goto;
import commands.Inc;
import commands.Set;
import commands.Set0;
import interfaces.Command;

public class CommandFactory {

	public static Command getCommand(String command) {
		
		switch(command) {
		case "inc": return new Inc();
		case "add": return new Add();
		case "set": return new Set();
		case "dec": return new Dec();
		case "set0": return new Set0();
		case "goto": return new Goto();
		default: {
			
			return null;}
		}
		
	}
}
