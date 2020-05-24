package testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TDDBase;
import pageLayer.TDDHomepage;
import pageLayer.TDDLoginPage;

public class TDDHomepageTest extends TDDBase{
		
	TDDLoginPage tddLogin;
	TDDHomepage tddHomePage;
	
	public TDDHomepageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		tddLogin = new TDDLoginPage();
		tddHomePage = new TDDHomepage();
		tddLogin.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority=1)
	public void validateClientAddLinkTest() {
		tddHomePage.validateClientAddLink();
	}
	
	
}
