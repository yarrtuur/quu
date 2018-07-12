package ua.com.quu.utils;

import ua.com.quu.data_source.UnitTypes;

import java.util.List;

public interface ResourceLoaderImpl {

    List<UnitTypes> filFullWaitingUnitList();

    List<UnitTypes> filFullQueryUnitList();

    void fileDataSeparate(String resourceFile);

}
