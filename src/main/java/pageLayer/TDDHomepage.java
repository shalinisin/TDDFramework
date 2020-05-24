package pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TDDBase;

public class TDDHomepage extends TDDBase{
	
	@FindBy(linkText="Add Corporate Customer (Simplified One Step)")
	WebElement addClientLink;
	
	
	public TDDHomepage() {
		PageFactory.initElements(driver, this);
	}
	
	public TDDAddCorporatePage validateClientAddLink() {
		addClientLink.click();
		return new TDDAddCorporatePage();
	}

}
