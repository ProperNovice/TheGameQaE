package gameStates;

import cards.CardPlayableInPile;
import controllers.Modifiers;
import controllers.Piles;
import controllers.Players;
import enums.ESequence;
import enums.EText;
import utils.Flow;
import utils.SelectImageViewManager;

public class ChoosePileToPlay extends AGameState {

	@Override
	public void execute() {

		EText.CHOOSE_PILE.show();

		for (CardPlayableInPile cardPlayableInPile : Modifiers.INSTANCE.cardsPlayableInPiles) {

			if (!Modifiers.INSTANCE.cardNumberSelected.equals(cardPlayableInPile.getCardNumber()))
				continue;

			for (ESequence eSequence : cardPlayableInPile.getPiles())
				Piles.INSTANCE.setPileSelected(eSequence);

			break;

		}

	}

	@Override
	public void handlePilePressed(ESequence eSequence) {

		concealText();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		Players.INSTANCE.getPlayerCurrentHand().getArrayList()
				.remove(Modifiers.INSTANCE.cardNumberSelected);

		Piles.INSTANCE.getPileSequence(eSequence).getArrayList()
				.addLast(Modifiers.INSTANCE.cardNumberSelected);

		Piles.INSTANCE.getPileSequence(eSequence).relocateImageViews();

		Flow.INSTANCE.executeGameState(EndTurn.class);

	}

}
