package gameStates;

import cards.CardNumber;
import controllers.Lists;
import controllers.Players;
import enums.EColor;
import utils.Flow;

public class JUnit extends AGameState {

	private boolean run = true;

	@Override
	public void execute() {

		if (!this.run)
			return;

		Players.INSTANCE.instantiate();

		addCardsToPlayerI();
		addCardsToPlayerII();
		addCardsToPileAscending();
		addCardsToPileDescending();
		
		Flow.INSTANCE.executeGameState(PlayersTurn.class);

	}

	public void addCardsToPlayerI() {

		Lists.INSTANCE.handPlayerI.getArrayList().addLast(removeCardFromDeck(EColor.BLUE, 6));
		Lists.INSTANCE.handPlayerI.getArrayList().addLast(removeCardFromDeck(EColor.RED, 5));

		Lists.INSTANCE.handPlayerI.relocateImageViews();

	}

	public void addCardsToPlayerII() {

		Lists.INSTANCE.handPlayerII.getArrayList().addLast(removeCardFromDeck(EColor.BLUE, 5));
		Lists.INSTANCE.handPlayerII.getArrayList().addLast(removeCardFromDeck(EColor.RED, 4));

		Lists.INSTANCE.handPlayerII.relocateImageViews();

	}

	public void addCardsToPileAscending() {

//		Lists.INSTANCE.pileAscending.getArrayList().addLast(removeCardFromDeck(EColor.GRAY, 8));
		Lists.INSTANCE.pileAscending.getArrayList().addLast(removeCardFromDeck(EColor.GRAY, 7));

		Lists.INSTANCE.pileAscending.relocateImageViews();

	}

	public void addCardsToPileDescending() {

//		Lists.INSTANCE.pileDescending.getArrayList().addLast(removeCardFromDeck(EColor.RED, 2));
		Lists.INSTANCE.pileDescending.getArrayList().addLast(removeCardFromDeck(EColor.BLUE, 3));

		Lists.INSTANCE.pileDescending.relocateImageViews();

	}

	public CardNumber removeCardFromDeck(EColor eColor, int number) {

		CardNumber cardNumber = null;

		for (CardNumber cardNumberTemp : Lists.INSTANCE.deck.getArrayList())
			if (cardNumberTemp.getEColor().equals(eColor))
				if (cardNumberTemp.getNumber() == number)
					cardNumber = cardNumberTemp;

		Lists.INSTANCE.deck.getArrayList().remove(cardNumber);

		cardNumber.getImageView().flip();

		return cardNumber;

	}

}
