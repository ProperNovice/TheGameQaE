package controllers;

import cards.CardNumber;
import cards.CardSequence;
import enums.ESequence;
import utils.HashMap;
import utils.ListImageViewAbles;
import utils.SelectImageViewManager;

public enum Piles {

	INSTANCE;

	private HashMap<ESequence, ListImageViewAbles<CardNumber>> piles = new HashMap<>();
	private HashMap<ESequence, CardSequence> cardSequences = new HashMap<>();

	private Piles() {

		this.piles.put(ESequence.ASCENDING, Lists.INSTANCE.pileAscending);
		this.piles.put(ESequence.DESCENDING, Lists.INSTANCE.pileDescending);

	}

	public void setCardSequences(CardSequence ascending, CardSequence descending) {
		this.cardSequences.put(ESequence.ASCENDING, ascending);
		this.cardSequences.put(ESequence.DESCENDING, descending);
	}

	public ListImageViewAbles<CardNumber> getPileSequence(ESequence eSequence) {
		return this.piles.getValue(eSequence);
	}

	public void setPileSelected(ESequence eSequence) {
		SelectImageViewManager.INSTANCE
				.addSelectImageViewAble(this.cardSequences.getValue(eSequence));
	}

}
