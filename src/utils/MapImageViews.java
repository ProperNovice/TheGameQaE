package utils;

import utils.Interfaces.IImageViewAble;

public enum MapImageViews {

	INSTANCE;

	private HashMap<IImageViewAble, ImageView> mapImageViews = new HashMap<>();

	public HashMap<IImageViewAble, ImageView> getImageViewsMap() {
		return this.mapImageViews;
	}

}
