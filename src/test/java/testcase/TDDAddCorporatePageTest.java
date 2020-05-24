package testcase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TDDBase;
import pageLayer.TDDAddCorporatePage;
import pageLayer.TDDHomepage;
import pageLayer.TDDLoginPage;
import utilities.TDDUtil;

public class TDDAddCorporatePageTest extends TDDBase {
	
	TDDLoginPage tddLogin;
	TDDHomepage tddHomePage;
	TDDAddCorporatePage tddAddClient;
	
	public TDDAddCorporatePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		tddLogin = new TDDLoginPage();
		tddHomePage = new TDDHomepage();
		tddAddClient = new TDDAddCorporatePage();
		tddLogin.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
		tddHomePage.validateClientAddLink();
		
	
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TDDUtil.getExcelSheetData();
		return testData.iterator();
	}
	
	@Test(dataProvider="getTestData")
	public void validateEnterDataTest(String clientname, String workflow, String lawfirmrelation,String timekeeper,String firstname,String lastname,String email,String division,String office,String address, String city, String state, String zip, String phone) {
		tddAddClient.validateEnterData(clientname,workflow,lawfirmrelation,timekeeper,firstname,lastname,email,division,office,address,city,state,zip,phone);
		
	}
	
	
}
