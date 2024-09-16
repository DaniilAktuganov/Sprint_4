package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceAnOrderScreenSamokat {

    private WebDriver driver;

    //локатор кнопки "Да" на экране "Хотите оформить заказ"
    private By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //локатор кнопки "Посмотреть статус" на экране "Заказ оформлен"
    private By viewStatusButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");


    public PlaceAnOrderScreenSamokat(WebDriver driver) {
        this.driver = driver;
    }

    // метод нажимает на кнопку "Да" на экране "Хотите оформить заказ"
    public void clickYesButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(yesButton));
        driver.findElement(yesButton).click();
    }

    // метод ожидания загрузки экрана "Заказ оформлен"
    public void waitSuccessfullOrderScreen() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(viewStatusButton));
    }

    //шаг для подтверждения заказа на экране "Хотите оформить заказ"
    public void placeAnOrder(){
        clickYesButton();
        waitSuccessfullOrderScreen();
    }
}