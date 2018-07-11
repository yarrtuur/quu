package ua.com.quu.utils;

import ua.com.quu.data_source.UnitTypesImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ResourceLoader implements ResourceLoaderImpl {
    private List<UnitCoupleContainerImpl> unitCoupleList;

    public ResourceLoader(String resourceFile) {
            initUnitCouple();
        try {
            fileDataSeparate(resourceFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<UnitTypesImpl> fillFulWaitingUnitList() {
        Iterator<UnitCoupleContainerImpl> step = unitCoupleList.iterator();
        while (step.hasNext()) {
            UnitCoupleContainerImpl gaither = step.next();
            if (gaither.canProcess("C")) {
                return gaither.getData();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<UnitTypesImpl> fillFulQueryUnitList() {
        Iterator<UnitCoupleContainerImpl> step = unitCoupleList.iterator();
        while (step.hasNext()) {
            UnitCoupleContainerImpl gaither = step.next();
            if (gaither.canProcess("D")) {
                return gaither.getData();
            }
        }
        return Collections.emptyList();
    }

    public void fileDataSeparate(String resourceFile) throws ExitException {
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
        System.out.println(stringFromFile);
        for (UnitCoupleContainerImpl gaither : unitCoupleList) {
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
        unitCoupleList.add(new Unreachable());
    }

}
