package pageLayer;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TDDBase;

public class TDDAddCorporatePage extends TDDBase{
	
	//***************Customer Details*****************
	@FindBy(xpath="//div[@class='col-sm-6']/input")
	WebElement clientName;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div/fieldset/div[2]/div/select")
	WebElement workFlow;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div/fieldset/div[3]/div/select")
	WebElement rateStructure;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div/fieldset/div[4]/div/select")
	WebElement ruleSet;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div/fieldset/div[5]/div/select")
	WebElement flatFeeRule;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div/fieldset/div[6]/div/select")
	WebElement NLVRule;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div/fieldset/div[8]/div/input")
	WebElement isCustomer;
	
	
	
	//*********Preferred Relationship/Fee Offer/Time Keeper*********
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div[3]/fieldset[1]/div/div/input")
	WebElement  lawFirmRelation;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div[3]/fieldset[1]/div[2]/div/select")
	WebElement keeperUser;
	
	//***************Office User****************
	@FindBy(xpath="//div[@id=\"page-container\"]/div/div[2]/div[2]/form/div[3]/fieldset[2]/div[1]/div[1]/input")
	WebElement firstName;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div[3]/fieldset[2]/div[2]/div[1]/input")
	WebElement lastName;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div[3]/fieldset[2]/div[3]/div/input")
	WebElement email;
	
	//***************Division/Office**********
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div[1]/fieldset[2]/div[1]/div/input")
	WebElement division;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div[1]/fieldset[2]/div[2]/div/input")
	WebElement office;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div[1]/fieldset[2]/div[3]/div/input")
	WebElement address1;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div[1]/fieldset[2]/div[4]/div/input")
	WebElement address2;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div[1]/fieldset[2]/div[6]/div/input")
	WebElement city;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div[1]/fieldset[2]/div[7]/div[1]/select")
	WebElement state;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div[1]/fieldset[2]/div[7]/div/input")
	WebElement zipCode;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/form/div[1]/fieldset[2]/div[8]/div/input")
	WebElement phoneNo;
	
	//***************SAVE Btn************
	@FindBy(id="save")
	WebElement createCustomerBtn;
	
	@FindBy(xpath="//div[@id='page-container']/div/div[2]/div[2]/fieldset/li/a")
	static
	WebElement clientNameLink;
	
	
	
	
	public TDDAddCorporatePage() {
		PageFactory.initElements(driver, this);
	}
	
	public TDDViewClientPage validateEnterData(String cn, String wf,String lf,String tp,String fn, String ln, String em,String div, String off,String adrss1, String ct, String st, String zp, String phn) {
		clientName.sendKeys(cn);
		selectOption(workFlow,wf); 
		getlawFirmRelationship(lawFirmRelation,lf);
		selectOption(keeperUser,tp);
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		email.sendKeys(em);
		division.clear();
		division.sendKeys(div);
		office.clear();
		office.sendKeys(off);
		address1.sendKeys(adrss1);
		city.sendKeys(ct);
		selectOption(state,st);
		zipCode.sendKeys(zp);
		phoneNo.sendKeys(phn);
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		createCustomerBtn.click();
		waitApply();
		return new TDDViewClientPage();
		
	}
	
	public static void selectOption(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public static void getlawFirmRelationship(WebElement element,String val) {
		element.sendKeys(val);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']/li/a/span"));
		System.out.println("Length is :" +list.size());
		for(int i=0;i<=list.size();i++) {
		list.get(i).getText();
		if(list.get(i).getText().equals(val)) {
		list.get(i).click();
		break;
		}
			
		}
		
	}
	
	public static void waitApply() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(clientNameLink)).click();
		
				
	}
	/*public void getlawFirm() {
		lawFirmRelation.sendKeys("Beer Institute, Washington");
		//WebElement x = driver.findElement(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']/li[1]/a/span"));
		//System.out.println(x.getText());
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']/li/a/span"));
		System.out.println("Length is :" +list.size());
		for(int i=0; i<=list.size();i++) {
		System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("Beer Institute, Washington")) {
				list.get(i).click();
				break;
		}
			
		}
		
	}*/
}

