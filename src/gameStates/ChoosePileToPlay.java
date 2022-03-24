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

		for (ESequence eSequence : Modifiers.INSTANCE.cardsPlayableInPiles.getFirst().getPiles())
			Piles.INSTANCE.setPileSelected(eSequence);

	}

	@Override
	public void handlePilePressed(ESequence eSequence) {

		CardPlayableInPile cardPlayableInPile = Modifiers.INSTANCE.cardsPlayableInPiles.getFirst();

		boolean eSequenceIsValid = false;

		for (ESequence eSequenceTemp : cardPlayableInPile.getPiles())
			if (eSequenceTemp.equals(eSequence))
				eSequenceIsValid = true;

		if (!eSequenceIsValid)
			return;

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
