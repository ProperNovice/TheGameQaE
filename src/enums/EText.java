package enums;

import utils.Enums.TextTypeEnum;
import utils.Text;

public enum EText {

	CONTINUE("Continue", TextTypeEnum.OPTION),
	RESTART("Restart", TextTypeEnum.OPTION),
	YOU_WON("You won", TextTypeEnum.INDICATOR),
	YOU_LOST("You lost", TextTypeEnum.INDICATOR),
	START_GAME("Start game", TextTypeEnum.OPTION),
	DEAL_NEW_HANDS("Deal new hands", TextTypeEnum.OPTION),
	CHOOSE_CARD("Choose card", TextTypeEnum.INDICATOR),
	CHOOSE_PILE("Choose pile", TextTypeEnum.INDICATOR),
	CHOOSE_PLAYERS("Choose players", TextTypeEnum.INDICATOR),
	ONE("One", TextTypeEnum.OPTION),
	TWO("Two", TextTypeEnum.OPTION),
	
	;

	private TextTypeEnum textTypeEnum = null;
	private String string = null;

	private EText(String string, TextTypeEnum textTypeEnum) {

		this.string = string;
		this.textTypeEnum = textTypeEnum;

	}

	public void show() {
		Text.INSTANCE.showText(this, getString());
	}

	public void showAdditionally(String string) {
		Text.INSTANCE.showText(this, getString() + string);
	}

	public void showInstead(String string) {
		Text.INSTANCE.showText(this, string);
	}

	public String getString() {
		return this.string;
	}

	public TextTypeEnum getTextTypeEnum() {
		return this.textTypeEnum;
	}

}
