package gameStates;

import cards.CardNumber;
import cards.CardPlayableInPile;
import controllers.Modifiers;
import enums.EText;
import utils.Flow;
import utils.Logger;
import utils.SelectImageViewManager;

public class ChooseCardToPlay extends AGameState {

	@Override
	public void execute() {

		EText.CHOOSE_CARD.show();

		for (CardPlayableInPile cardPlayableInPile : Modifiers.INSTANCE.cardsPlayableInPiles)
			SelectImageViewManager.INSTANCE
					.addSelectImageViewAble(cardPlayableInPile.getCardNumber());

	}

	@Override
	protected void handleCardNumberPressedCurrentPlayer(CardNumber cardNumber) {

		if (!SelectImageViewManager.INSTANCE.isSelectedImageViewAble(cardNumber))
			return;

		concealText();

		Modifiers.INSTANCE.cardNumberSelected = cardNumber;
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		Logger.INSTANCE.log("card chosen");
		cardNumber.print();

		Flow.INSTANCE.executeGameState(ChoosePileToPlay.class);

	}

}
