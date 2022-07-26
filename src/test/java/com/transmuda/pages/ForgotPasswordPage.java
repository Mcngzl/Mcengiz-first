package com.transmuda.pages;

import com.transmuda.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage{

    public ForgotPasswordPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"prependedInput\"]")
    public WebElement girforgotpassword;

    @FindBy(xpath = "//*[@id=\"central-panel\"]/div/div/div[1]/form/fieldset/div/button")
    public WebElement request;

    @FindBy(xpath = "//*[@id=\"central-panel\"]/div/div/div[1]/form/fieldset/div[1]")
    public WebElement alertunablechangepassword;

}
