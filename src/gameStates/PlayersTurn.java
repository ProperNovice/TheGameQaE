package gameStates;

import cards.CardNumber;
import cards.CardPlayableInPile;
import controllers.Modifiers;
import controllers.Piles;
import controllers.Players;
import enums.ESequence;
import utils.ArrayList;
import utils.Flow;
import utils.ListImageViewAbles;
import utils.Logger;

public class PlayersTurn extends AGameState {

	@Override
	public void execute() {

		Modifiers.INSTANCE.cardsPlayableInPiles.clear();

		ListImageViewAbles<CardNumber> list = Players.INSTANCE.getPlayerCurrentHand();

		for (CardNumber cardNumber : list)
			handleCardIsPlayable(cardNumber);

		if (!Modifiers.INSTANCE.cardsPlayableInPiles.isEmpty())
			Flow.INSTANCE.executeGameState(ChooseCardToPlay.class);
		else
			Flow.INSTANCE.executeGameState(EndGameLost.class);

	}

	private void handleCardIsPlayable(CardNumber cardNumberPlayer) {

		Logger.INSTANCE.logNewLine("/*");
		Logger.INSTANCE.log("checking card");
		cardNumberPlayer.print();

		ArrayList<ESequence> piles = new ArrayList<>();

		// pile ascending

		if (cardIsPlayableInPileAscending(cardNumberPlayer))
			piles.addLast(ESequence.ASCENDING);

		// pile descending

		Logger.INSTANCE.logNewLine("-");

		if (cardIsPlayableInPileDescending(cardNumberPlayer))
			piles.addLast(ESequence.DESCENDING);

		Logger.INSTANCE.logNewLine("*/");

		if (piles.isEmpty())
			return;

		Modifiers.INSTANCE.cardsPlayableInPiles
				.addLast(new CardPlayableInPile(cardNumberPlayer, piles));

	}

	private boolean cardIsPlayableInPileAscending(CardNumber cardNumberPlayer) {

		boolean canBeAdded = false;

		Logger.INSTANCE.logNewLine("pile ascending");

		ListImageViewAbles<CardNumber> pile = Piles.INSTANCE.getPileSequence(ESequence.ASCENDING);

		if (pile.getArrayList().isEmpty()) {

			Logger.INSTANCE.log("is empty");
			canBeAdded = true;

		}

		else {

			Logger.INSTANCE.logNewLine("is not empty");

			CardNumber cardNumberPile = pile.getArrayList().getLast();

			Logger.INSTANCE.log("last pile card");
			cardNumberPile.print();

			if (cardNumberPlayer.getEColor().equals(cardNumberPile.getEColor())) {

				Logger.INSTANCE.logNewLine("colors are the same");
				canBeAdded = true;

			} else {

				Logger.INSTANCE.logNewLine("colors are not the same");

				if (cardNumberPlayer.getNumber() > cardNumberPile.getNumber()) {

					Logger.INSTANCE.logNewLine("number is greater");
					canBeAdded = true;

				} else
					Logger.INSTANCE.logNewLine("number is lower");

			}
		}

		Logger.INSTANCE.logNewLine("can be added - " + canBeAdded);
		return canBeAdded;

	}

	private boolean cardIsPlayableInPileDescending(CardNumber cardNumberPlayer) {

		boolean canBeAdded = false;

		Logger.INSTANCE.logNewLine("pile descending");

		ListImageViewAbles<CardNumber> pile = Piles.INSTANCE.getPileSequence(ESequence.DESCENDING);

		if (pile.getArrayList().isEmpty()) {

			Logger.INSTANCE.log("is empty");
			canBeAdded = true;

		}

		else {

			Logger.INSTANCE.logNewLine("is not empty");

			CardNumber cardNumberPile = pile.getArrayList().getLast();

			Logger.INSTANCE.log("last pile card");
			cardNumberPile.print();

			if (cardNumberPlayer.getEColor().equals(cardNumberPile.getEColor())) {

				Logger.INSTANCE.logNewLine("colors are the same");
				canBeAdded = true;

			} else {

				Logger.INSTANCE.logNewLine("colors are not the same");

				if (cardNumberPlayer.getNumber() < cardNumberPile.getNumber()) {

					Logger.INSTANCE.logNewLine("number is lower");
					canBeAdded = true;

				} else
					Logger.INSTANCE.logNewLine("number is greater");

			}
		}

		Logger.INSTANCE.logNewLine("can be added - " + canBeAdded);
		return canBeAdded;

	}

}
