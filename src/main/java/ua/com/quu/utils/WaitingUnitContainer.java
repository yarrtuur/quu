package ua.com.quu.utils;

import ua.com.quu.data_source.UnitTypes;
import ua.com.quu.data_source.WaitingUnit;

import java.util.LinkedList;
import java.util.List;

public class WaitingUnitContainer implements UnitContainerImpl {
    private List<UnitTypes> waitingUnitList;

    public WaitingUnitContainer() {
        this.waitingUnitList = new LinkedList<>();
    }

    @Override
    public List<UnitTypes> getData() {
        return waitingUnitList;
    }

    @Override
    public void setData(String stringFromFile) throws ExitException {
        try {
            waitingUnitList.add(new WaitingUnit(stringFromFile));
        } catch (Exception e) {
            throw new ExitException(e.getMessage());
        }
    }

    @Override
    public boolean canProcess(String lineToPrepare) {
        return lineToPrepare.startsWith("C");
    }
}
