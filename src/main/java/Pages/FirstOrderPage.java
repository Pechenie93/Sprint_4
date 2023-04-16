package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FirstOrderPage {
    private WebDriver driver;
    public FirstOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    // Поле "Имя"
    public By firstNameField = By.xpath("//div/input[@placeholder='* Имя']");
    // Поле "Фамилия"
    public By secondNameField = By.xpath("//div/input[@placeholder='* Фамилия']");
    // Поле "Куда привезти"
    public By streetField = By.xpath("//div/input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле "Станция метро"
    public By metroStationField = By.xpath("//div/input[@placeholder='* Станция метро']");
    // Поле "Телефон"
    public By phoneNumberField = By.xpath("//div/input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    public By nextButton = By.xpath("//div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    //  Метод, вносит Имя
    public void setFirstNameField(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    //  Метод, вносит Фамилию
    public void setSecondNameField(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }
    //  Метод, вносит Адрес
    public void setStreetField(String streetName) {
        driver.findElement(streetField).sendKeys(streetName);
    }
    //  Метод, который вносит Метро
    public void setMetroStationField(String metroStantion) {
        driver.findElement(metroStationField).sendKeys(metroStantion, Keys.ARROW_DOWN, Keys.ENTER);
    }
    //  Метод, вносит телефон
    public void setPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    //  Метод, кликнуть по кнопке Далее
    public void setNextButton() {
        driver.findElement(nextButton).click();}

    // Шаг Заполнение страницы 1
    public void fillFirstPage (String firstName, String secondName, String streetName, String metroStation, String phoneNumber) {
        setFirstNameField(firstName);
        setSecondNameField(secondName);
        setStreetField(streetName);
        setMetroStationField(metroStation);
        setPhoneNumberField(phoneNumber);
    }
}




