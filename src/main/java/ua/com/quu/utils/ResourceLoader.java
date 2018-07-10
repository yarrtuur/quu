package ua.com.quu.utils;

import ua.com.quu.data_source.UnitTypesImpl;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ResourceLoader implements ResourceLoaderImpl {
    private List<UnitCoupleContainerImpl> unitCoupleList;

    public ResourceLoader(String resourceFile) {
        try {
            initUnitCouple();
            fileDataSeparate(resourceFile);
        } catch (ExitException e) {
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
             BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        ) {
            //todo read from file
            int rowsCount = Integer.parseInt(reader.readLine());
            while(reader.ready()){
                putRightContainer(reader.readLine());
            }

        } catch (IOException | NullPointerException e) {
            throw new ExitException("No resource file found in " + e.getMessage());
        }
    }

    private void putRightContainer(String stringFromFile) {
        Iterator<UnitCoupleContainerImpl> step = unitCoupleList.iterator();
        while (step.hasNext()) {
            UnitCoupleContainerImpl gaither = step.next();
            if (gaither.canProcess(stringFromFile)) {
                gaither.setData(stringFromFile);
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
