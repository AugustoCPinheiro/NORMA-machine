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
	private static final String FUNC_MARKER = "endfun";
	private static final String IF_MARKER = "endif";
	private static final String WHILE_MARKER = "endwhile";
	public Reader(String file) {

		this.file = new File(file);

	}

	private ArrayList<Expression> readSubcode(BufferedReader br) throws IOException {
		String line = "";
		ArrayList<Expression> instructions = new ArrayList<Expression>();
		while ((line = br.readLine()) != null) {
			System.out.println("side - " + line);
			line = line.trim();
			if (!line.equals(FUNC_MARKER)) {
				
				String[] tokens = line.trim().split(" ");

				try {

					if (tokens[0].contains(":")) {

						FunctionsManager.functions.put(tokens[0].substring(line.indexOf(":") + 1), readSubcode(br));
						continue;
					}
					Expression expression = null;

					if (line.contains("while")) {
						String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);
						expression = new Expression(CommandFactory.getCommand(tokens[0]), String.join(" ", args),
								readWhileSubcode(br));

					} else {
						if (line.contains("if")) {
							String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);
							expression = new Expression(CommandFactory.getCommand(tokens[0]), String.join(" ", args),
									readIfSubcode(br));
						} else {
							String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);

							expression = new Expression(CommandFactory.getCommand(tokens[0]),
									String.join(" ", args));
						}
					}
					
					instructions.add(expression);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Malformed instructions");
				}

			} else {
				break;
			}
		}

		return instructions;
	}

	private ArrayList<Expression> readWhileSubcode(BufferedReader br) throws IOException {
		String line = "";
		ArrayList<Expression> instructions = new ArrayList<Expression>();
		while ((line = br.readLine()) != null) {
			System.out.println("sideWhile - " + line);
			line = line.trim();
			if (!line.equals(WHILE_MARKER)) {
				
				String[] tokens = line.trim().split(" ");

				try {
					if (tokens[0].contains(":")) {

						FunctionsManager.functions.put(tokens[0].substring(line.indexOf(":") + 1), readSubcode(br));
						continue;
					}
					Expression expression = null;

					if (line.contains("while")) {
						String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);
						expression = new Expression(CommandFactory.getCommand(tokens[0]), String.join(" ", args),
								readWhileSubcode(br));

					} else {
						if (line.contains("if")) {
							String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);
							expression = new Expression(CommandFactory.getCommand(tokens[0]), String.join(" ", args),
									readIfSubcode(br));
						} else {
							String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);

							expression = new Expression(CommandFactory.getCommand(tokens[0]),
									String.join(" ", args));
						}
					}

					

					instructions.add(expression);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Malformed instructions");
				}

			} else {
				break;
			}
		}
		return instructions;
	}
	private ArrayList<Expression> readElseSubcode(BufferedReader br) throws IOException {
		String line = "";
		ArrayList<Expression> instructions = new ArrayList<Expression>();
		while ((line = br.readLine()) != null) {
			System.out.println("sideWhile - " + line);
			line = line.trim();
			if (!line.equals(IF_MARKER)) {
				
				String[] tokens = line.trim().split(" ");

				try {

					if (tokens[0].contains(":")) {

						FunctionsManager.functions.put(tokens[0].substring(line.indexOf(":") + 1), readSubcode(br));
						continue;
					}
					Expression expression = null;

					if (line.contains("while")) {
						String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);
						expression = new Expression(CommandFactory.getCommand(tokens[0]), String.join(" ", args),
								readWhileSubcode(br));

					} else {
						if (line.contains("if")) {
							String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);
							expression = new Expression(CommandFactory.getCommand(tokens[0]), String.join(" ", args),
									readIfSubcode(br));
						} else {
							String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);

							expression = new Expression(CommandFactory.getCommand(tokens[0]),
									String.join(" ", args));
						}
					}
					instructions.add(expression);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Malformed instructions");
				}

			} else {
				break;
			}
		}
		return instructions;
	}
	
	private ArrayList<Expression> readIfSubcode(BufferedReader br) throws IOException {
		String line = "";
		ArrayList<Expression> instructions = new ArrayList<Expression>();
		while ((line = br.readLine()) != null) {
			System.out.println("sideIf - " + line);
			line = line.trim();
			if (!line.equals(IF_MARKER)) {
				
				String[] tokens = line.trim().split(" ");

				try {
					
					if(line.contains("else")) {
						String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);

						Expression expression = new Expression(CommandFactory.getCommand(tokens[0]),
								String.join(" ", args), readElseSubcode(br));

						instructions.add(expression);
						break;
					}
					if (tokens[0].contains(":")) {

						FunctionsManager.functions.put(tokens[0].substring(line.indexOf(":") + 1), readSubcode(br));
						continue;
					}
					Expression expression = null;

					if (line.contains("while")) {
						String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);
						expression = new Expression(CommandFactory.getCommand(tokens[0]), String.join(" ", args),
								readWhileSubcode(br));

					} else {
						if (line.contains("if")) {
							String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);
							expression = new Expression(CommandFactory.getCommand(tokens[0]), String.join(" ", args),
									readIfSubcode(br));
						} else {
							String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);

							expression = new Expression(CommandFactory.getCommand(tokens[0]),
									String.join(" ", args));
						}
					}

					instructions.add(expression);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Malformed instructions");
				}

			} else {
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
			while ((line = br.readLine()) != null) {
				System.out.println("main - " + line);
				if (!line.isEmpty()) {
					line = line.trim();
					String[] tokens = line.trim().split(" ");

					try {
						if (tokens[0].contains(":")) {

							FunctionsManager.functions.put(tokens[0].substring(line.indexOf(":") + 1), readSubcode(br));
							continue;
						}
						Expression expression = null;

						if (line.contains("while")) {
							String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);
							expression = new Expression(CommandFactory.getCommand(tokens[0]), String.join(" ", args),
									readWhileSubcode(br));

						} else {
							if (line.contains("if")) {
								String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);
								expression = new Expression(CommandFactory.getCommand(tokens[0]), String.join(" ", args),
										readIfSubcode(br));
							} else {
								String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);

								expression = new Expression(CommandFactory.getCommand(tokens[0]),
										String.join(" ", args));
							}
						}

						instructions.add(expression);
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Malformed instructions");
					}
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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
