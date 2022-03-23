package cards;

import enums.ESequence;
import utils.ArrayList;

public class CardPlayableInPile {

	private CardNumber cardNumber = null;
	private ArrayList<ESequence> eSequencePiles = new ArrayList<>();

	public CardPlayableInPile(CardNumber cardNumber, ArrayList<ESequence> eSequencePiles) {

		this.cardNumber = cardNumber;
		this.eSequencePiles.addAll(eSequencePiles);

	}

	public CardNumber getCardNumber() {
		return this.cardNumber;
	}

	public ArrayList<ESequence> getPiles() {
		return this.eSequencePiles;
	}

}
