package ru.yandex.praktikum;

import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import ru.yandex.praktikum.pageobject.AboutRentScreenSamokat;
import ru.yandex.praktikum.pageobject.HomePageSamokat;
import ru.yandex.praktikum.pageobject.PlaceAnOrderScreenSamokat;
import ru.yandex.praktikum.pageobject.ScooterAboutScreenSamokat;

@RunWith(Parameterized.class)
public class MakeOrder {
    private WebDriver driver;
    private String firstName;
    private String secondName;
    private String adress;
    private String phone;
    private String comment;

    public MakeOrder(String firstName, String secondName, String adress, String phone, String comment) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.adress = adress;
        this.phone = phone;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getFieldsScooterAbout() {
        return new Object[][]{
                {"Михаил", "Лермонтов", "Профсоюзная 22", "89961234567", "Позвоните за пол часа"},
                {"Фёдор", "Достоевский", "Баумана 17", "89612341245", "Позвоните за пол часа"},
        };
    }

    @Test
    public void MakeOrderScriptOne() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.goToScooterAboutScreenOrderButtonUp();

        ScooterAboutScreenSamokat objScooterAboutScreen = new ScooterAboutScreenSamokat(driver);
        objScooterAboutScreen.fillFieldsInScooterAbout(firstName, secondName, adress, phone);

        AboutRentScreenSamokat objAboutRentScreen = new AboutRentScreenSamokat(driver);
        objAboutRentScreen.fillFieldsInScooterAbout(comment);

        PlaceAnOrderScreenSamokat objPlaceAnOrderScreen = new PlaceAnOrderScreenSamokat(driver);
        objPlaceAnOrderScreen.placeAnOrder();
    }

    @Test
    public void MakeOrderScriptTwo() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.goToScooterAboutScreenOrderButtonDown();

        ScooterAboutScreenSamokat objScooterAboutScreen = new ScooterAboutScreenSamokat(driver);
        objScooterAboutScreen.fillFieldsInScooterAbout(firstName, secondName, adress, phone);

        AboutRentScreenSamokat objAboutRentScreen = new AboutRentScreenSamokat(driver);
        objAboutRentScreen.fillFieldsInScooterAbout(comment);

        PlaceAnOrderScreenSamokat objPlaceAnOrderScreen = new PlaceAnOrderScreenSamokat(driver);
        objPlaceAnOrderScreen.placeAnOrder();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}