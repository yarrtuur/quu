package java.ua.com.quu.utils;

import java.util.Collections;
import java.util.List;

public class Unreachable implements UnitCoupleImpl {
	// todo private List<UnitCoupleImpl> unreachableUnitList;

	@Override
	public List<UnitCoupleImpl> getData() {
		return Collections.emptyList();
	}

	@Override
	public boolean canProcess(String startWith) {
		return true;
	}
}
