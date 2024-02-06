package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    /**
     * The port number assigned to the running application during test execution. * Set automatically during each test run by Spring Framework's test context. */
    @LocalServerPort
    private int serverPort;

    /**
     * The base URL for testing. Default to {@code http://localhost}.
     */
    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort) + "/product/";
    }
    @Test
    void createProduct_isCorrect (ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);

        WebElement clickInput = driver.findElement(By.id("product"));
        clickInput.click();

        clickInput = driver.findElement(By.id("create"));
        clickInput.click();

        // Clear field to empty it from any previous data
        WebElement nameInput=driver.findElement(By.id("nameInput"));
        nameInput.clear();
        //Enter Text
        String name="Banana";
        nameInput.sendKeys(name);

        // Clear field to empty it from any previous data
        WebElement quantityInput=driver.findElement(By.id("quantityInput"));
        quantityInput.clear();

        //Enter Text
        String quantity="10";
        quantityInput.sendKeys(quantity);

        clickInput = driver.findElement(By.id("submitCreate"));
        clickInput.click();

        // Verify
        String productName = driver.findElement(By.id("productName")).getText();
        assertEquals("Banana", productName);

        String productQuantity = driver.findElement(By.id("productQuantity")).getText();
        assertEquals("10", productQuantity);
    }

}