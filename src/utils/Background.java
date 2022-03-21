package utils;

import enums.ELayerZ;
import utils.Interfaces.IEventHandlerAble;
import utils.Interfaces.IImageViewAble;

public class Background implements IImageViewAble, IEventHandlerAble {

	public Background() {
		new ImageView("misc/backgroundDark.png", ELayerZ.BACKGROUND, this);
	}

	@Override
	public void handleMouseButtonPressedSecondary() {
		ShutDown.INSTANCE.execute();
	}

}
