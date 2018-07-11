package ua.com.quu.depend_tools;

import ua.com.quu.data_source.DataContainer;
import ua.com.quu.data_source.UnitTypesImpl;

import java.util.List;

public class DependData {
    private List<UnitTypesImpl> waitingUnitList;
    private List<UnitTypesImpl> queryUnitList;

    public DependData(DataContainer dataContainer) {
        waitingUnitList = dataContainer.getWaitingUnitList();
        queryUnitList = dataContainer.getQueryUnitList();

    }



}
