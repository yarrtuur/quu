package ua.com.quu.utils;

import ua.com.quu.data_source.QueryUnit;
import ua.com.quu.data_source.UnitTypes;

import java.util.LinkedList;
import java.util.List;

public class QueryUnitContainer implements UnitContainerImpl {
    private List<UnitTypes> queryUnitList;

    public QueryUnitContainer() {
        queryUnitList = new LinkedList<>();
    }

    @Override
    public List<UnitTypes> getData() {
        return queryUnitList;
    }

    @Override
    public void setData(String stringFromFile) throws ExitException {
        try {
            queryUnitList.add(new QueryUnit(stringFromFile));
        } catch (Exception e) {
            throw new ExitException(e.getMessage());
        }
    }

    @Override
    public boolean canProcess(String lineToPrepare) {
        return lineToPrepare.startsWith("D");
    }
}
