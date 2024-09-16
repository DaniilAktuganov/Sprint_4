package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutRentScreenSamokat {

    private WebDriver driver;

    //локатор поля "Когда привезти самокат"
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //локатор для выбора даты 18.09.2024 в поле "Когда привезти самокат"
    private By selectDateButton = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--018']");
    //локатор поля "Срок аренды"
    private By rentalPeriodField = By.xpath(".//div[@class='Dropdown-placeholder']");
    //локатор для выбора срока аренды "сутки" в поле "Срок аренды"
    private By selectRentalPeriodButton = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    //локатор поля "Цвет самоката - черный жемчуг"
    private By blackColorField = By.xpath(".//input[@id='black']");
    //локатор поля "Цвет самоката - серая безысходность"
    private By greyColorField = By.xpath(".//input[@id='grey']");
    //локатор поля "Комментарий для курьера"
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //локатор кнопки "Заказать" на экране "Про аренду"
    private By orderAboutRentButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //локатор экрана "Хотите оформить заказ"
    private By placeAnOrderScreen = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public AboutRentScreenSamokat(WebDriver driver) {
        this.driver = driver;
    }

    // метод выбирает дату 18.09.2024 в поле "Когда привезти самокат"
    public void selectDate() {
        driver.findElement(dateField).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(selectDateButton)));
        driver.findElement(selectDateButton).click();
    }

    // метод выбирает срок аренды "сутки"  в поле "Срок аренды"
    public void selectRentalPeriod() {
        driver.findElement(rentalPeriodField).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(selectRentalPeriodButton)));
        driver.findElement(selectRentalPeriodButton).click();
    }

    // метод выбирает цвет "чёрный жемчуг"  в поле "Цвет самоката"
    public void selectColour() {
        driver.findElement(blackColorField).click();
        driver.findElement(greyColorField).click();
    }

    // метод вводит значение в поле "Комментарий для курьера"
    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
        ExpectedConditions.textToBePresentInElementLocated(commentField, comment);
    }

    // метод нажимает на кнопку "Заказать" на экране "Про аренду"
    public void clickOrderAboutRentButton() {
        driver.findElement(orderAboutRentButton).click();
    }

    // метод ожидания загрузки экрана "Хотите оформить заказ"
    public void waitPlaceAnOrderScreen() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(placeAnOrderScreen)));
    }

    //шаг для заполнения полей на экране "Для кого самокат"
    public void fillFieldsInScooterAbout(String comment){
        selectDate();
        selectRentalPeriod();
        selectColour();
        setComment(comment);
        clickOrderAboutRentButton();
        waitPlaceAnOrderScreen();
    }
}