package ua.com.quu.utils;

import ua.com.quu.data_source.UnitTypesImpl;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;

public class Unreachable implements UnitCoupleContainerImpl {

    @Override
    public List<UnitTypesImpl> getData() {
        return Collections.emptyList();
    }

    @Override
    public void setData(String stringFromFile)  {

    }

    @Override
    public boolean canProcess(String startWith) {
        return true;
    }
}
