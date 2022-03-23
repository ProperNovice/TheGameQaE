package cards;

import utils.ArrayList;
import utils.ListImageViewAbles;

public class CardPlayableInPile {

	private CardNumber cardNumber = null;
	private ArrayList<ListImageViewAbles<CardNumber>> piles = new ArrayList<>();

	public CardPlayableInPile(CardNumber cardNumber,
			ArrayList<ListImageViewAbles<CardNumber>> piles) {

		this.cardNumber = cardNumber;
		this.piles.addAll(piles);

	}

	public CardNumber getCardNumber() {
		return this.cardNumber;
	}

	public ArrayList<ListImageViewAbles<CardNumber>> getPiles() {
		return this.piles;
	}

}
