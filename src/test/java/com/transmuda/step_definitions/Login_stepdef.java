package com.transmuda.step_definitions;

import com.transmuda.pages.ForgotPasswordPage;
import com.transmuda.pages.HomePage;
import com.transmuda.pages.LoginPage;
import com.transmuda.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Login_stepdef {

    LoginPage loginPage = new LoginPage();
    ForgotPasswordPage forgotPasswordPage =new ForgotPasswordPage();
    HomePage homePage =new HomePage();


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
        loginPage.login("user1", "UserUser123");
        String url = Driver.getDriver().getCurrentUrl();
        System.out.println("url =" + url);
        Driver.getDriver().close();

    }

    @And("pass the url again")
    public void passTheUrlAgain() {

        Driver.getDriver().get("http://qa.transmuda.com/user/login");
        Driver.getDriver().get("http://qa.transmuda.com/");


    }

    @Then("user should not login")
    public void userShouldNotLogin() {
        String curentUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "http://qa.transmuda.com/";
        Assert.assertEquals(expectedUrl, curentUrl);
    }

    @When("user wrote wrong username or password")
    public void userWroteWrongUsernameOrPassword() {
        loginPage.girUsername.sendKeys("user3asjkdskjd");
        loginPage.girpassword.sendKeys("UserUser123asdfrgsdgsdf");
        loginPage.basloginButton.click();


    }

    @Then("user must see massage")
    public void userMustSeeMassage() {
        String message1 = loginPage.invalidmessage.getText();
        System.out.println("message1 = " + message1);
        Assert.assertTrue(loginPage.invalidmessage.isDisplayed());


    }

    @When("user wrote his password")
    public void userWroteHisPassword() {
        loginPage.girpassword.sendKeys("UserUser123");


    }

    @Then("user should see bulletsign")
    public void userShouldSeeBulletsign() {
        boolean isbulletsign = loginPage.girpassword.getAttribute("type").equals("password");
        Assert.assertTrue(isbulletsign);
    }

    @When("user do not write usernae or password")
    public void userDoNotWriteUsernaeOrPassword() {
        loginPage.basloginButton.click();
    }

    @Then("user should see the please fill message")
    public void userShouldSeeThePleaseFillMessage() {

        String expectedmessage = "Please fill out this field.";
        String fillmessage= loginPage.girpassword.getAttribute("validationMessage");

        Assert.assertEquals(expectedmessage,fillmessage);



    }

    @When("click on the Forgot your password link")
    public void clickOnTheForgotYourPasswordLink() {
        loginPage.forgotpassword.click();
    }

    @Then("user should see forgot password page")
    public void userShouldSeeForgotPasswordPage() {
        String expectedtitle = "Forgot Password";
        String actualtitle = Driver.getDriver().getTitle();
        System.out.println("actualtitle = " + actualtitle);
        Assert.assertEquals(actualtitle,expectedtitle);
    }

    @Then("user can change password with username")
    public void userCanChangePasswordWithUsername() {
        forgotPasswordPage.girforgotpassword.sendKeys("user1");
        forgotPasswordPage.request.click();
        String expectedresult ="Password change";

        String actualresult =forgotPasswordPage.alertunablechangepassword.getText();
        System.out.println("actualresult = " + actualresult);
        Assert.assertEquals(expectedresult,actualresult);


    }

    @When("user click remember me check box")
    public void userClickRememberMeCheckBox() {
        loginPage.rememberCheckBox.click();
    }

    @And("login and logout")
    public void loginAndLogout() {
        loginPage.girUsername.sendKeys("user1");
        loginPage.girpassword.sendKeys("UserUser123");
        loginPage.basloginButton.click();

    }

    @Then("user can able to login again")
    public void userCanAbleToLoginAgain() {
        homePage.userMenuDropdown.click();
        homePage.logoutbutton.click();
        loginPage.basloginButton.click();
        String expectedtitle1 ="Dashboard";
        String actualTitle1 = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedtitle1,actualTitle1);
    }

    @When("user wrote his username click enter")
    public void userWroteHisUsernameClickEnter() throws InterruptedException {
        loginPage.girUsername.sendKeys("user1", Keys.ENTER);
        Driver.getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        Driver.getDriver().wait(3000);
    }

    @And("user wrote his password click enter")
    public void userWroteHisPasswordClickEnter() {
        loginPage.girpassword.sendKeys("UserUser123",Keys.ENTER);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.basloginButton.click();
    }

    @Then("user should login")
    public void userShouldLogin() {
        String expectedTitle2 ="Dashboard";
       // String actualTitle2 = Driver.getDriver().getTitle();
        String actualTitle2 = homePage.fleetManagementTitle.getAttribute("innerText");
        Assert.assertEquals(expectedTitle2,actualTitle2);
    }

    @When("user wrote his username and password")
    public void userWroteHisUsernameAndPassword() {
        loginPage.girUsername.sendKeys("user1");
        loginPage.girpassword.sendKeys("UserUser123");
        loginPage.basloginButton.click();
    }

    @Then("should see his username on profile menu")
    public void shouldSeeHisUsernameOnProfileMenu() {
        String expectedusername="user1";
        String actualusername = homePage.userMenuDropdown.getAttribute("innerText");
        System.out.println("actualusername = " + actualusername);
        Assert.assertEquals(expectedusername,actualusername);

    }
}