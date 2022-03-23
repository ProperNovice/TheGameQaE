package controllers;

import cards.CardNumber;
import enums.EPlayer;
import utils.ArrayList;
import utils.HashMap;
import utils.ListImageViewAbles;

public enum Players {

	INSTANCE;

	private HashMap<EPlayer, ListImageViewAbles<CardNumber>> playerLists = new HashMap<>();
	private ArrayList<EPlayer> playerOrder = new ArrayList<>();

	private Players() {

		this.playerLists.put(EPlayer.I, Lists.INSTANCE.handPlayerI);
		this.playerLists.put(EPlayer.II, Lists.INSTANCE.handPlayerII);

	}

	public void instantiate() {

		this.playerOrder.clear();

		this.playerOrder.addLast(EPlayer.I);

		if (Modifiers.INSTANCE.numberOfPlayers == 2)
			this.playerOrder.addLast(EPlayer.II);

	}

	public ListImageViewAbles<CardNumber> getPlayerCurrentHand() {
		return this.playerLists.getValue(this.playerOrder.getFirst());
	}

	public void changePlayerOrder() {
		this.playerOrder.addLast(this.playerOrder.removeFirst());
	}

	public EPlayer getPlayerCurrent() {
		return this.playerOrder.getFirst();
	}

	public ArrayList<ListImageViewAbles<CardNumber>> getPlayersHands() {

		ArrayList<ListImageViewAbles<CardNumber>> hands = new ArrayList<>();

		for (EPlayer ePlayer : this.playerOrder)
			hands.addLast(this.playerLists.getValue(ePlayer));

		return hands;

	}

}
