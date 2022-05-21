package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pages.SignInPage.driver;

public class CasualDressPage {
  //static WebDriver driver;
  @FindBy(css = ".product-container")
  static
  WebElement casualdresshover;
  @FindBy(css = ".button.ajax_add_to_cart_button.btn.btn-default")
  static
  WebElement addtochart;

  @FindBy(css = ".col-md-6 > div.button-container > a")
  static
  WebElement proceedbutton;


/*  WebElement btn = driver
          .findElement(By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default"));
    btn.click();*/


    /* WebElement dress = driver
            .findElement(By.cssSelector(".product-container"));
    action.moveToElement(dress).build().perform();*/

  public CasualDressPage(WebDriver driver) {
   // this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public static void hoverDress() {
    Actions action = new Actions(driver);
    action.moveToElement(casualdresshover).build().perform();
  }

  public static void addToChart() {
    addtochart.click();
  }
  public static OrderPage proceedOnPopUp(){
    proceedbutton.click();
    return new OrderPage(driver);

  }
}