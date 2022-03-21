package utils;

import controllers.Credentials;
import utils.Enums.DirectionEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.Interfaces.IImageViewAble;

public class CoordinatesList {

	private Vector2 coordinatesList, dimensions, gap;
	private int objectsPerRow;
	private double firstObjectX, firstObjectY;
	private RearrangeTypeEnum rearrangeTypeEnum;
	private DirectionEnum directionEnumHorizontal, directionEnumVertical;
	private RelocateTypeEnum relocateTypeEnum = null;
	private ArrayList<? extends Object> list = null;

	public CoordinatesList(Vector2 coordinatesList, Vector2 dimensions, Vector2 gap,
			int objectsPerRow, RearrangeTypeEnum rearrangeTypeEnum,
			DirectionEnum directionEnumHorizontal, DirectionEnum directionEnumVertical,
			RelocateTypeEnum relocateTypeEnum) {

		this.coordinatesList = coordinatesList;
		this.dimensions = dimensions;
		this.gap = gap;
		this.objectsPerRow = objectsPerRow;
		this.rearrangeTypeEnum = rearrangeTypeEnum;
		this.directionEnumHorizontal = directionEnumHorizontal;
		this.directionEnumVertical = directionEnumVertical;
		this.relocateTypeEnum = relocateTypeEnum;

	}

	public Vector2 getCoordinate(int index) {

		if (this.list != null && !this.list.isEmpty()) {

			IImageViewAble imageViewAble = (IImageViewAble) this.list.getFirst();

			this.dimensions.x = imageViewAble.getImageView().getWidth();
			this.dimensions.y = imageViewAble.getImageView().getHeight();

		}

		switch (this.rearrangeTypeEnum) {

		case LINEAR:
			this.firstObjectX = this.coordinatesList.x;
			this.firstObjectY = this.coordinatesList.y;
			break;

		case PIVOT:
			calculateFirstObjectCoordinatesPivot();
			break;

		case STATIC:
			return new Vector2(this.coordinatesList.x, this.coordinatesList.y);

		}

		double coordinateX = 0, coordinateY = 0;

		int row, column;

		if (this.objectsPerRow == -1) {

			row = 0;
			column = index;

		} else {

			row = index / this.objectsPerRow;
			column = index - row * this.objectsPerRow;

		}

		double x, y;

		if (this.gap.x == Credentials.INSTANCE.dGapBetweenComponents.x)
			x = column * (this.dimensions.x + this.gap.x);
		else
			x = column * this.gap.x;

		if (this.gap.y == Credentials.INSTANCE.dGapBetweenComponents.y)
			y = row * (this.dimensions.y + this.gap.y);
		else
			y = row * this.gap.y;

		switch (this.directionEnumHorizontal) {

		case RIGHT:
			coordinateX = this.firstObjectX + x;
			break;

		case LEFT:
			coordinateX = this.firstObjectX - x;
			break;

		default:
			logErrorShutDown(this.directionEnumHorizontal);
			break;

		}

		switch (this.directionEnumVertical) {

		case DOWN:
			coordinateY = this.firstObjectY + y;
			break;

		case UP:
			coordinateY = this.firstObjectY - y;
			break;

		default:
			logErrorShutDown(this.directionEnumVertical);
			break;

		}

		switch (this.relocateTypeEnum) {

		case BOTTOM_LEFT:
			coordinateY -= this.dimensions.y;
			break;

		case CENTER:
			coordinateX -= this.dimensions.x / 2;
			coordinateY -= this.dimensions.y / 2;
			break;

		case TOP_LEFT:
			break;

		}

		return new Vector2(coordinateX, coordinateY);

	}

	public void relocateList(double x, double y) {

		this.coordinatesList.x = x;
		this.coordinatesList.y = y;

	}

	public void relocateList(Vector2 numbersPair) {
		relocateList(numbersPair.x, numbersPair.y);
	}

	private void calculateFirstObjectCoordinatesPivot() {

		int rows, columns;
		int listSize = this.list.size();

		if (this.objectsPerRow == -1) {

			rows = 1;
			columns = listSize;

		} else {

			rows = (int) (Math.ceil((double) listSize / this.objectsPerRow));
			columns = (int) Math.min(listSize, this.objectsPerRow);

		}

		double totalX, totalY;

		if (this.gap.x == Credentials.INSTANCE.dGapBetweenComponents.x)
			totalX = this.dimensions.x + (columns - 1) * (this.dimensions.x + this.gap.x);
		else
			totalX = this.dimensions.x + (columns - 1) * this.gap.x;

		if (this.gap.y == Credentials.INSTANCE.dGapBetweenComponents.y)
			totalY = this.dimensions.y + (rows - 1) * (this.dimensions.y + this.gap.y);
		else
			totalY = this.dimensions.y + (rows - 1) * this.gap.y;

		switch (this.directionEnumHorizontal) {

		case RIGHT:
			this.firstObjectX = this.coordinatesList.x - totalX / 2;
			break;

		case LEFT:
			this.firstObjectX = this.coordinatesList.x + totalX / 2 - this.dimensions.x;
			break;

		default:
			logErrorShutDown(this.directionEnumHorizontal);
			break;

		}

		switch (this.directionEnumVertical) {

		case DOWN:
			this.firstObjectY = this.coordinatesList.y - totalY / 2;
			break;

		case UP:
			this.firstObjectY = this.coordinatesList.y + totalY / 2;
			break;

		default:
			logErrorShutDown(this.directionEnumVertical);
			break;

		}

	}

	private void logErrorShutDown(DirectionEnum directionEnum) {

		Logger.INSTANCE.log("ArrayListImageView direction error:");
		Logger.INSTANCE.log(directionEnum);
		ShutDown.INSTANCE.execute();

	}

	public void setList(ArrayList<? extends Object> list) {
		this.list = list;
	}

}
