package factories;

import commands.Add;
import commands.Dec;
import commands.Else;
import commands.Goto;
import commands.If;
import commands.Inc;
import commands.Init;
import commands.Set;
import commands.Set0;
import commands.While;
import interfaces.Command;

public class CommandFactory {

	public static Command getCommand(String command) {

		switch (command) {
		case "inc":
			return new Inc();
		case "add":
			return new Add();
		case "set":
			return new Set();
		case "dec":
			return new Dec();
		case "set0":
			return new Set0();
		case "goto":
			return new Goto();
		case "while":
			return new While();
		case "else":
			return new Else();
		case "if":
			return new If();
		case "init":
			return new Init();
		default: {

			return null;
		}
		}

	}
}
