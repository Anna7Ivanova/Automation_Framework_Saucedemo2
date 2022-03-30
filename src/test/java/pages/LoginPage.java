package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(css = "[placeholder=Password]")
    private WebElement passwordInput;

    @FindBy(css = "[value=Login]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[text()='Epic sadface: Username and password do not match any user in this service']")
    private WebElement genericErrorMessage;

    @FindBy(xpath = "the other locator")
    private WebElement usernameEmptyErrorMessage;

    @FindBy(xpath = "the other locator")
    private WebElement passwordEmptyErrorMessage;

    @FindBy(xpath = "//button[@class='error-button']")
    private WebElement xButtonOfLoginErrorMessages;

    //constructor for each page
    public LoginPage(WebDriver driver) {
        this.driver = driver;//initialize driver
        PageFactory.initElements(driver, this);//initialize elements
    }

    public ProductsPage login(String username, String password) {
        userNameInput.click();
        userNameInput.sendKeys(username);

        //fluent wait should be here
        passwordInput.click();
        passwordInput.sendKeys(password);

        loginBtn.click();

        return new ProductsPage(driver);
    }

    public void tryToLogin(String username, String password) {//unsuccessful login
        userNameInput.click();
        userNameInput.sendKeys(username);

        passwordInput.click();
        passwordInput.sendKeys(password);
        loginBtn.click();

        /*try {
            WebElement productsMenu = driver.findElement(By.id("react-burger-menu-btn"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;*/
    }

    public boolean isLoginErrorMessageShown(){
        /*try {
            return genericErrorMessage.isDisplayed() || usernameEmptyErrorMessage.isDisplayed() || passwordEmptyErrorMessage.isDisplayed();
               }catch(NoSuchElementException e){
             //do some needed logic here
            return false;
               }*/
        return xButtonOfLoginErrorMessages.isDisplayed();
    }
}