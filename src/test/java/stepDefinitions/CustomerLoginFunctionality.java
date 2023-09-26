package stepDefinitions;
import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import org.testng.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.CustomerHomePage;
import pages.CustomerLoginPage;
import pages.EmployeeLoginPage;
import pages.LandingPage;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*; //for all Assert methods by * sing
import static org.junit.Assert.*;

public class CustomerLoginFunctionality extends Base {

    @Given("I am in Landing Page")
    public void i_am_in_landing_page() throws IOException {

        navigate("http://it.microtechlimited.com");
      screenShotWithName(driver,"Landing Page of Application");

    }

    @Then("I click on Login Menu")
    public void i_click_on_login_menu() {

        click( LandingPage.menuLogin );
    }

    @Then("I click on Customer Login Menu")
    public void i_click_on_customer_login_menu() throws IOException {
        click(CustomerLoginPage.menuCustomerLogin );
        screenShotWithName(driver,"Customer Login Page");
    }


    @Then("I Enter Customer User Id")
    public void i_enter_customer_user_id() {

        sendKeys(CustomerLoginPage.textCustomerUserId,"david@gmail.com");
    }

    @Then("I enter Customer Password")
    public void i_enter_customer_password() {
    sendKeys(CustomerLoginPage.textCustomerPassword,"1234");
    }

    @When("I click on Customer Login button")
    public void i_click_on_customer_login_button() {

        click(CustomerLoginPage.btnCustomerLogin);
    }
    @Then("Verify I am in Customer Home Page")
    public void verify_i_am_in_customer_home_page() throws IOException {
        String welcomeMsg = getText( CustomerHomePage.labelWelcomeMsg );
        //assertEquals( "Welcome tania", welcomeMsg);
        soft.assertThat("Welcome tania").isEqualTo(welcomeMsg);
        screenShotWithName(driver,"Customer Home Page");
        System.out.println("tania");
        soft.assertAll();
    }


}