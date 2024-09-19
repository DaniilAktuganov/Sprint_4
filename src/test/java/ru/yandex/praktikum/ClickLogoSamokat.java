package ru.yandex.praktikum;

import org.junit.Test;

public class ClickLogoSamokat extends BaseTest {

    @Test
    public void clickLogoSamokatTest() {
        objHomePage.goToScooterAboutScreenOrderButtonUp();
        objHomePage.clickLogoSamokat();
    }
}