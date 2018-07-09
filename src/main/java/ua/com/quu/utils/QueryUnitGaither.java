package java.ua.com.quu.utils;

import java.util.LinkedList;
import java.util.List;

public class QueryUnitGaither implements UnitCoupleImpl {
	private List<UnitCoupleImpl> queryUnitList;

	public QueryUnitGaither() {
		queryUnitList = new LinkedList<>();
	}

	@Override
	public List<UnitCoupleImpl> getData() {
		return queryUnitList;
	}

	@Override
	public boolean canProcess(String startWith) {
		return startWith.equals("D");
	}
}
