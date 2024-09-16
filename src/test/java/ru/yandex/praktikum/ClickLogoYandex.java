package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pageobject.HomePageSamokat;
import java.util.ArrayList;

public class ClickLogoYandex {

    private WebDriver driver;

    @Test
    public void ClickLogoSamokatTest() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        //В переменную oldTab сохраняем идентификатор текущего окна
        String oldTab = driver.getWindowHandle();
        // метод нажимает на логотип "Яндекс"
        objHomePage.clickLogoYandex();
        // В переменную newTab сохраняем список всех открытых окон
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        // Убираем идентификатор текущего окна из списка, чтобы остался идентификатор нового окна
        newTab.remove(oldTab);
        // Переход на новое окно
        driver.switchTo().window(newTab.get(0));
        // Проверяем заголовок новой страницы
        String expectedTitle = "Яндекс"; // Заголовок главной страницы Яндекса
        Assert.assertEquals(expectedTitle, driver.getTitle());
        // Закрываем новое окно
        driver.close();
        // Возвращаемся в оригинальное окно
        driver.switchTo().window(oldTab);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}