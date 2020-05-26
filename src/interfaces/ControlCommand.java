package interfaces;
import models.Expression;

public interface ControlCommand extends Command {
	public void postAction(Expression[] expressions);
}
