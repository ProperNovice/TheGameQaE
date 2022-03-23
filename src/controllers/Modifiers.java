package controllers;

import cards.CardNumber;
import cards.CardPlayableInPile;
import utils.ArrayList;
import utils.Interfaces.ISaveLoadStateAble;

public enum Modifiers implements ISaveLoadStateAble {

	INSTANCE;

	public ArrayList<CardPlayableInPile> cardsPlayableInPiles = new ArrayList<>();
	public CardNumber cardNumberSelected = null;
	public int numberOfPlayers = -1;

	private Modifiers() {
		saveOriginal();
	}

	@Override
	public void saveOriginal() {
		loadOriginal();
	}

	@Override
	public void loadOriginal() {

	}

	@Override
	public void saveState() {

	}

	@Override
	public void loadState() {

	}

}
