package gameStates;

import cards.CardNumber;
import controllers.Model;
import controllers.Players;
import enums.EText;
import utils.Flow;
import utils.ListImageViewAbles;

public class DealNewHands extends AGameState {

	@Override
	public void execute() {
		EText.DEAL_NEW_HANDS.show();
	}

	@Override
	protected void executeTextOption(EText eText) {

		for (ListImageViewAbles<CardNumber> list : Players.INSTANCE.getPlayersHands())
			Model.INSTANCE.refillHandRelocate(list);

		Flow.INSTANCE.executeGameState(PlayersTurn.class);

	}

}
