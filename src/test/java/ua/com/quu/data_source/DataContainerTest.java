package ua.com.quu.data_source;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.quu.utils.ResourceLoader;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DataContainerTest {
    private List queryUnitList;
    private List waitingUnitList;
    private ResourceLoader resourceLoaderMock;
    private DataContainer dataContainer;

    @Before
    public void setUp() throws Exception {
        queryUnitList = new LinkedList<>();
        waitingUnitList = new LinkedList();
    }

    @After
    public void tearDown() throws Exception {
        queryUnitList = null;
        waitingUnitList = null;
    }

    @Test
    public void getQueryUnitListTest() throws Exception {
        resourceLoaderMock= mock(ResourceLoader.class);
        DataContainer dataContainer = new DataContainer(resourceLoaderMock);
        when(resourceLoaderMock.fillFulQueryUnitList()).thenReturn(anyList());
        assertEquals(anyList(), dataContainer.getQueryUnitList());
    }

    @Test
    public void getWaitingUnitListTest() throws Exception {
        resourceLoaderMock = mock(ResourceLoader.class);
        DataContainer dataContainer = new DataContainer(resourceLoaderMock);
        when(resourceLoaderMock.fillFulWaitingUnitList()).thenReturn(anyList());
        assertEquals(anyList(), dataContainer.getWaitingUnitList());
    }
}