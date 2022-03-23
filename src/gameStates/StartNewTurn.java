package gameStates;

import cards.CardNumber;
import controllers.Lists;
import controllers.Modifiers;
import controllers.Players;
import utils.Flow;

public class StartNewTurn extends AGameState {

	@Override
	public void execute() {

		boolean youWon = false;

		if (Lists.INSTANCE.deck.getArrayList().isEmpty())
			if (Lists.INSTANCE.handPlayerI.getArrayList().isEmpty())
				if (Modifiers.INSTANCE.numberOfPlayers == 1)
					youWon = true;
				else if (Modifiers.INSTANCE.numberOfPlayers == 2)
					if (Lists.INSTANCE.handPlayerII.getArrayList().isEmpty())
						youWon = true;

		if (youWon) {

			Flow.INSTANCE.executeGameState(EndGameWon.class);
			return;

		}

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
