package controllers;

import utils.ArrayList;
import utils.Enums.RearrangeTypeEnum;
import utils.SelectImageView;
import utils.Vector2;

public enum Credentials {

	INSTANCE;

	public final String primaryStageTitle = "The Game: Quick and Easy";
	public final boolean colliderVisibility = true;
	public final double gapBetweenBorders = 25, textHeight = 50,
			selectImageViewAbleRatioDimensions = 0.5, selectImageViewAbleRatioCoordinateX = 0.5,
			selectImageViewAbleRatioCoordinateY = 0.25, selectEventHandlerAbleWidth = 100,
			animationStep = 4;
	public ArrayList<Class<?>> lineCastExcludeList = new ArrayList<Class<?>>();
	public RearrangeTypeEnum rearrangeTypeEnumText = RearrangeTypeEnum.PIVOT;
	public Vector2 dFrame, dGapBetweenComponents, dGapBetweenComponentsLineCast, dCard;
	public Vector2 cTextPanel, cHandPlayerI, cHandPlayerII, cPileAscending, cPileDescending, cDeck;
	private Vector2 dCardOriginal;

	private Credentials() {

		this.lineCastExcludeList.addLast(SelectImageView.class);

		double x = 0, y = 0;

		this.dFrame = new Vector2(1920, 1080);
		this.dGapBetweenComponents = new Vector2(8, 8);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		this.cTextPanel = new Vector2(x, y);

		this.dCardOriginal = new Vector2(255, 400);

		// card height

		y = this.dFrame.y;
		y -= 2 * this.gapBetweenBorders;
		y -= 2 * this.dGapBetweenComponents.y;
		y /= 3;

		x = this.dCardOriginal.x * y / this.dCardOriginal.y;
		this.dCard = new Vector2(x, y);

		// frame

		y = 1080;
		x = 4 * this.dCard.x;
		x += 5 * this.dGapBetweenComponents.x;
		x += 4 * this.gapBetweenBorders;
//		x = 1920;
		this.dFrame = new Vector2(x, y);

		// hand player I

		x = this.dFrame.x / 2;
		y = this.dFrame.y;
		y -= this.gapBetweenBorders;
		y -= this.dCard.y / 2;
		this.cHandPlayerI = new Vector2(x, y);

		// hand player II

		x = this.dFrame.x / 2;
		y = this.gapBetweenBorders;
		y += this.dCard.y / 2;
		this.cHandPlayerII = new Vector2(x, y);

		// pile ascending

		x = this.dFrame.x / 2;
		x -= this.dGapBetweenComponents.x / 2;
		x -= this.dCard.x / 2;
		y = this.dFrame.y / 2;
		this.cPileAscending = new Vector2(x, y);

		// pile descending

		x = this.dFrame.x / 2;
		x += this.dGapBetweenComponents.x / 2;
		x += this.dCard.x / 2;
		y = this.dFrame.y / 2;
		this.cPileDescending = new Vector2(x, y);

		// deck

		x = this.cPileAscending.x;
		x -= this.dGapBetweenComponents.x * 2;
		x -= this.dCard.x;
		y = this.dFrame.y / 2;
		this.cDeck = new Vector2(x, y);

		// text panel

		x = this.dFrame.x / 2;
		x += this.dCard.x;
		x += this.dGapBetweenComponents.x * 3 / 2;
		y = this.dFrame.y / 2;
		this.cTextPanel = new Vector2(x, y);

	}

}
