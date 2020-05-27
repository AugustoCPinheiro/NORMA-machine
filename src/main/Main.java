package main;

import java.util.ArrayList;

import managers.RegisterManager;
import models.Expression;
import models.Register;
import util.Reader;

public class Main {

	public static void main(String[] args) {
		Register[] registers = new Register[64];
		Reader reader = new Reader("instructions.ad");

		for (int i = 0; i < 64; i++) {
			RegisterManager.registers[i] = new Register(i);
		}
		ArrayList<Expression> instructions = reader.loadInstructions();
		for (Expression expression : instructions) {
			expression.getCommand().action(expression.getTerms(), expression.getExpressions());
		}

		for (Register register : RegisterManager.registers) {
			System.out.println(register);
		}
	}

}
