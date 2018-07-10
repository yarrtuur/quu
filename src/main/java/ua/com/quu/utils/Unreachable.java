package ua.com.quu.utils;

import ua.com.quu.data_source.UnitTypesImpl;

import java.util.Collections;
import java.util.List;

public class Unreachable implements UnitCoupleContainerImpl {
	// todo private List<UnitCoupleContainerImpl> unreachableUnitList;

	@Override
	public List<UnitTypesImpl> getData() {
		return Collections.emptyList();
	}

	@Override
	public boolean canProcess(String startWith) {
		return true;
	}
}
