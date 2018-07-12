package ua.com.quu.depend_tools;

import ua.com.quu.data_source.DataContainer;
import ua.com.quu.data_source.QueryUnit;
import ua.com.quu.data_source.UnitTypes;
import ua.com.quu.data_source.WaitingUnit;

import java.util.List;

public class DependData {
    private List<WaitingUnit> waitingUnitList;
    private List<QueryUnit> queryUnitList;
//C 1.1 8.15.1 P 15.10.2012 83
//C 1 10.1 P 01.12.2012 65C 1.1 5.5.1 P 01.11.2012 117
//D 1.1 8 P 01.01.2012-01.12.2012
//C 3 10.2 N 02.10.2012 100
//D 1 * P 8.10.2012-20.11.2012
//D 3 10 P 01.12.2012
//C service_id[.variation_id] question_type_id[.category_id.[sub-category_id]] P/N date time
//D service_id[.variation_id] question_type_id[.category_id.[sub-category_id]] P/N date_from[-date_to]

    public DependData(DataContainer dataContainer) {

        copyingWaitingUnitList(dataContainer);
        copyingQueryUnitList(dataContainer);
        findDependences();
    }

    private void copyingQueryUnitList(DataContainer dataContainer) {
        for(UnitTypes step : dataContainer.getQueryUnitList()) {
            queryUnitList.add((QueryUnit) step);
        }
    }

    private void copyingWaitingUnitList(DataContainer dataContainer) {
        for(UnitTypes step : dataContainer.getWaitingUnitList()) {
            waitingUnitList.add((WaitingUnit) step);
        }
    }

    private void findDependences() {
        for(QueryUnit stepQuery: queryUnitList){
            if(stepQuery.getServiceId().equals("*")){

            }
        }
    }


}
