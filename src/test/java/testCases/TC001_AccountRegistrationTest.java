package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		try {
		logger.info("******** Starting TC001_AccountRegistrationTest*********");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Registr Link");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing cutomer details....");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");//randomly generated the email
		regpage.setTelephone(randomeNumber());
		String password=randomeAlphaNumberic();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validationg expected message....");
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{

			logger.error("Test failed....");
			logger.debug("Debug logs....");
			Assert.assertTrue(false);
		}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info("******Finished***********");
	
	

	}
}
