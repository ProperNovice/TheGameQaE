package cards;

import controllers.Credentials;
import enums.EColor;
import utils.ImageView;

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

}
