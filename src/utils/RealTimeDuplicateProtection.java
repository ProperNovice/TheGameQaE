package utils;

import utils.Interfaces.IUpdateAble;

public enum RealTimeDuplicateProtection implements IUpdateAble {

	INSTANCE;

	private ArrayList<Object> objectsChecking = new ArrayList<Object>();
	private ArrayList<ArrayList<? extends Object>> objectLists = new ArrayList<ArrayList<? extends Object>>();

	private RealTimeDuplicateProtection() {

	}

	public void addList(ArrayList<? extends Object> list) {
		this.objectLists.addLast(list);
	}

	public void executeDuplicateProtect() {
		AnimationTimerFX.INSTANCE.updateNextFrame(this);
	}

	@Override
	public void update() {

		this.objectsChecking.clear();

		for (ArrayList<? extends Object> objectList : this.objectLists) {

			for (Object object : objectList)
				if (this.objectsChecking.contains(object))
					ShutDown.INSTANCE.execute();
				else
					this.objectsChecking.addLast(object);

		}

		Logger.INSTANCE.logNewLine("real time duplicate protected");

	}

}
