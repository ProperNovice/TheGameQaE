package controllers;

import cards.CardNumber;
import enums.ESequence;
import utils.HashMap;
import utils.ListImageViewAbles;

public enum Piles {

	INSTANCE;

	private HashMap<ESequence, ListImageViewAbles<CardNumber>> piles = new HashMap<>();

	private Piles() {

		this.piles.put(ESequence.ASCENDING, Lists.INSTANCE.pileAscending);
		this.piles.put(ESequence.DESCENDING, Lists.INSTANCE.pileDescending);

	}

	public ListImageViewAbles<CardNumber> getPile(ESequence eSequence) {
		return this.piles.getValue(eSequence);
	}

}
