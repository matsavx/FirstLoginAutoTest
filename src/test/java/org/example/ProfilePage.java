package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/a[1]/span[1]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/ul/ul/li[6]/a")
    private WebElement logoutBtn;

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'account__name_hasAccentLetter')]")));
        String userName = userMenu.getText();
        return userName;
    }

    public void entryMenu() {
        userMenu.click();
    }

    public void userLogout() {
        logoutBtn.click();
    }
}