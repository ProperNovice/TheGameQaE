package gui;

import controllers.Credentials;
import controllers.InstantiateComponents;
import controllers.Lists;
import gameStates.JUnit;
import gameStates.RestartGame;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import utils.Animation;
import utils.AnimationTimerFX;
import utils.Flow;
import utils.Interfaces.IUpdateAble;
import utils.Logger;
import utils.ObjectPool;
import utils.ShutDown;
import utils.Text;
import utils.Vector2;

public class TheGameQaE extends Application implements IUpdateAble {

	private Vector2 dimensionsInsets = new Vector2(16, 39);
	private double pixesOnTheLeft = 180;

	@Override
	public void start(Stage primaryStage) throws Exception {

		logJavaVersion();

		Panel panel = new Panel();

		double width = Credentials.INSTANCE.dFrame.x + this.dimensionsInsets.x;
		double height = Credentials.INSTANCE.dFrame.y + this.dimensionsInsets.y;

		Scene scene = new Scene(panel);
		setKeyPressed(scene);

		primaryStage.setScene(scene);
		primaryStage.setWidth(width);
		primaryStage.setHeight(height);
		primaryStage.setResizable(false);

		primaryStage.setTitle(Credentials.INSTANCE.primaryStageTitle);

		primaryStage.setX(
				(Screen.getPrimary().getBounds().getWidth() - width) / 2 - this.pixesOnTheLeft);
		primaryStage.setY((Screen.getPrimary().getBounds().getHeight() - height) / 2);

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				ShutDown.INSTANCE.execute();
			}

		});

		primaryStage.show();

		Lists.INSTANCE.instantiate();
		Text.INSTANCE.instantiate();
		InstantiateComponents.INSTANCE.instantiate();
		AnimationTimerFX.INSTANCE.updateNextFrame(this);

	}

	private void setKeyPressed(Scene scene) {

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				KeyCode keyCode = event.getCode();

				Logger.INSTANCE.logNewLine(keyCode + " key code pressed");

				if (keyCode.equals(KeyCode.ESCAPE))
					ShutDown.INSTANCE.execute();

				else if (Animation.INSTANCE.isAnimatingSynchronous())
					return;

				else if (keyCode.equals(KeyCode.BACK_QUOTE))
					Flow.INSTANCE.executeGameState(RestartGame.class);

				else if (keyCode.equals(KeyCode.O))
					ObjectPool.INSTANCE.print();

				else
					Flow.INSTANCE.getGameStateCurrent().executeKeyPressed(keyCode);

			}

		});

	}

	private void logJavaVersion() {

		Logger.INSTANCE.log("Java -> " + System.getProperty("java.version"));
		Logger.INSTANCE.log("JavaFX -> " + System.getProperty("javafx.version"));
		Logger.INSTANCE.newLine();

	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void update() {
		Flow.INSTANCE.executeGameState(JUnit.class);
	}

}
