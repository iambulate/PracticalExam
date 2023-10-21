package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Add_New_Computer_Steps {
    private WebDriver driver;

    //start - open browser
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
    }
    //end - open browser

    //start - close browser
    @After
    public void tearDown(){
        driver.quit();
    }
    //end - close browser

    //start - execute the steps
    @Given("I access the Computer Database page")
    public void i_access_the_computer_database_page() throws InterruptedException {
        driver.get("https://computer-database.gatling.io/computers");
        Thread.sleep(3000);
    }
    @When("I click Add a new computer button")
    public void i_click_add_a_new_computer_button() throws InterruptedException {
        driver.findElement(By.cssSelector("[id=\"add\"]")).click();
        Thread.sleep(3000);
    }
    @And("I enter Computer Name")
    public void i_enter_computer_name() throws InterruptedException {
        driver.findElement(By.cssSelector("[id=\"name\"]")).sendKeys("Practical Exam Volume 123");
        Thread.sleep(1000);
    }
    @And("I enter Introduced")
    public void i_enter_introduced() throws InterruptedException {
        driver.findElement(By.cssSelector("[id=\"introduced\"]")).sendKeys("2023-10-01");
        Thread.sleep(1000);
    }
    @And("I enter Discontinued")
    public void i_enter_discontinued() throws InterruptedException {
        driver.findElement(By.cssSelector("[id=\"discontinued\"]")).sendKeys("2023-10-20");
        Thread.sleep(1000);
    }
    @And("I select Company")
    public void i_select_company() throws InterruptedException {
        driver.findElement(By.cssSelector("[id=\"company\"]")).sendKeys("Nokia");
        Thread.sleep(1000);
    }
    @And("I click the Create this computer button")
    public void i_click_the_create_this_computer_button() throws InterruptedException {
        driver.findElement(By.cssSelector("[value=\"Create this computer\"]")).click();
        Thread.sleep(3000);
    }
    @Then("I should see a success message")
    public void i_should_see_a_success_message() throws InterruptedException {
        WebElement addNewComputer_Submission_Message = driver.findElement(By.cssSelector("[class=\"alert-message warning\"]"));
        Assert.assertEquals(addNewComputer_Submission_Message.getText(), "Done ! Computer Practical Exam Volume 123 has been created");
        Thread.sleep(3000);
    }
    //end - execute the steps
}
