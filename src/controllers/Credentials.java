package controllers;

import utils.ArrayList;
import utils.SelectImageView;
import utils.Vector2;

public enum Credentials {

	INSTANCE;

	public final String primaryStageTitle = "JavaFX";
	public final boolean colliderVisibility = true;
	public final double gapBetweenBorders = 25, textHeight = 50,
			selectImageViewAbleRatioDimensions = 0.5, selectImageViewAbleRatioCoordinateX = 0.5,
			selectImageViewAbleRatioCoordinateY = 0.5, selectEventHandlerAbleWidth = 100,
			animationStep = 4;
	public ArrayList<Class<?>> lineCastExcludeList = new ArrayList<Class<?>>();
	public Vector2 dFrame, dGapBetweenComponents, dGapBetweenComponentsLineCast;
	public Vector2 cTextPanel;

	private Credentials() {

		this.lineCastExcludeList.addLast(SelectImageView.class);

		double x = 0, y = 0;

		this.dFrame = new Vector2(1920, 1080);
		this.dGapBetweenComponents = new Vector2(4, 4);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		this.cTextPanel = new Vector2(x, y);

	}

}
