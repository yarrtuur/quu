package ua.com.quu.data_source;

import ua.com.quu.utils.ResourceLoader;

import java.util.List;

public class DataContainer {
    private List<UnitTypes> waitingUnitList;
    private List<UnitTypes> queryUnitList;

    public DataContainer(ResourceLoader resourceLoader) {
        waitingUnitList = resourceLoader.filFullWaitingUnitList();
        queryUnitList = resourceLoader.filFullQueryUnitList();
    }

    public List<UnitTypes> getQueryUnitList() {
        return queryUnitList;
    }

    public List<UnitTypes> getWaitingUnitList() {
        return waitingUnitList;
    }
}
