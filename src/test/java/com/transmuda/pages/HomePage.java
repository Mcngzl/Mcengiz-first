package com.transmuda.pages;

import com.transmuda.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(){PageFactory.initElements(Driver.getDriver(), this);}



    @FindBy(css = "a[href='javascript: void(0);']")
    public WebElement userMenuDropdown;
    @FindBy(xpath = "//a[@href='/user/logout']")
    public WebElement logoutbutton;

    @FindBy(xpath = "//a[@title='Fleet Management']")
    public WebElement fleetManagementTitle;

    @FindBy (xpath = "//*[@class=\"dropdown dropdown-level-1 align-menu-right\"]")
    public WebElement fleetdropdownButton;

    @FindBy (xpath = "//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span")
    public  WebElement vehicleButton;

    @FindBy (xpath = "//*[@id=\"grid-custom-entity-grid-748185635\"]/div[2]/div[1]/div/div[3]/div[1]/div/div/a/i")
    public WebElement geariconButton;


    @FindBy (xpath = "//*[@id=\"grid-custom-entity-grid-748185635\"]/div[2]/div[1]/div/div[3]/div[1]/div/div/div/div[1]")
    public WebElement gridsettingsBox;

}
