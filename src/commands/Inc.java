package commands;
import interfaces.Command;
import managers.RegisterManager;

public class Inc implements Command{
	@Override
	public void action(String terms) {
//			try {
//				parse(terms);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
		RegisterManager.registers[Integer.parseInt(terms.trim())].setValue(RegisterManager.registers[Integer.parseInt(terms.trim())].getValue() + 1);
	}
	@Override
	public void parse(String terms) throws Exception {
		System.out.println(terms);
		if(terms.trim().length() > 1) {
			throw new Exception();
		}
		
	}

}
