package stepDifinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class MyStepDef {
    WebDriver webDriver;
    @When("^Login to the website$")
    public void login_with_test_password01() throws Throwable {
        System.setProperty("webdriver.chrome.driver","C:/Users/CMDQ123/Desktop/chromedriver.exe");
        webDriver=new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://demoqa.com/books");
        WebElement login=webDriver.findElement(By.id("login"));
        login.click();
        WebElement username= webDriver.findElement(By.id("userName"));
        username.sendKeys("test");
        WebElement password= webDriver.findElement(By.id("password"));
        password.sendKeys("Password01!");
        WebElement login2=webDriver.findElement(By.id("login"));
        login2.click();
        Thread.sleep(3000);
    }
    @Then("^Click on Go to bookstore and add the following book to the collection$")
    public void click_on_go_to_bookstore_and_add_the_following_book_to_the_collection_programming_javascript_applications() throws InterruptedException {
              WebElement search=webDriver.findElement(By.xpath("//*[@id=\"searchBox\"]"));
              search.sendKeys("Programming JavaScript Applications");
              WebElement clickSearch=webDriver.findElement(By.xpath("//*[@id=\"basic-addon2\"]"));
              clickSearch.click();
              WebElement book= webDriver.findElement(By.xpath("//*[@id=\"see-book-Programming JavaScript Applications\"]/a"));
              book.click();
//              JavascriptExecutor js = (JavascriptExecutor) webDriver;
//              js.executeScript("window.scrollBy(0,1000)");
//              WebElement add= webDriver.findElement(By.id("addNewRecordButton"));
//              add.click();
    }
    @Then("^Get the ISBN Number of the book and print it out$")
    public void get_the_isbn_number_of_the_book_and_print_it_out(){
             WebElement isbn= webDriver.findElement(By.xpath("//label[contains(text(),'978149')]"));
             System.out.println(isbn.getText());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webDriver.quit();
    }
}
