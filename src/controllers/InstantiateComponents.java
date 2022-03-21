package controllers;

import cards.CardNumber;
import cards.CardSequence;
import enums.EColor;
import enums.ESequence;
import utils.Logger;
import utils.MapImageViews;

public enum InstantiateComponents {

	INSTANCE;

	public void instantiate() {

		createCardsSequence();
		createCardsNumber();

		Lists.INSTANCE.deck.getArrayList().shuffle();
		Lists.INSTANCE.deck.relocateImageViews();

		Logger.INSTANCE.logNewLine("components instantiated -> "
				+ (MapImageViews.INSTANCE.getImageViewsMap().size() - 1));

	}

	private void createCardsSequence() {

		new CardSequence(ESequence.ASCENDING);
		new CardSequence(ESequence.DESCENDING);

	}

	private void createCardsNumber() {

		for (EColor eColor : EColor.values())
			for (int counter = 1; counter <= 10; counter++)
				Lists.INSTANCE.deck.getArrayList().addLast(new CardNumber(eColor, counter));

	}

}
