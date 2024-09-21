package ru.yandex.praktikum;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import pageobject.AboutRentScreenSamokat;
import pageobject.PlaceAnOrderScreenSamokat;
import pageobject.ScooterAboutScreenSamokat;

@RunWith(Parameterized.class)
public class MakeOrder extends BaseTest {

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
    public void makeOrderScriptOne() {

        objHomePage.goToScooterAboutScreenOrderButtonUp();

        ScooterAboutScreenSamokat objScooterAboutScreen = new ScooterAboutScreenSamokat(driver);
        objScooterAboutScreen.fillFieldsInScooterAbout(firstName, secondName, adress, phone);

        AboutRentScreenSamokat objAboutRentScreen = new AboutRentScreenSamokat(driver);
        objAboutRentScreen.fillFieldsInScooterAbout(comment);

        PlaceAnOrderScreenSamokat objPlaceAnOrderScreen = new PlaceAnOrderScreenSamokat(driver);
        objPlaceAnOrderScreen.placeAnOrder();
    }

    @Test
    public void makeOrderScriptTwo() {

        objHomePage.goToScooterAboutScreenOrderButtonDown();

        ScooterAboutScreenSamokat objScooterAboutScreen = new ScooterAboutScreenSamokat(driver);
        objScooterAboutScreen.fillFieldsInScooterAbout(firstName, secondName, adress, phone);

        AboutRentScreenSamokat objAboutRentScreen = new AboutRentScreenSamokat(driver);
        objAboutRentScreen.fillFieldsInScooterAbout(comment);

        PlaceAnOrderScreenSamokat objPlaceAnOrderScreen = new PlaceAnOrderScreenSamokat(driver);
        objPlaceAnOrderScreen.placeAnOrder();
    }
}