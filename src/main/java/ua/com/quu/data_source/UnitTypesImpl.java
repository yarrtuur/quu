package ua.com.quu.data_source;

import ua.com.quu.utils.ExitException;

import java.text.ParseException;

public interface UnitTypesImpl {

    void setDataFields(String stringData) throws ParseException, ExitException;
}
