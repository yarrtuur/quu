package ua.com.quu.data_source;

import ua.com.quu.utils.ResourceLoader;

import java.util.List;

public class DataContainer {
    private List<UnitTypesImpl> waitingUnitList;
    private List<UnitTypesImpl> queryUnitList;

    public DataContainer(ResourceLoader resourceLoader) {
        waitingUnitList = resourceLoader.filFullWaitingUnitList();
        queryUnitList = resourceLoader.filFullQueryUnitList();
    }

    public List<UnitTypesImpl> getQueryUnitList() {
        return queryUnitList;
    }

    public List<UnitTypesImpl> getWaitingUnitList() {
        return waitingUnitList;
    }
}
