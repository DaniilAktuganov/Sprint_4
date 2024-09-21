package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.HomePageSamokat;

public class BaseTest {

    protected WebDriver driver;
    protected HomePageSamokat objHomePage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        objHomePage = new HomePageSamokat(driver);
        objHomePage.clickCookieButton();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}