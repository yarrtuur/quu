package ua.com.quu.data_source;

import java.text.SimpleDateFormat;

public class QueryUnit implements UnitTypesImpl{
	//C service_id[.variation_id] question_type_id[.category_id.[sub-category_id]] P/N date time
	private int serviceId;
	private int serviceVariationId;
	private int questionTypeId;
	private int questionCategoryId;
	private int questionSubCategoryId;
	private ResponseType responseType;
	private SimpleDateFormat sdf;
	private int waitingTime;
	private String stringData;

	public QueryUnit(String stringData) {
		this.stringData = stringData;
	}

}
