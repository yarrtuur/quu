package ua.com.quu;

import ua.com.quu.data_source.DataContainer;
import ua.com.quu.depend_tools.DependData;
import ua.com.quu.utils.ResourceLoader;

public class Main {
    public static void main(String[] args) {
        String resourceFile = args[0];
        ResourceLoader resourceLoader = new ResourceLoader(resourceFile);
        DataContainer dataContainer = new DataContainer(resourceLoader);
        DependData dependData = new DependData(dataContainer);
    }
}
