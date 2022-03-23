package gameStates;

import controllers.Players;
import enums.EText;
import utils.Flow;

public class StartGame extends AGameState {

	@Override
	public void execute() {

		Players.INSTANCE.instantiate();
		EText.START_GAME.show();

	}

	@Override
	protected void executeTextOption(EText eText) {
		Flow.INSTANCE.executeGameState(DealNewHands.class);
	}

}
