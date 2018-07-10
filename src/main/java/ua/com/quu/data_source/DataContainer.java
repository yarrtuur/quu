package ua.com.quu.data_source;

import ua.com.quu.utils.ResourceLoader;
import ua.com.quu.utils.UnitCoupleContainerImpl;

import java.util.List;

public class DataContainer {
	private List<UnitTypesImpl> waitingUnitList;
	private List<UnitTypesImpl> queryUnitList;
	private ResourceLoader resourceLoader;

	public DataContainer(ResourceLoader resourceLoader) {
		this.resourceLoader= resourceLoader;
        waitingUnitList = resourceLoader.fillFulWaitingUnitList();
        queryUnitList = resourceLoader.fillFulQueryUnitList();
	}

	public List<UnitTypesImpl> getQueryUnitList() {
		return queryUnitList;
	}

	public List<UnitTypesImpl> getWaitingUnitList() {
		return waitingUnitList;
	}
}
