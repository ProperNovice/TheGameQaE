package enums;

public enum ESequence {

	ASCENDING("ascending"), DESCENDING("descending");

	public String string = null;

	private ESequence(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}

}
