package test.java.com.peoplesoft.container.test;

import java.util.Arrays;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Run {
	public static void main(String[] strs)	{
		TestNG testng = new TestNG();
		XmlTest xmlTest = new XmlTest();
		xmlTest.setName("Sample Test");
		xmlTest.addParameter("path", strs[1]);
		xmlTest.addParameter("driverpath", strs[0]);
		xmlTest.setClasses(Arrays.asList(new XmlClass(PeopleSoftTest.class)));
		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName("Sample Suite");
		xmlTest.setSuite(xmlSuite);
		xmlSuite.setTests(Arrays.asList(xmlTest));
		testng.setXmlSuites(Arrays.asList(xmlSuite));
		testng.run();

	}
}
