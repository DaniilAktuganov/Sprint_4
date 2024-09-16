package ru.yandex.praktikum;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import ru.yandex.praktikum.pageobject.HomePageSamokat;

public class ClickLogoSamokat {

    private WebDriver driver;

    @Test
    public void ClickLogoSamokatTest() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.goToScooterAboutScreenOrderButtonUp();
        objHomePage.clickLogoSamokat();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}