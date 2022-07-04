package com.transmuda.pages;

import com.transmuda.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"prependedInput\"]")
    public WebElement girUsername;

    @FindBy(xpath = "//*[@id=\"prependedInput2\"]")
    public WebElement girpassword;


    @FindBy(xpath = "//*[@id=\"_submit\"]")
    public WebElement basloginButton;

    public void login(){
        this.girUsername.sendKeys("salesmanager");
        this.girpassword.sendKeys("UserUser123");
        this.basloginButton.click();
    }

    public void login(String username, String password){
        girUsername.sendKeys(username);
        girpassword.sendKeys(password);
        basloginButton.click();
    }


}
