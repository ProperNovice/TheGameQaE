package cards;

import controllers.Credentials;
import enums.EColor;
import utils.Flow;
import utils.ImageView;
import utils.Logger;

public class CardNumber extends Card {

	private EColor eColor = null;
	private int number;

	public CardNumber(EColor eColor, int number) {

		this.eColor = eColor;
		this.number = number;

		String fileName = "cards/";
		fileName += this.eColor.getString() + "/";
		fileName += this.number;
		fileName += ".png";

		new ImageView(fileName, this);
		getImageView().setDimensions(Credentials.INSTANCE.dCard);
		getImageView().setBack("cards/back.jpg");
		getImageView().flipBack();

	}

	public EColor getEColor() {
		return this.eColor;
	}

	public int getNumber() {
		return this.number;
	}

	public void print() {

		Logger.INSTANCE.log("color: " + this.eColor.getString());
		Logger.INSTANCE.log("number: " + this.number);
		Logger.INSTANCE.newLine();

	}

	@Override
	public void handleMouseButtonPressedPrimary() {
		Flow.INSTANCE.getGameStateCurrent().handleCardNumberPressed(this);
	}

}
