package java.ua.com.quu.utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ResourceLoader implements ResourceLoaderImpl {
	private String resourceFile;
	private List<UnitCoupleImpl> unitCoupleList;
	private UnitCoupleImpl resourceStorage;

	public ResourceLoader(String resourceFile) {
		this.resourceFile = resourceFile;
		fileDataSeparate(resourceFile);
		initUnitCouple();
	}

	@Override
	public List<UnitCoupleImpl> getQueryUnitList() {
		Iterator<UnitCoupleImpl> step = unitCoupleList.iterator();
		while (step.hasNext()) {
			resourceStorage = step.next();
			if (resourceStorage.canProcess("C")) {
				return resourceStorage.getData();
			}
		}
		return null;//todo
	}

	@Override
	public List<UnitCoupleImpl> getWaitingUnitList() {
		Iterator<UnitCoupleImpl> step = unitCoupleList.iterator();
		while (step.hasNext()) {
			resourceStorage = step.next();
			if (resourceStorage.canProcess("D")) {
				return resourceStorage.getData();
			}
		}
		return null;//todo
	}

	private void fileDataSeparate(String resourceFile) {

	}

	private void initUnitCouple() {
		unitCoupleList = new LinkedList<>();
		unitCoupleList.add(new QueryUnitGaither());
		unitCoupleList.add(new WaitingUnitGaither());
		unitCoupleList.add(new Unreachable());
	}

}
