package java.ua.com.quu;

import java.ua.com.quu.utils.ResourceLoader;
import java.ua.com.quu.utils.UnitCoupleImpl;
import java.util.List;

public class DataContainer {
	private ResourceLoader resourceLoader;

	private List<UnitCoupleImpl> waitingUnitList;
	private List<UnitCoupleImpl> queryUnitList;

	public DataContainer(String resourceFile) {
		this.resourceLoader = new ResourceLoader(resourceFile);
	}

	public List<UnitCoupleImpl> getQueryUnitList() {
		return queryUnitList;
	}

	public List<UnitCoupleImpl> getWaitingUnitList() {
		return waitingUnitList;
	}
}
