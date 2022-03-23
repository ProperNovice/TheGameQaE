package gameStates;

import cards.CardNumber;
import controllers.Lists;
import controllers.Players;
import utils.Flow;

public class StartNewTurn extends AGameState {

	@Override
	public void execute() {

		if (!Lists.INSTANCE.deck.getArrayList().isEmpty())
			drawCard();

		Players.INSTANCE.changePlayerOrder();
		Flow.INSTANCE.executeGameState(PlayersTurn.class);

	}

	private void drawCard() {

		CardNumber cardNumber = Lists.INSTANCE.deck.getArrayList().removeFirst();
		cardNumber.getImageView().flip();

		Players.INSTANCE.getPlayerCurrentHand().getArrayList().addLast(cardNumber);
		Players.INSTANCE.getPlayerCurrentHand().relocateImageViews();

	}

}
