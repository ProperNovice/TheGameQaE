package gameStates;

import cards.CardNumber;
import controllers.Model;
import controllers.Players;
import utils.Flow;
import utils.ListImageViewAbles;

public class DealNewHands extends AGameState {

	@Override
	public void execute() {

		for (ListImageViewAbles<CardNumber> list : Players.INSTANCE.getPlayersHands())
			Model.INSTANCE.refillHandRelocate(list);

		Flow.INSTANCE.executeGameState(PlayersTurn.class);

	}

}
