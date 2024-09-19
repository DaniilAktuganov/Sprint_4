package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterAboutScreenSamokat {

    private WebDriver driver;

    //локатор поля "Имя"
    private By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    //локатор поля "Фамилия"
    private By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //локатор поля "Адрес"
    private By adressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор поля "Станция метро"
    private By subwayField = By.xpath(".//input[@placeholder='* Станция метро']");
    //локатор кнопки выбора станция метро "Бульвар Рокоссовского"
    private By selectStationButton = By.xpath(".//div[@class='Order_Text__2broi' and text()='Бульвар Рокоссовского']");
    //локатор поля "Телефон"
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки "Далее"
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор экрана "Про аренду"
    private By aboutRentScreen = By.xpath(".//div[@class='Order_Content__bmtHS']");

    //локатор ошибки ввода в поле "Имя"
    private By firstNameFieldError = By.xpath(".//div[text()='Введите корректное имя']");
    //локатор ошибки ввода в поле "Фамилия"
    private By secondNameFieldError = By.xpath(".//div[text()='Введите корректную фамилию']");
    //локатор ошибки ввода в поле "Адрес"
    private By adressFieldError = By.xpath(".//div[text()='Введите корректный адрес']");
    //локатор ошибки ввода в поле "Станция метро"
    private By subwayFieldError = By.xpath(".//div[@class='Order_MetroError__1BtZb']");
    //локатор ошибки ввода в поле "Телефон"
    private By phoneFieldError = By.xpath(".//div[text()='Введите корректный номер']");



    public ScooterAboutScreenSamokat(WebDriver driver) {
        this.driver = driver;
    }

    // метод вводит значение в поле "Имя"
    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        ExpectedConditions.textToBePresentInElementLocated(firstNameField, firstName);
    }

    // метод вводит значение в поле "Фамилия"
    public void setSecondName(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
        ExpectedConditions.textToBePresentInElementLocated(secondNameField, secondName);
    }

    // метод вводит значение в поле "Адрес"
    public void setAdress(String adress) {
        driver.findElement(adressField).sendKeys(adress);
        ExpectedConditions.textToBePresentInElementLocated(adressField, adress);
    }

    // метод выбирает станцию метро в поле "Станция метро"
    public void setSubwayStation() {
        driver.findElement(subwayField).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(selectStationButton)));
        driver.findElement(selectStationButton).click();
    }

    // метод вводит значение в поле "Телефон"
    public void setPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
        ExpectedConditions.textToBePresentInElementLocated(phoneField, phone);
    }

    // метод нажимает на кнопку "Далее" на экране "Для кого самокат"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    // метод ожидания загрузки экрана "Про аренду"
    public void waitAboutRentScreen() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(aboutRentScreen)));
    }

    //шаг для заполнения полей на экране "Для кого самокат"
    public void fillFieldsInScooterAbout(String firstName, String secondName, String adress, String phone){
        setFirstName(firstName);
        setSecondName(secondName);
        setAdress(adress);
        setSubwayStation();
        setPhone(phone);
        clickNextButton();
        waitAboutRentScreen();
    }
}