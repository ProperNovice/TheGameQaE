package cards;

import controllers.Credentials;
import enums.ELayerZ;
import enums.ESequence;
import utils.ImageView;
import utils.Vector2;

public class CardSequence extends Card {

	public CardSequence(ESequence eSequence) {

		String fileName = "cards/";
		fileName += eSequence.getString();
		fileName += ".jpg";

		new ImageView(fileName, ELayerZ.CARD_SEQUENCE, this);
		getImageView().setDimensions(Credentials.INSTANCE.dCard);

		Vector2 coordinates = null;

		switch (eSequence) {

		case ASCENDING:
			coordinates = Credentials.INSTANCE.cPileAscending;
			break;

		case DESCENDING:
			coordinates = Credentials.INSTANCE.cPileDescending;
			break;

		}

		getImageView().relocateCenter(coordinates);

	}

}
