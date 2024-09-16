package ru.yandex.praktikum;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import ru.yandex.praktikum.pageobject.HomePageSamokat;

public class EnterAnIncorrectOrderNumber {

    private WebDriver driver;
    private String number = "ТакогоЗаказаНет";

    @Test
    public void EnterAnIncorrectOrderNumberTest() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.goToNoSuchOrderScreen(number);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}