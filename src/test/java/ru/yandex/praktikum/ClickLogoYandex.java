package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class ClickLogoYandex extends BaseTest {

    private String oldTab;

    @Test
    public void clickLogoSamokatTest() {
        oldTab = driver.getWindowHandle();
        objHomePage.clickLogoYandex();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
        String expectedTitle = "Яндекс";
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @After
    public void teardown() {
        closeNewTab();
        switchToOldTab();
        driver.quit();
    }

    public void closeNewTab() {
        driver.close();
    }

    public void switchToOldTab() {
        driver.switchTo().window(oldTab);
    }
}