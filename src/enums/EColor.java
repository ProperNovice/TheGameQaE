package enums;

public enum EColor {

	BLUE("blue"), GRAY("gray"), GREEN("green"), RED("red"), YELLOW("yellow");

	private String string = null;

	private EColor(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}

}
