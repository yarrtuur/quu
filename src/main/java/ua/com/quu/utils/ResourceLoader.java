package java.ua.com.quu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class ResourceLoader implements ResourceLoaderImpl {
	private List<UnitCoupleImpl> unitCoupleList;
	private String resourceFile;
	private List<UnitCoupleImpl> waitingUnitList;
	private List<UnitCoupleImpl> queryUnitList;


	public ResourceLoader(String resourceFile) {
		this.resourceFile = resourceFile;
		try {
			fileDataSeparate(resourceFile);
			initUnitCouple();
		} catch (ExitException e) {
			System.out.println(e.getMessage());
		}
	}

	private void fileDataSeparate(String resourceFile) throws ExitException {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		try (InputStream in = classloader.getResourceAsStream(resourceFile)) {
			//todo read from file
		} catch (IOException | NullPointerException e) {
			throw new ExitException("No resource file found in " + e.getMessage());
		}
	}

	private void initUnitCouple() {
		unitCoupleList = new LinkedList<>();
		unitCoupleList.add(new QueryUnitGaither());
		unitCoupleList.add(new WaitingUnitGaither());
		unitCoupleList.add(new Unreachable());
	}

}
