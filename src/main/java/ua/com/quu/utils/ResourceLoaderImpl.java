package ua.com.quu.utils;

import ua.com.quu.data_source.UnitTypesImpl;

import java.util.List;

public interface ResourceLoaderImpl {

    List<UnitTypesImpl> filFullWaitingUnitList();

    List<UnitTypesImpl> filFullQueryUnitList();

    void fileDataSeparate(String resourceFile);

}
