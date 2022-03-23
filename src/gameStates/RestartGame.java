package gameStates;

import cards.CardNumber;
import controllers.Lists;
import utils.Flow;
import utils.SelectImageViewManager;

public class RestartGame extends AGameState {

	@Override
	public void execute() {

		concealText();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		Lists.INSTANCE.loadLists();

		Lists.INSTANCE.deck.getArrayList().shuffle();
		Lists.INSTANCE.deck.relocateImageViews();

		for (CardNumber cardNumber : Lists.INSTANCE.deck)
			cardNumber.getImageView().flipBack();

		Flow.INSTANCE.executeGameState(StartGame.class);

	}

}
