package ua.com.quu.utils;

import ua.com.quu.data_source.UnitTypesImpl;
import ua.com.quu.data_source.WaitingUnit;

import java.util.LinkedList;
import java.util.List;

public class WaitingUnitContainer implements UnitCoupleContainerImpl {
    private List<UnitTypesImpl> waitingUnitList;

    public WaitingUnitContainer() {
        this.waitingUnitList = new LinkedList<>();
    }

    @Override
    public List<UnitTypesImpl> getData() {
        return waitingUnitList;
    }

    @Override
    public void setData(String stringFromFile) throws ExitException {
        try {
            waitingUnitList.add(new WaitingUnit(stringFromFile));
        }catch(Exception e){
            throw new ExitException(e.getMessage());
        }
        System.out.println("new WaitingUnit added");
    }

    @Override
    public boolean canProcess(String lineToPrepare) {
        return lineToPrepare.startsWith("C");
    }
}
