package java.ua.com.quu.utils;

import java.util.List;

public interface ResourceLoaderImpl {
	List<UnitCoupleImpl> getQueryUnitList();

	List<UnitCoupleImpl> getWaitingUnitList();
}
