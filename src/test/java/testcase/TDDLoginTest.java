package testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TDDBase;
import pageLayer.TDDHomepage;
import pageLayer.TDDLoginPage;

public class TDDLoginTest extends TDDBase {
	
	TDDLoginPage tddLogin;
	TDDHomepage tddHomePage;
	
	public TDDLoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		tddLogin = new TDDLoginPage();
		tddHomePage = new TDDHomepage();
	
	}
	
	@Test(priority=1)
	public void validateLogin() {
		tddHomePage =tddLogin.validatelogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
}
