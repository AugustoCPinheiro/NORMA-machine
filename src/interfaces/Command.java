package interfaces;

import java.util.ArrayList;

import models.Expression;

public interface Command {
	public void action(String terms, ArrayList<Expression> expressions);

	public void parse(String terms) throws Exception;
}
