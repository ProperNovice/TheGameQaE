package gameStates;

import cards.CardNumber;
import cards.CardPlayableInPile;
import controllers.Modifiers;
import enums.EText;
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

//		if (!SelectImageViewManager.INSTANCE.isSelectedImageViewAble(cardNumber))
//			return;
		
		cardNumber.reverseSelectImageView();

	}

}
