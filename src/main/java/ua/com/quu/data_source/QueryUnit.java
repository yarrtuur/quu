package ua.com.quu.data_source;

import ua.com.quu.utils.ExitException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class QueryUnit implements UnitTypes {
    private String serviceId;
    private String serviceVariationId;
    private String questionTypeId;
    private String questionCategoryId;
    private String questionSubCategoryId;
    private ResponseType responseType;
    private Date sdfFrom;
    private Date sdfTo;

    public QueryUnit(String stringData) throws ExitException {
        try {
            setDataFields(stringData);
        } catch (Exception ex) {
            throw new ExitException(ex.getMessage());
        }
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getServiceVariationId() {
        return serviceVariationId;
    }

    public String getQuestionTypeId() {
        return questionTypeId;
    }

    public String getQuestionCategoryId() {
        return questionCategoryId;
    }

    public String getQuestionSubCategoryId() {
        return questionSubCategoryId;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public Date getSdfFrom() {
        return sdfFrom;
    }

    public Date getSdfTo() {
        return sdfTo;
    }

    @Override
    public void setDataFields(String stringData) throws ExitException {
        try {
            String[] line = stringData.split(" ");
            serviceDivide(line[1]);
            questionDivide(line[2]);
            responseTypeDivide(line[3]);
            datesDivide(line[4]);
        } catch (Exception ex) {
            throw new ExitException(ex.getMessage());
        }
    }

    private void datesDivide(String s) throws ExitException {
        try {
            if (s.indexOf("-") == 1) {
                String[] line = s.split("-");
                sdfFrom = new SimpleDateFormat("dd.MM.yyyy").parse(line[0]);
                sdfTo = new SimpleDateFormat("dd.MM.yyyy").parse(line[1]);
            } else {
                sdfFrom = new SimpleDateFormat("dd.MM.yyyy").parse(s);
            }
        } catch (IndexOutOfBoundsException | ParseException ex) {
            throw new ExitException(ex.getMessage());
        }
    }

    private void responseTypeDivide(String s) {
        //noinspection EqualsBetweenInconvertibleTypes,EqualsBetweenInconvertibleTypes
        responseType = (s.equals(ResponseType.P)) ? ResponseType.P : ResponseType.N;
    }

    private void questionDivide(String s) throws ExitException {
        try {
            if (s.indexOf(".") == 1) {
                String[] line = s.split("\\.");
                questionTypeId = line[0];
                questionCategoryId = line[1];
                if (line.length > 2) questionSubCategoryId = line[2];
            } else {
                questionTypeId = s;
            }
        } catch (IndexOutOfBoundsException ex) {
            throw new ExitException(ex.getMessage());
        }
    }

    private void serviceDivide(String s) throws ExitException {
        try {
            if (s.indexOf(".") == 1) {
                String[] line = s.split("\\.");
                serviceId = line[0];
                serviceVariationId = line[1];
            } else {
                serviceId = s;
            }
        } catch (IndexOutOfBoundsException ex) {
            throw new ExitException(ex.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryUnit queryUnit = (QueryUnit) o;
        return Objects.equals(serviceId, queryUnit.serviceId) &&
                Objects.equals(serviceVariationId, queryUnit.serviceVariationId) &&
                Objects.equals(questionTypeId, queryUnit.questionTypeId) &&
                Objects.equals(questionCategoryId, queryUnit.questionCategoryId) &&
                Objects.equals(questionSubCategoryId, queryUnit.questionSubCategoryId) &&
                responseType == queryUnit.responseType &&
                Objects.equals(sdfFrom, queryUnit.sdfFrom) &&
                Objects.equals(sdfTo, queryUnit.sdfTo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serviceId, serviceVariationId, questionTypeId, questionCategoryId, questionSubCategoryId, responseType, sdfFrom, sdfTo);
    }

    public String toString() {
        return String.format("serviceId:%s, serviceVariationId:%s, questionTypeId:%s, questionCategoryId:%s, " +
                        "questionSubCategoryId:%s,responseType:%s,sdfFrom:%s,sdfTo:%s",
                serviceId, serviceVariationId, questionTypeId, questionCategoryId, questionSubCategoryId, responseType, sdfFrom, sdfTo);
    }
}
