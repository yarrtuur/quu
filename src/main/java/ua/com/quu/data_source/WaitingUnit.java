package ua.com.quu.data_source;

import ua.com.quu.utils.ExitException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class WaitingUnit implements UnitTypes {
    private String serviceId;
    private String serviceVariationId;
    private String questionTypeId;
    private String questionCategoryId;
    private String questionSubCategoryId;
    private ResponseType responseType;
    private Date sdf;
    private int waitingTime;

    public WaitingUnit(String stringData) throws ExitException {
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

    public Date getSdf() {
        return sdf;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    @Override
    public void setDataFields(String stringData) throws ExitException {
        try {
            String[] line = stringData.split(" ");
            serviceDivide(line[1]);
            questionDivide(line[2]);
            responseTypeDivide(line[3]);
            setDate(line[4]);
            setTimeWait(line[5]);
        } catch (Exception ex) {
            throw new ExitException(ex.getMessage());
        }
    }

    private void setTimeWait(String s) {
        waitingTime = Integer.parseInt(s);
    }

    private void setDate(String s) throws ExitException {
        try {
            sdf = new SimpleDateFormat("dd.MM.yyyy").parse(s);
        } catch (ParseException ex) {
            throw new ExitException(ex.getMessage());
        }
    }

    private void responseTypeDivide(String s) throws ExitException {
        try {
            responseType = (s.equals(ResponseType.P.toString())) ? ResponseType.P : ResponseType.N;
        } catch (Exception ex) {
            throw new ExitException(ex.getMessage());
        }
    }

    private void questionDivide(String s) throws ExitException {
        try {
            String[] line = s.split("\\.");
            questionTypeId = line[0];
            if (line.length > 1) questionCategoryId = line[1];
            if (line.length > 2) questionSubCategoryId = line[2];
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
        WaitingUnit that = (WaitingUnit) o;
        return waitingTime == that.waitingTime &&
                Objects.equals(serviceId, that.serviceId) &&
                Objects.equals(serviceVariationId, that.serviceVariationId) &&
                Objects.equals(questionTypeId, that.questionTypeId) &&
                Objects.equals(questionCategoryId, that.questionCategoryId) &&
                Objects.equals(questionSubCategoryId, that.questionSubCategoryId) &&
                responseType == that.responseType &&
                Objects.equals(sdf, that.sdf);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serviceId, serviceVariationId, questionTypeId, questionCategoryId, questionSubCategoryId, responseType, sdf, waitingTime);
    }

    public String toString() {
        return String.format("serviceId:%s, serviceVariationId:%s, questionTypeId:%s, questionCategoryId:%s, " +
                        "questionSubCategoryId:%s,responseType:%s,sdf:%s, waitingTime %d",
                serviceId, serviceVariationId, questionTypeId, questionCategoryId, questionSubCategoryId, responseType, sdf, waitingTime);
    }


}
