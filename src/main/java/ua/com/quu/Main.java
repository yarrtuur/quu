package ua.com.quu;

import ua.com.quu.data_source.DataContainer;
import ua.com.quu.utils.ResourceLoader;

public class Main {
	public static void main(String[] args) {
		String resourceFile = "resourses/"+args[0];
		System.out.println(resourceFile);
        ResourceLoader resourceLoader= new ResourceLoader(resourceFile);
		DataContainer dataContainer = new DataContainer(resourceLoader);
	}
}
