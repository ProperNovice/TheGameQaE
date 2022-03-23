package gameStates;

import controllers.Lists;
import controllers.Players;
import enums.EText;
import utils.Flow;

public class StartGame extends AGameState {

	@Override
	public void execute() {

		EText.CHOOSE_PLAYERS.show();
		EText.ONE.show();
		EText.TWO.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		int numberOfPlayers = -1;

		if (eText.equals(EText.ONE)) {

			numberOfPlayers = 1;
			Lists.INSTANCE.handPlayerI.getArrayList().setCapacity(3);

		}

		else if (eText.equals(EText.TWO)) {

			numberOfPlayers = 2;
			Lists.INSTANCE.handPlayerI.getArrayList().setCapacity(2);

		}

		Players.INSTANCE.instantiate(numberOfPlayers);

		Flow.INSTANCE.executeGameState(DealNewHands.class);

	}

}
