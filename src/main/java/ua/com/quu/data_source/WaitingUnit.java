package ua.com.quu.data_source;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitingUnit implements UnitTypesImpl{
	//D service_id[.variation_id] question_type_id[.category_id.[sub-category_id]] P/N date_from[-date_to]
	private int serviceId;
	private int serviceVariationId;
	private int questionTypeId;
	private int questionCategoryId;
	private int questionSubCategoryId;
	private ResponseType responseType;
	private Date sdfFrom;
	private Date sdfTo;

	public WaitingUnit(String stringData) throws ParseException {
		setDataFields(stringData);
	}

    private void setDataFields(String stringData) throws ParseException {
	    String[] line = stringData.split("\\s");
	    serviceDivide(line[1]);
	    questionDivide(line[2]);
	    responseType = responseTypeDivide(line[3]);
	    datesDivide(line[4]);
    }

    private void datesDivide(String s) throws ParseException {
        String[] line = s.split("-");
        sdfFrom = new SimpleDateFormat("dd MMM yyyy").parse(line[0]);
        if( line.length > 1) {
            sdfTo = new SimpleDateFormat("dd MMM yyyy").parse(line[1]);
        }
    }

    private ResponseType responseTypeDivide(String s) {
        return (s.equals(ResponseType.P))? ResponseType.P : ResponseType.N;
    }

    private void questionDivide(String s) {

    }

    private void serviceDivide(String s) {

    }


}
