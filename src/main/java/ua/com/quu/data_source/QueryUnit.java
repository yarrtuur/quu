package ua.com.quu.data_source;

import ua.com.quu.utils.ExitException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class QueryUnit implements UnitTypesImpl {
    private int serviceId;
    private int serviceVariationId;
    private int questionTypeId;
    private int questionCategoryId;
    private int questionSubCategoryId;
    private ResponseType responseType;
    private Date sdf;
    private int waitingTime;

    public QueryUnit(String stringData) throws ExitException {
        setDataFields(stringData);
    }

    @Override
    public void setDataFields(String stringData) throws ExitException {
        String[] line = stringData.split("\\s");
        serviceDivide(line[1]);
        questionDivide(line[2]);
        responseTypeDivide(line[3]);
        setDate(line[4]);
        setTimeWait(line[5]);
        System.out.println(toString());
    }

    private void setTimeWait(String s) {
        waitingTime = Integer.parseInt(s);
    }

    private void setDate(String s) throws ExitException {
       try {
           String[] line = s.split("-");
           sdf = new SimpleDateFormat("dd MMM yyyy").parse(line[0]);
       }catch(ParseException ex){
           throw new ExitException(ex.getMessage());
       }
    }

    private void responseTypeDivide(String s) {
        responseType = (s.equals(ResponseType.P)) ? ResponseType.P : ResponseType.N;
    }

    private void questionDivide(String s) {
        String[] line = s.split(".");
        questionTypeId = Integer.parseInt(line[0]);
        if (line.length > 1) questionCategoryId = Integer.parseInt(line[1]);
        if (line.length > 2) questionSubCategoryId = Integer.parseInt(line[2]);
    }

    private void serviceDivide(String s) {
        String[] line = s.split(".");
        serviceId = Integer.parseInt(line[0]);
        if (line.length > 1) serviceVariationId = Integer.parseInt(line[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryUnit queryUnit = (QueryUnit) o;
        return serviceId == queryUnit.serviceId &&
                serviceVariationId == queryUnit.serviceVariationId &&
                questionTypeId == queryUnit.questionTypeId &&
                questionCategoryId == queryUnit.questionCategoryId &&
                questionSubCategoryId == queryUnit.questionSubCategoryId &&
                waitingTime == queryUnit.waitingTime &&
                responseType == queryUnit.responseType &&
                Objects.equals(sdf, queryUnit.sdf);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serviceId, serviceVariationId, questionTypeId, questionCategoryId, questionSubCategoryId, responseType, sdf, waitingTime);
    }

    public String toString() {
        return String.format("serviceId:%d, serviceVariationId:%d, questionTypeId:%d, questionCategoryId:%d, " +
                        "questionSubCategoryId:%d,responseType:%s,sdf:%S",
                serviceId, serviceVariationId, questionTypeId, questionCategoryId, questionSubCategoryId, responseType, sdf);
    }
}
