package gameStates;

import cards.CardNumber;
import controllers.Players;
import enums.EText;
import javafx.scene.input.KeyCode;
import utils.KeyCodeHandler;
import utils.Logger;
import utils.Text;

public abstract class AGameState {

	public abstract void execute();

	public final void handleTextOptionPressed(EText textEnum) {

		Logger.INSTANCE.log("text option executing");
		Logger.INSTANCE.logNewLine(textEnum);

		concealText();
		executeTextOption(textEnum);

	}

	public final void executeKeyPressed(KeyCode keyCode) {

		int keyCodeID = KeyCodeHandler.INSTANCE.getKeyCodeInt(keyCode);

		if (keyCodeID == -1)
			return;

		EText textEnumPressed = Text.INSTANCE.getTextEnumOptionPressed(keyCodeID);

		if (textEnumPressed == null)
			return;

		Logger.INSTANCE.log("executing key pressed -> " + keyCode);
		handleTextOptionPressed(textEnumPressed);

	}

	protected void executeTextOption(EText eText) {

	}

	protected final void concealText() {
		Text.INSTANCE.concealText();
	}

	public final void handleCardNumberPressed(CardNumber cardNumber) {

		if (Players.INSTANCE.getPlayerCurrentHand().getArrayList().contains(cardNumber))
			handleCardNumberPressedCurrentPlayer(cardNumber);

	}

	protected void handleCardNumberPressedCurrentPlayer(CardNumber cardNumber) {

	}

}
