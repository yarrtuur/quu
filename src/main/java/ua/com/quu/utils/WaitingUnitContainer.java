package ua.com.quu.utils;

import ua.com.quu.data_source.UnitTypesImpl;
import ua.com.quu.data_source.WaitingUnit;

import java.util.LinkedList;
import java.util.List;

public class WaitingUnitContainer implements UnitCoupleContainerImpl {
	private List<UnitTypesImpl> waitingUnitList;

	public WaitingUnitContainer() {
		this.waitingUnitList = new LinkedList<>();
	}

	@Override
	public List<UnitTypesImpl> getData() {
		return waitingUnitList;
	}

	@Override
	public void setData(String stringFromFile) {
		waitingUnitList.add(new WaitingUnit(stringFromFile));
	}

	@Override
	public boolean canProcess(String startWith) {
		return startWith.equals("C");
	}
}
