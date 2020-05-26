package util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

import factories.CommandFactory;
import managers.FunctionsManager;
import models.Expression;



public class Reader {
	private File file;
	
	public Reader(String file) {
	
		this.file = new File(file);
		
	}
	private ArrayList<Expression> readSubcode(BufferedReader br) throws IOException{
		String line = "";
		ArrayList<Expression> instructions = new ArrayList<Expression>();
		while((line = br.readLine()) != null) {
			if(!line.equals("\\")) {
				String[] tokens = line.trim().split(" ");
//				System.out.println(tokens[0]);
				
				try {
					
					String [] args = Arrays.copyOfRange(tokens, 1, tokens.length);
					
					Expression expression = new Expression(CommandFactory.getCommand(tokens[0]),  String.join(" ", args));
					System.out.println(expression);
					instructions.add(expression);
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Malformed instructions");
			}

		}else {
			break;
		}
	}
	
		return instructions;
	}
	
	public ArrayList<Expression> loadInstructions() {
		FileReader r = null;
		BufferedReader br = null;
		ArrayList<Expression> instructions = new ArrayList<Expression>();
		try {
			r = new FileReader(file);
			br = new BufferedReader(r);
			
			String line = "";
			while((line = br.readLine()) != null) {
				
				if(!line.isEmpty()){
					String[] tokens = line.trim().split(" ");
//					System.out.println(tokens[0]);
					
					try {
						if(tokens[0].contains(":")) {
						
							FunctionsManager.functions.put(tokens[0].substring(line.indexOf(":") + 1), readSubcode(br));
							continue;
						}
						String [] args = Arrays.copyOfRange(tokens, 1, tokens.length);
						
						Expression expression = new Expression(CommandFactory.getCommand(tokens[0]),  String.join(" ", args));
						instructions.add(expression);
					}catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Malformed instructions");
					}
				}
			
			}
			
		}catch(IOException e) {	
			e.printStackTrace();
		}finally {
			try {
				br.close();
				r.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instructions;
	}
}
