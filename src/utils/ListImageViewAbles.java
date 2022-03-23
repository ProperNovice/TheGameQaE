package utils;

import java.util.Iterator;

import controllers.Lists;
import utils.Enums.AnimationSynchEnum;
import utils.Enums.ImageViewActionEnum;
import utils.Enums.LayerZListEnum;
import utils.Interfaces.IImageViewAble;

public class ListImageViewAbles<T> implements Iterable<T> {

	private ArrayListImageView<T> arrayList = null;
	private CoordinatesList coordinatesList = null;
	private Runnable layerZListEnumRunnable = null;

	public ListImageViewAbles(CoordinatesList coordinatesList) {
		this(coordinatesList, LayerZListEnum.TO_BACK_FIRST_IMAGEVIEW, -1);
	}

	public ListImageViewAbles(CoordinatesList coordinatesList, int capacity) {
		this(coordinatesList, LayerZListEnum.TO_BACK_FIRST_IMAGEVIEW, capacity);
	}

	public ListImageViewAbles(CoordinatesList coordinatesList, LayerZListEnum layerZListEnum) {
		this(coordinatesList, layerZListEnum, -1);
	}

	public ListImageViewAbles(CoordinatesList coordinatesList, LayerZListEnum layerZListEnum,
			int capacity) {

		this.arrayList = new ArrayListImageView<T>();
		this.arrayList.setCapacity(capacity);

		this.coordinatesList = coordinatesList;
		this.coordinatesList.setList(this.arrayList);

		switch (layerZListEnum) {

		case TO_FRONT_FIRST_IMAGEVIEW:
			this.layerZListEnumRunnable = () -> toFrontFirstImageView();
			break;

		case TO_BACK_FIRST_IMAGEVIEW:
			this.layerZListEnumRunnable = () -> toBackFirstImageView();
			break;

		}

		Lists.INSTANCE.lists.addLast(this.arrayList);
		RealTimeDuplicateProtection.INSTANCE.addList(this.arrayList);

	}

	public void layerZSort() {

		if (this.layerZListEnumRunnable == null)
			return;

		this.layerZListEnumRunnable.run();

	}

	private void toFrontFirstImageView() {

		IImageViewAble imageViewAble = null;

		for (int counter = this.arrayList.size() - 1; counter >= 0; counter--) {

			imageViewAble = (IImageViewAble) this.arrayList.get(counter);
			imageViewAble.getImageView().toFront();

			toFrontDependency(imageViewAble);

		}

	}

	private void toBackFirstImageView() {

		IImageViewAble imageViewAble = null;

		for (T t : this.arrayList) {

			imageViewAble = (IImageViewAble) t;
			imageViewAble.getImageView().toFront();

			toFrontDependency(imageViewAble);

		}

	}

	private void toFrontDependency(IImageViewAble imageViewAble) {

		if (!ImageViewAbleDependency.INSTANCE.containsDependency(imageViewAble))
			return;

		IImageViewAble dependency = ImageViewAbleDependency.INSTANCE.getDependency(imageViewAble);
		dependency.getImageView().toFront();

	}

	public void animateAsynchronous() {
		executeAction(ImageViewActionEnum.ANIMATE, AnimationSynchEnum.ASYNCHRONOUS);
	}

	public void animateSynchronous() {
		executeAction(ImageViewActionEnum.ANIMATE, AnimationSynchEnum.SYNCHRONOUS);
	}

	public void animateSynchronousLock() {

		animateSynchronous();
		Lock.INSTANCE.lock();

	}

	public void animateSynchronousLock(Runnable runnable) {

		animateSynchronous();
		Lock.INSTANCE.lock(runnable);

	}

	public void relocateImageViews() {
		executeAction(ImageViewActionEnum.RELOCATE, null);
	}

	public void relocateList(double x, double y) {
		this.coordinatesList.relocateList(x, y);
	}

	public void relocateList(Vector2 numbersPair) {
		this.coordinatesList.relocateList(numbersPair);
	}

	private void executeAction(ImageViewActionEnum imageViewAction,
			AnimationSynchEnum animationSynch) {

		ArrayList<T> list = this.arrayList.clone();
		list.reverse();

		for (T t : list) {

			int index = this.arrayList.indexOf(t);
			Vector2 vector2 = this.coordinatesList.getCoordinate(index);

			IImageViewAble imageViewAble = (IImageViewAble) t;

			switch (imageViewAction) {

			case ANIMATE:

				imageViewAble.getImageView().getAnimationExecutionObject()
						.setAnimationCredentials(vector2);

				if (imageViewAble.getImageView().getAnimationExecutionObject()
						.animationIsFinished())
					continue;
				else
					Animation.INSTANCE.animateTopLeft(imageViewAble, vector2, animationSynch);
				break;

			case RELOCATE:

				imageViewAble.getImageView().relocateTopLeft(vector2);

				if (!ImageViewAbleDependency.INSTANCE.containsDependency(imageViewAble))
					break;

				ImageViewAbleDependency.INSTANCE.getDependency(imageViewAble).getImageView()
						.relocateTopLeft(vector2);

				break;

			}

		}

		layerZSort();

	}

	public ArrayList<T> getArrayList() {
		return this.arrayList;
	}

	@Override
	public Iterator<T> iterator() {
		return this.arrayList.iterator();
	}

}
