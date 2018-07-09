package java.ua.com.quu.utils;

import java.util.LinkedList;
import java.util.List;

public class WaitingUnitGaither implements UnitCoupleImpl {
	private List<UnitCoupleImpl> waitingUnitList;

	public WaitingUnitGaither() {
		this.waitingUnitList = new LinkedList<>();
	}

	@Override
	public List<UnitCoupleImpl> getData() {
		return waitingUnitList;
	}

	@Override
	public boolean canProcess(String startWith) {
		return startWith.equals("C");
	}
}
