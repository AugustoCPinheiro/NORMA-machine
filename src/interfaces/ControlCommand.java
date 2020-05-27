package interfaces;

import java.util.ArrayList;

import models.Expression;

public interface ControlCommand extends Command {
	public abstract void postAction(String terms, ArrayList<Expression> expressions);
}
