package net.myapp.onetomay;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class Selenium {
    @Test
    void test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\wikto\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.className("fa-user-plus")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("email")).sendKeys("w52225@email.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("firstName")).sendKeys("Wiktor");
        driver.findElement(By.id("lastName")).sendKeys("Porowski");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.className("btn-primary")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String title = driver.getCurrentUrl();
        assertEquals(title,"http://localhost:8080/process_register" );

        driver.quit();
    }
}
