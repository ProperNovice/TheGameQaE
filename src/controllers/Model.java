package controllers;

import cards.CardNumber;
import utils.ListImageViewAbles;

public enum Model {

	INSTANCE;

	public void refillHandRelocate(ListImageViewAbles<CardNumber> list) {

		while (!list.getArrayList().isMaxedCapacity()) {

			CardNumber cardNumber = Lists.INSTANCE.deck.getArrayList().removeFirst();
			cardNumber.getImageView().flip();
			list.getArrayList().addLast(cardNumber);

		}

		list.relocateImageViews();

	}

}
