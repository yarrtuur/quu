package ua.com.quu.utils;

import ua.com.quu.data_source.UnitTypes;

import java.util.List;

public interface UnitContainerImpl {
    boolean canProcess(String startWith);

    List<UnitTypes> getData();

    void setData(String stringFromFile) throws ExitException;

}
