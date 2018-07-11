package ua.com.quu.utils;

import ua.com.quu.data_source.UnitTypesImpl;

import java.util.List;

public interface UnitContainerImpl   {
    boolean canProcess(String startWith);

    List<UnitTypesImpl> getData();

    void setData(String stringFromFile) throws ExitException;

}
