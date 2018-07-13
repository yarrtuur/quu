package ua.com.quu.depend_tools;

import ua.com.quu.data_source.DataContainer;
import ua.com.quu.data_source.QueryUnit;
import ua.com.quu.data_source.UnitTypes;
import ua.com.quu.data_source.WaitingUnit;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DependData {
    private DataContainer dataContainer;
    private List<WaitingUnit> waitingUnitList;
    private List<QueryUnit> queryUnitList;

    public DependData(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
        copyingQueryUnitList(this.dataContainer);
        findDependences();
    }

    private void copyingQueryUnitList(DataContainer dataContainer) {
        queryUnitList = new LinkedList<>();
        for (UnitTypes step : dataContainer.getQueryUnitList()) {
            queryUnitList.add((QueryUnit) step);
        }
    }

    private void copyingWaitingUnitList(DataContainer dataContainer) {
        waitingUnitList = new LinkedList<>();
        for (UnitTypes step : dataContainer.getWaitingUnitList()) {
            waitingUnitList.add((WaitingUnit) step);
        }
    }

    private void findDependences() {
        for (QueryUnit queryStep : queryUnitList) {
            int timeWait = getTimeWait(queryStep);
            if (timeWait == 0) {
                System.out.println("-");
            } else {
                System.out.println(timeWait);
            }
        }
    }

    private int getTimeWait(QueryUnit queryStep) {
        int checkSum, timeWait = 0, iterator = 0;
        copyingWaitingUnitList(dataContainer);
        Iterator<WaitingUnit> iter = waitingUnitList.iterator();
        while (iter.hasNext()) {
            WaitingUnit waitingStep = iter.next();
            checkSum = getCheckSum(queryStep, waitingStep);
            if (checkSum == 0) {
                timeWait += waitingStep.getWaitingTime();
                iterator++;
            } else {
                iter.remove();
            }
        }
        return (iterator > 0) ? timeWait / iterator : timeWait;
    }

    private int getCheckSum(QueryUnit queryStep, WaitingUnit waitingStep) {
        int checkSum = 0;
        boolean allServices = queryStep.getServiceId().equals("*"),
                allQueries = queryStep.getQuestionTypeId().equals("*");
        if (!allServices) {
            checkSum += compareServiceIds(queryStep, waitingStep);
            checkSum += compareServiceVariationIds(queryStep, waitingStep);
        }
        if (!allQueries) {
            checkSum += compareQuestionTypeId(queryStep, waitingStep);
            checkSum += compareCategoryId(queryStep, waitingStep);
            checkSum += compareSubCategoryId(queryStep, waitingStep);
        }
        checkSum += compareWaitingDate(queryStep, waitingStep);
        return checkSum;
    }

    private int compareServiceIds(QueryUnit queryStep, WaitingUnit waitingStep) {
        if (waitingStep.getServiceId() != null
                && waitingStep.getServiceId().equals(queryStep.getServiceId())) {
            return 0;
        }
        return 1;
    }

    private int compareServiceVariationIds(QueryUnit queryStep, WaitingUnit waitingStep) {
        if (queryStep.getServiceVariationId() == null) {
            return 0;
        }
        if (waitingStep.getServiceVariationId() == null) {
            return 0;
        }
        if (queryStep.getServiceVariationId().equals(waitingStep.getServiceVariationId())) {
            return 0;
        }
        return 1;
    }

    private int compareQuestionTypeId(QueryUnit queryStep, WaitingUnit waitingStep) {
        if (waitingStep.getQuestionTypeId() != null
                && waitingStep.getQuestionTypeId().equals(queryStep.getQuestionTypeId())) {
            return 0;
        }
        return 1;
    }

    private int compareCategoryId(QueryUnit queryStep, WaitingUnit waitingStep) {
        if (queryStep.getQuestionCategoryId() == null) {
            return 0;
        }
        if (waitingStep.getQuestionCategoryId() == null) {
            return 0;
        }
        if (queryStep.getQuestionCategoryId().equals(waitingStep.getQuestionCategoryId())) {
            return 0;
        }
        return 1;
    }

    private int compareSubCategoryId(QueryUnit queryStep, WaitingUnit waitingStep) {
        if (queryStep.getQuestionSubCategoryId() == null) {
            return 0;
        }
        if (waitingStep.getQuestionSubCategoryId() == null) {
            return 0;
        }
        if (queryStep.getQuestionSubCategoryId().equals(waitingStep.getQuestionSubCategoryId())) {
            return 0;
        }
        return 1;
    }

    private int compareWaitingDate(QueryUnit queryStep, WaitingUnit waitingStep) {
        if (queryStep.getSdfFrom() == waitingStep.getSdf()) {
            return 0;
        }
        if (queryStep.getSdfTo() != null && queryStep.getSdfTo() == waitingStep.getSdf()) {
            return 0;
        }
        if (queryStep.getSdfTo() != null
                && waitingStep.getSdf().after(queryStep.getSdfFrom())
                && waitingStep.getSdf().before(queryStep.getSdfTo())) {
            return 0;
        }
        return 1;
    }

}
