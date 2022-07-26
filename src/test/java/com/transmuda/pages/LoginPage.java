package com.transmuda.pages;

import com.transmuda.utilities.Driver;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"prependedInput\"]")
    public WebElement girUsername;

    @FindBy(xpath = "//*[@id=\"prependedInput2\"]")
    public WebElement girpassword;


    @FindBy(xpath = "//*[@id=\"_submit\"]")
    public WebElement basloginButton;

    @FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/div[1]")
            public WebElement invalidmessage;

    @FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/div[3]/a")
    public WebElement forgotpassword;


    @FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/div[2]/label/span[1]")
    public WebElement rememberCheckBox;









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
