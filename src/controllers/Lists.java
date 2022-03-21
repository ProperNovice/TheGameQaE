package controllers;

import cards.CardNumber;
import utils.ArrayList;
import utils.ArrayListImageView;
import utils.CoordinatesListBuilder;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListImageViewAbles;
import utils.Logger;

public enum Lists {

	INSTANCE;

	public ArrayListImageView<ArrayList<? extends Object>> lists = new ArrayListImageView<ArrayList<? extends Object>>();
	public ListImageViewAbles<CardNumber> pileAscending, pileDescending, handPlayerI, handPlayerII,
			deck;

	public void instantiate() {

		createLists();

		Logger.INSTANCE.logNewLine("lists instantiated -> " + this.lists.size());

	}

	public void loadLists() {

		for (ArrayList<? extends Object> list : this.lists)
			list.loadOriginal();

	}

	private void createLists() {

		// deck

		this.deck = new ListImageViewAbles<>(
				new CoordinatesListBuilder().coordinatesNumbersPair(Credentials.INSTANCE.cDeck)
						.relocateTypeEnum(RelocateTypeEnum.CENTER)
						.rearrangeTypeEnum(RearrangeTypeEnum.STATIC).build(),
				LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW);

		// hand player I

		this.handPlayerI = new ListImageViewAbles<>(
				new CoordinatesListBuilder()
						.coordinatesNumbersPair(Credentials.INSTANCE.cHandPlayerI)
						.rearrangeTypeEnum(RearrangeTypeEnum.PIVOT).build(),
				LayerZListEnum.TO_BACK_FIRST_IMAGEVIEW, 2);

		// hand player II

		this.handPlayerII = new ListImageViewAbles<>(
				new CoordinatesListBuilder()
						.coordinatesNumbersPair(Credentials.INSTANCE.cHandPlayerII)
						.rearrangeTypeEnum(RearrangeTypeEnum.PIVOT).build(),
				LayerZListEnum.TO_BACK_FIRST_IMAGEVIEW, 2);

		// pile ascending

		this.pileAscending = new ListImageViewAbles<>(
				new CoordinatesListBuilder()
						.coordinatesNumbersPair(Credentials.INSTANCE.cPileAscending)
						.relocateTypeEnum(RelocateTypeEnum.CENTER)
						.rearrangeTypeEnum(RearrangeTypeEnum.STATIC).build(),
				LayerZListEnum.TO_BACK_FIRST_IMAGEVIEW);

		// pile descending

		this.pileDescending = new ListImageViewAbles<>(
				new CoordinatesListBuilder()
						.coordinatesNumbersPair(Credentials.INSTANCE.cPileDescending)
						.relocateTypeEnum(RelocateTypeEnum.CENTER)
						.rearrangeTypeEnum(RearrangeTypeEnum.STATIC).build(),
				LayerZListEnum.TO_BACK_FIRST_IMAGEVIEW);

	}

}
