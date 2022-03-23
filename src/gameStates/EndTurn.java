package gameStates;

import utils.Flow;

public class EndTurn extends AGameState {

	@Override
	public void execute() {

		Flow.INSTANCE.executeGameState(StartNewTurn.class);

	}

}
