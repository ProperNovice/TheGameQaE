package utils;

import controllers.Credentials;
import enums.EText;
import utils.Enums.TextTypeEnum;

public enum Text {

	INSTANCE;

	private ArrayList<TextEnum> textEnum = new ArrayList<>();
	private ArrayList<TextEnum> textEnumShowing = new ArrayList<>();

	private Text() {

	}

	public void instantiate() {

		for (EText eText : EText.values())
			this.textEnum.addLast(new TextEnum(eText));

	}

	public void showText(EText eText, String text) {

		for (TextEnum textEnum : this.textEnum) {

			if (!textEnum.getEText().equals(eText))
				continue;

			textEnum.getText().setText(text);
			this.textEnumShowing.addLast(textEnum);
			break;

		}

		showText();

	}

	private void showText() {

		for (TextEnum textEnum : this.textEnumShowing) {

			textEnum.toFront();
			textEnum.setVisible(true);

			double x = Credentials.INSTANCE.cTextPanel.x;
			double y = Credentials.INSTANCE.cTextPanel.y;
			y += Credentials.INSTANCE.textHeight * this.textEnumShowing.indexOf(textEnum);

			textEnum.relocate(x, y);

		}

	}

	public void concealText() {

		for (TextEnum textEnum : this.textEnumShowing)
			textEnum.setVisible(false);

		this.textEnumShowing.clear();

	}

	public EText getTextEnumOptionPressed(int textOptionID) {

		ArrayList<TextEnum> textEnumOptionShowing = this.textEnumShowing.clone();

		for (TextEnum textGame : textEnumOptionShowing.clone())
			if (textGame.getEText().getTextTypeEnum().equals(TextTypeEnum.INDICATOR))
				textEnumOptionShowing.remove(textGame);

		if (textOptionID >= textEnumOptionShowing.size())
			return null;
		else
			return textEnumOptionShowing.get(textOptionID).getEText();

	}

}
