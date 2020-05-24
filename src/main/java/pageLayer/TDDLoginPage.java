package pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import base.TDDBase;

public class TDDLoginPage extends TDDBase {
	
	@FindBy(name="username")
	WebElement username;
	
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="btnSignIn")
	WebElement signIn;
	
	public TDDLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public TDDHomepage validatelogin(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		signIn.click();
		return new TDDHomepage();
	}
	
	
	
}
