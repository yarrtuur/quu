package ua.com.quu.utils;

import ua.com.quu.data_source.UnitTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ResourceLoader implements ResourceLoaderImpl {
    private List<UnitContainerImpl> unitCoupleList;

    public ResourceLoader(String resourceFile) {
        initUnitCouple();
        try {
            fileDataSeparate(resourceFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<UnitTypes> filFullWaitingUnitList() {
        for (UnitContainerImpl gaither : unitCoupleList) {
            if (gaither.canProcess("C")) {
                return gaither.getData();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<UnitTypes> filFullQueryUnitList() {
        for (UnitContainerImpl gaither : unitCoupleList) {
            if (gaither.canProcess("D")) {
                return gaither.getData();
            }
        }
        return Collections.emptyList();
    }

    public void fileDataSeparate(String resourceFile) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream in = classloader.getResourceAsStream(resourceFile);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))
        ) {
            int rowsCount = Integer.parseInt(reader.readLine());
            while (reader.ready()) {
                putRightContainer(reader.readLine());
            }
        } catch (IOException | NullPointerException | ExitException e) {
            System.err.println(e.getMessage());
        }
    }

    private void putRightContainer(String stringFromFile) throws ExitException {
        for (UnitContainerImpl gaither : unitCoupleList) {
            if (gaither.canProcess(stringFromFile)) {
                try {
                    gaither.setData(stringFromFile);
                } catch (Exception e) {
                    throw new ExitException(e.getMessage());
                }
            }
        }
    }

    private void initUnitCouple() {
        unitCoupleList = new LinkedList<>();
        unitCoupleList.add(new QueryUnitContainer());
        unitCoupleList.add(new WaitingUnitContainer());
    }

}
