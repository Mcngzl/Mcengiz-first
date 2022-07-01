package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_stepdef {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the transmuda login page")
    public void user_is_on_the_transmuda_login_page() {
        Driver.getDriver().get("http://qa.transmuda.com/user/login");

    }
    @When("user enters sales manager username")
    public void user_enters_sales_manager_username() {

            loginPage.girUsername.sendKeys("user1");
    }

    @When("user enters sales manager password")
    public void user_enters_sales_manager_password() {
        loginPage.girpassword.sendKeys("UserUser123");
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        loginPage.basloginButton.click();

    }

    @When("user enters store manager username")
    public void userEntersStoreManagerUsername() {
        loginPage.girUsername.sendKeys("user2");
    }

    @And("user enters store manager password")
    public void userEntersStoreManagerPassword() {
        loginPage.girpassword.sendKeys("UserUser123");
    }

    @When("user enters truck driver username")
    public void userEntersTruckDriverUsername() {
        loginPage.girUsername.sendKeys("user3");
    }

    @And("user enters truck driver password")
    public void userEntersTruckDriverPassword() {
        loginPage.girpassword.sendKeys("UserUser123");
    }

    @When("user get url and log out")
    public void userGetUrlAndLogOut() throws InterruptedException {
        loginPage.login("user1","UserUser123");
        String url =Driver.getDriver().getTitle();
        System.out.println("url ="+url);
        Driver.getDriver().close();

    }

    @And("pass the url again")
    public void passTheUrlAgain() {

       // Driver.getDriver().get("");


    }

    @Then("user should not login")
    public void userShouldNotLogin() {
    }
}
