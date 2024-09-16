package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class HomePageSamokat {

    private WebDriver driver;

    //локатор куки
    private By cookieButton = By.xpath(".//button[@id='rcc-confirm-button']");
    //локатор раздела «Вопросы о важном»
    private By listFAQ = By.xpath(".//div[@id='accordion__heading-0']");
    //локатор вопросов из выпадающего списка
    private By expendAccordionElements = By.xpath(".//div[@data-accordion-component='AccordionItemButton']");
    //локатор ответов из выпадающего списка
    private By expendAccordionAnswers = By.xpath(".//div[@class='accordion__panel']//p");

    //локатор верхней кнопки "Заказать"
    private By orederButtonUp = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[@class='Button_Button__ra12g']");
    //локатор нижней кнопки "Заказать"
    private By orederButtonDown = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //локатор экрана "Для кого самокат"
    private By scooterForScreen = By.xpath(".//div[@class='Order_Header__BZXOb']");

    //локатор логотипа "Самокат"
    private By logoSamokat = By.xpath(".//img[@src='/assets/scooter.svg']");
    //локатор для главной страницы "Самоката"
    private By homePage = By.xpath(".//div[@class='Home_HomePage__ZXKIX']");

    //локатор логотипа "Яндекс"
    private By logoYandex = By.xpath(".//img[@src='/assets/ya.svg']");

    //локатор кнопки "Статус заказа"
    private By orderStatusButton = By.xpath(".//button[@class='Header_Link__1TAG7']");

    //локатор поля "Введите номер заказа"
    private By enterNumberOfOrderField = By.xpath(".//input[@placeholder='Введите номер заказа']");

    //локатор кнопки "Go!"
    private By gOButton = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");

    //локатор страницы "Такого заказа нет"
    private By noSuchOrderScreen = By.xpath(".//img[@src='/assets/not-found.png']");

    public HomePageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    //принять куки
    public void clickCookieButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(cookieButton));
        driver.findElement(cookieButton).click();
    }

    //скролл до раздела "Вопросы о важном"
    public void scrollListFAQ() {
        WebElement element = driver.findElement(listFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // метод раскрывает ответы на вопросы
    public void expendAccordionHeading(int index) {
        List<WebElement> elements = driver.findElements(expendAccordionElements);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(elements.get(index)));
        elements.get(index).click();
    }

    // метод получает текст ответов
    public String checkAnswer(int index) {
        List<WebElement> answers = driver.findElements(expendAccordionAnswers);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(answers.get(index)));
        return answers.get(index).getText();
    }

    // метод нажимает на верхнюю кнопку "Заказать"
    public void clickOrderButtonUp() {
        driver.findElement(orederButtonUp).click();
    }

    // метод нажимает на нижнюю кнопку "Заказать"
    public void clickOrderButtonDown() {
        driver.findElement(orederButtonDown).click();
    }

    //скролл до нижней кнопки "Заказать"
    public void scrollOrderButtunDown() {
        WebElement element = driver.findElement(orederButtonDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // метод ожидания загрузки экрана "Для кого самокат"
    public void waitScooterAboutScreen() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(scooterForScreen)));
    }

    // метод нажимает на логотип "Самокат"
    public void clickLogoSamokat() {
        driver.findElement(logoSamokat).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(homePage)));
    }

    // метод нажимает на логотип "Яндекс"
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }

    // метод нажимает на кнопку "Статус заказа"
    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(enterNumberOfOrderField)));
    }

    // метод вводит неправильный номер заказа в поле "Введите номер заказа"
    public void enterOrderNumberField(String number) {
        driver.findElement(enterNumberOfOrderField).sendKeys(number);
        ExpectedConditions.textToBePresentInElementLocated(enterNumberOfOrderField, number);
    }

    // метод нажимает на кнопку "Go!"
    public void clickGoButton() {
        driver.findElement(gOButton).click();
    }

    // метод ожидания загрузки экрана "Такого заказа нет"
    public void waitNoSuchOrderScreen() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(noSuchOrderScreen)));
    }

    //шаг для открытия текста в разделе "Вопросы о важном"
    public void expandFAQ(int index){
        clickCookieButton();
        scrollListFAQ();
        expendAccordionHeading(index);
    }

    //шаг для открытия экрана "Для кого самокат" при нажатии на верхнюю кнопку "Заказать"
    public void goToScooterAboutScreenOrderButtonUp(){
        clickCookieButton();
        clickOrderButtonUp();
        waitScooterAboutScreen();
    }

    //шаг для открытия экрана "Для кого самокат" при нажатии на нижнюю кнопку "Заказать"
    public void goToScooterAboutScreenOrderButtonDown(){
        clickCookieButton();
        scrollOrderButtunDown();
        clickOrderButtonDown();
        waitScooterAboutScreen();
    }

    //шаг для ввода неправильного номера заказа в поле "Введите номер заказа"
    public void goToNoSuchOrderScreen(String number){
        clickCookieButton();
        clickOrderStatusButton();
        enterOrderNumberField(number);
        clickGoButton();
        waitNoSuchOrderScreen();
    }
}