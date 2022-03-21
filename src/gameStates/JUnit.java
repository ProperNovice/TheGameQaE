package gameStates;

import cards.CardNumber;
import controllers.Lists;
import enums.EColor;

public class JUnit extends AGameState {

	@Override
	public void execute() {

		Lists.INSTANCE.deck.getArrayList().shuffle();
		Lists.INSTANCE.deck.relocateImageViews();

		addCardsToPlayerI();
		addCardsToPlayerII();

	}

	private void addCardsToPlayerI() {

		Lists.INSTANCE.handPlayerI.getArrayList().addLast(removeCardFromDeck(EColor.BLUE, 4));
		Lists.INSTANCE.handPlayerI.getArrayList().addLast(removeCardFromDeck(EColor.GRAY, 10));

		Lists.INSTANCE.handPlayerI.relocateImageViews();

	}

	private void addCardsToPlayerII() {

		Lists.INSTANCE.handPlayerII.getArrayList().addLast(removeCardFromDeck(EColor.BLUE, 5));
		Lists.INSTANCE.handPlayerII.getArrayList().addLast(removeCardFromDeck(EColor.YELLOW, 1));

		Lists.INSTANCE.handPlayerII.relocateImageViews();

	}

	private CardNumber removeCardFromDeck(EColor eColor, int number) {

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
