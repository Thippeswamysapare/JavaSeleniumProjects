package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
	
	public WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// Billing Address Dropdown
		@FindBy(id="billing-address-select")
		private WebElement billingAddressDroddown;
		
		@FindBy(id="BillingNewAddress_FirstName")
		private WebElement billingAddressFname;
		
		@FindBy(id="BillingNewAddress_LastName")
		private WebElement billingAddressLname;
		
		@FindBy(id="BillingNewAddress_Email")
		private WebElement billingAddressEmail;
		
		@FindBy(id="BillingNewAddress_Company")
		private WebElement billingAddressCompany;
		
		@FindBy(id="BillingNewAddress_CountryId")
		private WebElement billingAddressCountryDD;
		
		@FindBy(id="BillingNewAddress_StateProvinceId")
		private WebElement billingAddressStateDD;
		
		@FindBy(id="BillingNewAddress_City")
		private WebElement billingAddresscity;

		@FindBy(id="BillingNewAddress.Address1")
		private WebElement billingAddressAddress1;
		
		@FindBy(id="BillingNewAddress_Address2")
		private WebElement billingAddressAddress2;
		
		@FindBy(id="BillingNewAddress_ZipPostalCode")
		private WebElement billingAddressZipPostalCode;
		
		@FindBy(id="BillingNewAddress_PhoneNumber")
		private WebElement billingAddressPhoneNumber;
		
		@FindBy(id="BillingNewAddress_FaxNumber")
		private WebElement billingAddressFaxNumber;
	
		@FindBy(xpath="//input[@onclick='Billing.save()']")
		private WebElement ContinueBtnInBillingAddressSec;
		//input[@onclick='Billing.save()']
		
	//Shipping Address Dropdown
	

		
		@FindBy(id="shipping-address-select")
		private WebElement ShippingAddressDropdown;
		
		@FindBy(id="ShippingNewAddress_FirstName")
		private WebElement ShippingAddrsFName;
		
		@FindBy(id="ShippingNewAddress_LastName")
		private WebElement ShippingAddrsLName;
		
		@FindBy(id="ShippingNewAddress_Email")
		private WebElement ShippingAddrsEmail;
		
		@FindBy(id="ShippingNewAddress_Company")
		private WebElement ShippingAddrsCompany;
		
		@FindBy(id="ShippingNewAddress_CountryId")
		private WebElement ShippingAddrsCountryDropDown;
		
		@FindBy(id="ShippingNewAddress_StateProvinceId")
		private WebElement ShippingAddrsStateDropDown;
		
		@FindBy(id="ShippingNewAddress_City")
		private WebElement ShippingAddrsCity;

		@FindBy(id="ShippingNewAddress.Address1")
		private WebElement ShippingAddrsAddress1;
		
		@FindBy(id="ShippingNewAddress_Address2")
		private WebElement ShippingAddrsAddress2;
		
		@FindBy(id="ShippingNewAddress_ZipPostalCode")
		private WebElement ShippingAddrsZipPostalCode;
		
		@FindBy(id="ShippingNewAddress_PhoneNumber")
		private WebElement ShippingAddrsphoneNumber;
		
		@FindBy(id="ShippingNewAddress_FaxNumber")
		private WebElement ShippingAddrsfaxNumber;
		
	
	
	@FindBy(id="PickUpInStore")
	private WebElement PickUpInStoreCheckBox;
	
	@FindBy(xpath="//input[@onclick='Shipping.save()']")
	private WebElement ContinueBtnInShippingAddSec;
	
	@FindBy(xpath="//input[@onclick='ShippingMethod.save()']")
	private WebElement ContinueBtnInShippingMethodSec;
	
	@FindBy(xpath="//input[@onclick='PaymentMethod.save()']")
	private WebElement ContinueBtnInPaymentSec;
	
	@FindBy(xpath="//input[@onclick='PaymentInfo.save()']")
	private WebElement ContinueBtnInPaymentInforSec;
	
	@FindBy(xpath="//input[@onclick='ConfirmOrder.save()']")
	private WebElement ConfirmOrderBtn;
	
	
	
	// Billing Address details 
	
	public List<String> clickOnBillingAddressDropDown()
	{
		
		Select select=new Select(billingAddressDroddown);
		List<WebElement> options=select.getOptions();
		//return options;
		
		List<String> addressList= new ArrayList<>();
		for(WebElement ele : options)
		{
			addressList.add(ele.getText());
		}
		return addressList;
		
	}
	
	public void SelectBillingAddressByVisitbleText(String addressName)
	{
		
		Select select=new Select(billingAddressDroddown);
		select.selectByVisibleText(addressName);
		
	}
	
	public void SelectBillingAddressByIndex(int Index)
	{
		
		Select select=new Select(billingAddressDroddown);
		List<WebElement> options=select.getOptions();
		if(options.size()>=2)
		{
		select.selectByIndex(Index);
		}
		
	}

	public void enterBillingAddressFirstName(String firstName)
	{
		String fName=billingAddressFname.getText();
		if (fName.isBlank())
		{
			billingAddressFname.sendKeys(firstName);
		}
	}
	
	public void enterBillingAddressLasttName(String lastName)
	{
		String lName=billingAddressLname.getText();
		if (lName.isBlank())
		{
			billingAddressLname.sendKeys(lastName);
		}
	}
	
	public void enterBillingAddressEmail(String newEmail)
	{
		String email=billingAddressEmail.getText();
		if (email.isBlank())
		{
			billingAddressEmail.sendKeys(newEmail);
		}
	}
	
	public void enterBillingAddressCompany(String companyName)
	{
		String Name=billingAddressCompany.getText();
		if (Name.isBlank())
		{
			billingAddressCompany.sendKeys(companyName);
		}
	}
	
	public void selectBillingAddressCountry(String countryName)
	{
		Select select = new Select(billingAddressCountryDD);
		select.selectByVisibleText(countryName);
	}
	
	public void selectBillingAddressState(String StateName)
	{
		Select select = new Select(billingAddressStateDD);
		select.selectByVisibleText(StateName);
	}
	
	public void enterBillingAddressCity(String cityName)
	{
		String cityname=billingAddresscity.getText();
		if(cityname.isEmpty())
		{
			billingAddresscity.sendKeys(cityName);
		}
	}
	
	public void enterBillingAddressAddress1(String address1Details)
	{
		String address1Name=billingAddressAddress1.getText();
		if(address1Name.isEmpty())
		{
			billingAddressAddress1.sendKeys(address1Details);
		}
	}
	
	public void enterBillingAddressAddress2(String address1Details)
	{
		String address2Name=billingAddressAddress2.getText();
		if(address2Name.isEmpty())
		{
			billingAddressAddress2.sendKeys(address1Details);
		}
	}
	
	public void enterBillingAddressPostalCode(String postalCode)
	{
		String postalcode=billingAddressZipPostalCode.getText();
		if(postalcode.isEmpty())
		{
			billingAddressZipPostalCode.sendKeys(postalCode);
		}
	}
	
	public void enterBillingAddressphoneNumber(String newPhoneNo)
	{
		String phone=billingAddressPhoneNumber.getText();
		if(phone.isEmpty())
		{
			billingAddressPhoneNumber.sendKeys(newPhoneNo);
		}
	}
	
	public void enterBillingAddressfaxNumber(String newFaxNo)
	{
		String fax=billingAddressFaxNumber.getText();
		if(fax.isEmpty())
		{
			billingAddressFaxNumber.sendKeys(newFaxNo);
		}
	}
	
	
	//-----------------Shipping Address details--------------------------------------
	
	public List<String> clickOnShippingAddressDropDown()
	{
		
		Select select=new Select(ShippingAddressDropdown);
		List<WebElement> options=select.getOptions();
		List<String> billingAddressList=new ArrayList<>();
		for(WebElement ele: options)
		{
			billingAddressList.add(ele.getText());
		}
		return billingAddressList;
		
	}
	
	public void SelectShippingAddressByVisitbleText(String addressName)
	{
		
		Select select=new Select(ShippingAddressDropdown);
		select.selectByVisibleText(addressName);
		
	}
	
	public void SelectShippingAddressByIndex(int Index)
	{
		
		Select select=new Select(ShippingAddressDropdown);
		List<WebElement> options=select.getOptions();
		if(options.size()>=2)
		{
		select.selectByIndex(Index);
		}
		
	}
	
	public void enterShippingAddressFirstName(String firstName)
	{
		String fName=ShippingAddrsFName.getText();
		if (fName.isBlank())
		{
			ShippingAddrsFName.sendKeys(firstName);
		}
	}
	
	public void enterShippingAddressLasttName(String lastName)
	{
		String lName=ShippingAddrsLName.getText();
		if (lName.isBlank())
		{
			ShippingAddrsLName.sendKeys(lastName);
		}
	}
	
	public void enterShippinggAddressEmail(String newEmail)
	{
		String email=ShippingAddrsEmail.getText();
		if (email.isBlank())
		{
			ShippingAddrsEmail.sendKeys(newEmail);
		}
	}
	
	public void enterShippingAddressCompany(String companyName)
	{
		String Name=ShippingAddrsCompany.getText();
		if (Name.isBlank())
		{
			ShippingAddrsCompany.sendKeys(companyName);
		}
	}
	
	public void selectShippingAddressCountry(String countryName)
	{
		Select select = new Select(ShippingAddrsCountryDropDown);
		select.selectByVisibleText(countryName);
	}
	
	public void selectShippingAddressState(String StateName)
	{
		Select select = new Select(ShippingAddrsStateDropDown);
		select.selectByVisibleText(StateName);
	}
	
	public void enterShippingAddressCity(String cityName)
	{
		String cityname=ShippingAddrsCity.getText();
		if(cityname.isEmpty())
		{
			ShippingAddrsCity.sendKeys(cityName);
		}
	}
	
	public void enterShippingAddressAddress1(String address1Details)
	{
		String address1Name=ShippingAddrsAddress1.getText();
		if(address1Name.isEmpty())
		{
			ShippingAddrsAddress1.sendKeys(address1Details);
		}
	}
	
	public void enterShippingAddressAddress2(String address1Details)
	{
		String address2Name=ShippingAddrsAddress2.getText();
		if(address2Name.isEmpty())
		{
			ShippingAddrsAddress2.sendKeys(address1Details);
		}
	}
	
	public void enterShippingAddressPostalCode(String postalCode)
	{
		String postalcode=ShippingAddrsZipPostalCode.getText();
		if(postalcode.isEmpty())
		{
			ShippingAddrsZipPostalCode.sendKeys(postalCode);
		}
	}
	
	public void enterShippingAddressphoneNumber(String newPhoneNo)
	{
		String phone=ShippingAddrsphoneNumber.getText();
		if(phone.isEmpty())
		{
			ShippingAddrsphoneNumber.sendKeys(newPhoneNo);
		}
	}
	
	public void enterShippingAddressfaxNumber(String newFaxNo)
	{
		String fax=ShippingAddrsfaxNumber.getText();
		if(fax.isEmpty())
		{
			ShippingAddrsfaxNumber.sendKeys(newFaxNo);
		}
	}
	
	public void clickOnContinueInBillinggAddressSection()
	{
		ContinueBtnInBillingAddressSec.click();
	}
	
	public void clickOnStorePick()
	{
		PickUpInStoreCheckBox.click();
	}
	
	public void clickOnContinueInShippingAddressSection()
	{
		ContinueBtnInShippingAddSec.click();
	}
	
		
	public void clickOnContinueInShippingMethodSection()
	{
		ContinueBtnInShippingMethodSec.click();
	}
	
	public void clickOnContinueInPaymentMethodSection()
	{
		ContinueBtnInPaymentSec.click();
	}
	
	public void clickOnContinueInPaymentInfoSection()
	{
		ContinueBtnInPaymentInforSec.click();
	}
	
	// Click on Confirm button in Confirm order section
	public OrderCompletedPage clickOnConfirmOrderBtn()
	{
		ConfirmOrderBtn.click();
		return new OrderCompletedPage(driver);
	}
	
	public WebDriver getCheckOutPageDriver()
	{
		return driver;
	}
}
