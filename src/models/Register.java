package models;

public class Register {
	private int value;
	private String name;
	public Register(int registerNum)
	{
		value = 0;
		name = "R"+ registerNum;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Register [value=" + value + ", name=" + name + "]";
	}
	
	
}
