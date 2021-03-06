package com.example.myautomation;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;

public class MainPageTest {

  @Test
  public void openPageChrome() {
    Selenide.open("https://devby.io/");
    Selenide.$("div.navbar__row > nav > a:nth-child(1)").shouldHave(text("Новости"));
    Selenide.closeWindow();
  }

  @Test
  public void openPageFox() {
    System.setProperty("selenide.browser", "firefox");
    Selenide.open("https://devby.io/");
    Selenide.closeWindow();
  }

  @Test
  public void celeniumOpenPageFox() {
    System.setProperty("webdriver.gecko.driver", "/Users/vitali/IdeaProjects/geckodriver");
    WebDriver driver = new FirefoxDriver();
    String url = "https://devby.io/";
    driver.get(url);
    driver.close();
  }

  @Test
  public void celeniumOpenPageChrome() {
    System.setProperty("webdriver.chrome.driver", "/Users/vitali/IdeaProjects/chromedriver");
    WebDriver driver = new ChromeDriver();
    String url = "https://devby.io/";
    driver.get(url);
    driver.close();
  }

  @Test
  public void orderCasualDress() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/Users/vitali/IdeaProjects/chromedriver");
    WebDriver driver = new ChromeDriver();
    String url = "http://automationpractice.com/index.php";
    driver.get(url);
    driver.findElement(By.cssSelector(".header_user_info")).click();
    WebElement email = driver
            .findElement(By.cssSelector("#email"));
    email.sendKeys("kickforce666@gmail.com");
    WebElement pass = driver
            .findElement(By.cssSelector("#passwd"));
    pass.sendKeys("123qweQWE");
    driver.findElement(By.cssSelector(".icon-lock")).click();
    driver.findElement(new ByText("Welcome to your account. Here you can manage all of your personal information and orders."));
    Actions action = new Actions(driver);
    WebElement dresstab = driver
            .findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a"));
    action.moveToElement(dresstab).build().perform();
    driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a")).click();
    WebElement dress = driver
            .findElement(By.cssSelector(".product-container"));
    action.moveToElement(dress).build().perform();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement btn = driver
            .findElement(By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default"));
    btn.click();
    driver.switchTo().activeElement();
    driver.findElement(By.cssSelector(".col-md-6 > div.button-container > a")).click();
    driver.findElement(By.cssSelector(".standard-checkout.button-medium")).click();
    driver.findElement(By.cssSelector("p >button")).click();
    driver.findElement(By.id("cgv")).click();
    driver.findElement(By.cssSelector("p >button")).click();
    driver.findElement(By.cssSelector(".bankwire")).click();
    driver.findElement(By.cssSelector("#cart_navigation > button")).click();
    String textWithNumber = driver.findElement(By.cssSelector(".box")).getText();
    String number = textWithNumber.substring(216, 225);
    driver.findElement(By.cssSelector("#contact-link > a")).click();
    Select subject = new Select(driver.findElement(By.id("id_contact")));
    subject.selectByValue("2");
    List<WebElement> refnumber = driver.findElements(By.cssSelector("div:nth-child(6) > div > select"));
    for (WebElement option : refnumber) {
      if (option.getText().contains(number)) {
        option.click();
        break;
      }
    }
    driver.findElement(By.cssSelector("#message")).sendKeys("I have a problem with my order. Could you help me,please?");
    driver.findElement(By.cssSelector("#submitMessage")).click();

  }

  @Test
  public void regUser() {
    System.setProperty("webdriver.chrome.driver", "/Users/vitali/IdeaProjects/chromedriver");
    WebDriver driver = new ChromeDriver();
    String url = "http://automationpractice.com/index.php";
    driver.get(url);
    driver.findElement(By.cssSelector(".header_user_info")).click();
    driver.findElement(By.cssSelector("#email_create")).sendKeys("test.test1@test1.com");
    driver.findElement(By.cssSelector("#SubmitCreate")).click();
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    driver.findElement(By.id("id_gender1")).click();
    driver.findElement(By.id("customer_firstname")).sendKeys("Ivan");
    driver.findElement(By.id("customer_lastname")).sendKeys("Ivanov");
    driver.findElement(By.id("newsletter")).click();
    driver.findElement(By.id("optin")).click();
    Select days = new Select(driver.findElement(By.id("days")));
    days.selectByValue("1");
    Select months = new Select(driver.findElement(By.id("months")));
    months.selectByValue("1");
    Select years = new Select(driver.findElement(By.id("years")));
    years.selectByValue("2020");
    driver.findElement(By.id("passwd")).sendKeys("12345");
    driver.findElement(By.id("company")).sendKeys("Kaseya");
    driver.findElement(By.id("address1")).sendKeys("701 Brickell Avenue");
    driver.findElement(By.id("city")).sendKeys("Miami");
    Select state = new Select(driver.findElement(By.id("id_state")));
    state.selectByVisibleText("Florida");
    driver.findElement(By.id("postcode")).sendKeys("33131");
    driver.findElement(By.id("other")).sendKeys("Additional information");
    driver.findElement(By.id("phone")).sendKeys("+375292929297");
    driver.findElement(By.id("phone_mobile")).sendKeys("+375333333333");
    driver.findElement(By.id("alias")).sendKeys("18, Baker street");
    driver.findElement(By.id("submitAccount")).click();
  }

  @Test
  public void writeReview() {
    System.setProperty("webdriver.chrome.driver", "/Users/vitali/IdeaProjects/chromedriver");
    WebDriver driver = new ChromeDriver();
    String url = "http://automationpractice.com/index.php";
    driver.get(url);
    driver.findElement(By.cssSelector(".header_user_info")).click();
    WebElement email = driver
            .findElement(By.cssSelector("#email"));
    email.sendKeys("kickforce666@gmail.com");
    WebElement pass = driver
            .findElement(By.cssSelector("#passwd"));
    pass.sendKeys("123qweQWE");
    driver.findElement(By.cssSelector(".icon-lock")).click();
    driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a")).click();
    Actions action = new Actions(driver);
    WebElement dress = driver
            .findElement(By.cssSelector(".product-container"));
    action.moveToElement(dress).build().perform();
    driver.findElement(By.cssSelector(".lnk_view.btn.btn-default > span")).click();
    driver.findElement(By.cssSelector(".open-comment-form")).click();
    driver.switchTo().activeElement();
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    driver.findElement(By.cssSelector(".star_content > div:nth-child(7) > a")).click();
    driver.findElement(By.id("comment_title")).sendKeys("High quality product");
    driver.findElement(By.id("content")).sendKeys("Faded short sleeve t-shirt with high neckline. Soft and stretchy material for a comfortable fit. Accessorize with a straw hat and you're ready for summer!");
    driver.findElement(By.id("submitNewMessage")).click();
    driver.switchTo().activeElement();
    driver.findElement(new ByText("OK")).click();
  }


}
