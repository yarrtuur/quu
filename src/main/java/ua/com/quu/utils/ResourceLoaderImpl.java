package ua.com.quu.utils;

import ua.com.quu.data_source.UnitTypesImpl;

import java.util.List;

public interface ResourceLoaderImpl {

    List<UnitTypesImpl> fillFulWaitingUnitList();

    List<UnitTypesImpl> fillFulQueryUnitList();

    void fileDataSeparate(String resourceFile) throws ExitException;

}
