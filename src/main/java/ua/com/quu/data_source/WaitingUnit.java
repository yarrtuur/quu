package ua.com.quu.data_source;

import ua.com.quu.utils.ExitException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class WaitingUnit implements UnitTypesImpl {
    private int serviceId;
    private int serviceVariationId;
    private int questionTypeId;
    private int questionCategoryId;
    private int questionSubCategoryId;
    private ResponseType responseType;
    private Date sdfFrom;
    private Date sdfTo;

    public WaitingUnit(String stringData) throws ExitException {
        try {
            setDataFields(stringData);
        }catch(Exception ex){
            throw new ExitException(ex.getMessage());
        }
    }

    @Override
    public void setDataFields(String stringData) throws ExitException {
       try {
           String[] line = stringData.split(" ");
           serviceDivide(line[1]);
           questionDivide(line[2]);
           responseTypeDivide(line[3]);
           datesDivide(line[4]);
           System.out.println(toString());
       }catch(Exception ex ){
           throw new ExitException(ex.getMessage());
       }
    }

    private void datesDivide(String s)  throws ExitException {
        try {
            String[] line = s.split("-");
            sdfFrom = new SimpleDateFormat("dd MMM yyyy").parse(line[0]);
            if (line.length > 1) {
                sdfTo = new SimpleDateFormat("dd MMM yyyy").parse(line[1]);
            }
        }catch(ParseException ex){
            throw new ExitException(ex.getMessage());
        }
    }

    private void responseTypeDivide(String s) throws ExitException {
        try {
            responseType = (s.equals(ResponseType.P)) ? ResponseType.P : ResponseType.N;
        }catch(Exception ex){
            throw new ExitException(ex.getMessage());
        }
    }

    private void questionDivide(String s) throws ExitException {
        try {
            String[] line = s.split(".");
            questionTypeId = Integer.parseInt(line[0]);
            if (line.length > 1) questionCategoryId = Integer.parseInt(line[1]);
            if (line.length > 2) questionSubCategoryId = Integer.parseInt(line[2]);
        }catch(Exception ex){
            throw new ExitException(ex.getMessage());
        }
    }

    private void serviceDivide(String s) throws ExitException {
        String[] line = s.split(".");
        try {
            serviceId = Integer.parseInt(line[0]);
            if (line.length > 1) serviceVariationId = Integer.parseInt(line[1]);
        }catch (ArrayIndexOutOfBoundsException ex){
            throw new ExitException(ex.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaitingUnit that = (WaitingUnit) o;
        return serviceId == that.serviceId &&
                serviceVariationId == that.serviceVariationId &&
                questionTypeId == that.questionTypeId &&
                questionCategoryId == that.questionCategoryId &&
                questionSubCategoryId == that.questionSubCategoryId &&
                responseType == that.responseType &&
                Objects.equals(sdfFrom, that.sdfFrom) &&
                Objects.equals(sdfTo, that.sdfTo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serviceId, serviceVariationId, questionTypeId, questionCategoryId, questionSubCategoryId, responseType, sdfFrom, sdfTo);
    }

    public String toString() {
        return String.format("serviceId:%d, serviceVariationId:%d, questionTypeId:%d, questionCategoryId:%d, " +
                        "questionSubCategoryId:%d,responseType:%s,sdfFrom:%s,sdfTo:%S",
                serviceId, serviceVariationId, questionTypeId, questionCategoryId, questionSubCategoryId, responseType, sdfFrom, sdfTo);
    }

}
