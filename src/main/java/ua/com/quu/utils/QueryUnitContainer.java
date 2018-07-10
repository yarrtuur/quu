package ua.com.quu.utils;

import ua.com.quu.data_source.QueryUnit;
import ua.com.quu.data_source.UnitTypesImpl;

import java.util.LinkedList;
import java.util.List;

public class QueryUnitContainer implements UnitCoupleContainerImpl {
	private List<UnitTypesImpl> queryUnitList;

	public QueryUnitContainer() {
		queryUnitList = new LinkedList<>();
	}

	@Override
	public List<UnitTypesImpl> getData() {
		return queryUnitList;
	}

	@Override
	public void setData(String stringFromFile) {
		queryUnitList.add(new QueryUnit(stringFromFile));
	}

	@Override
	public boolean canProcess(String startWith) {
		return startWith.equals("D");
	}
}
