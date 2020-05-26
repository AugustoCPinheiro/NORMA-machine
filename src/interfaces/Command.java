package interfaces;

public interface Command {

	public void action(String terms) ;
	public void parse(String terms)throws Exception;
}
