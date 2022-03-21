package utils;

import utils.Interfaces.IImageViewAble;

public enum ImageViewAbleDependency {

	INSTANCE;

	private HashMap<IImageViewAble, IImageViewAble> map = new HashMap<>();

	private ImageViewAbleDependency() {

	}

	public void addDependency(IImageViewAble parent, IImageViewAble child) {
		this.map.put(parent, child);
	}

	public boolean containsDependency(IImageViewAble imageViewAble) {
		return this.map.containsKey(imageViewAble);
	}

	public IImageViewAble getDependency(IImageViewAble imageViewAble) {
		return this.map.getValue(imageViewAble);
	}

	public void removeDependency(IImageViewAble imageViewAble) {
		this.map.remove(imageViewAble);
	}

	public void clearDependencies() {
		this.map.clear();
	}

}
