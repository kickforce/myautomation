package MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.SignInPage;
import pages.TshirtPage;

public class  MainPage {
  protected static WebDriver driver;
  @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
  static

  WebElement dresses;
  @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a")
  static
  WebElement casualdress;
  @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
  static
  WebElement tshirt;

  public MainPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);

  }

  public static SignInPage  openPage(String urladdres) {
      driver.get(urladdres);
    return new SignInPage(driver);
  }

  public static void dressesTopMenu() {
    Actions action = new Actions(driver);
    action.moveToElement(dresses).build().perform();
  }

  public static TshirtPage tshirtTopMenu() {
    tshirt.click();
    return new TshirtPage(driver);
  }

  public static void casualdress() {
    casualdress.click();
  }

  public static void switchToWindow() {
    driver.switchTo().activeElement();
  }

}
