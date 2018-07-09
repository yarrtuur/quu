package java.ua.com.quu.data_source;

import java.text.SimpleDateFormat;

public class WaitingUnit {
	//D service_id[.variation_id] question_type_id[.category_id.[sub-category_id]] P/N date_from[-date_to]
	private int serviceId;
	private int serviceVariationId;
	private int questionTypeId;
	private int questionCategoryId;
	private int questionSubCategoryId;
	private ResponseType responseType;
	private SimpleDateFormat sdfFrom;
	private SimpleDateFormat sdfTo;


}
