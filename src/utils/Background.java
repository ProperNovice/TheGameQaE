package utils;

import enums.ELayerZ;
import utils.Interfaces.IEventHandlerAble;
import utils.Interfaces.IImageViewAble;

public class Background implements IImageViewAble, IEventHandlerAble {

	public Background() {
		new ImageView("misc/backgroundDark.png", this, ELayerZ.BACKGROUND);
	}

	@Override
	public void handleMouseButtonPressedSecondary() {
		ShutDown.INSTANCE.execute();
	}

}
