package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//page object - класс для страницы Main
public class MainPage {

    // Поле driver
    private WebDriver driver;
    // Кнопка "Куки"
    private By cookiesButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");
    // Локатор до текста "Вопросы о важном"
    private By mainQwestionText = By.xpath("//div[text()='Вопросы о важном']");
    // Локатор accordionBlock_0 с вопросами и ответами
    public By firstAccordionBlock = By.xpath("//div[@id='accordion__heading-0']");
    // Локатор accordionBlock_1 с вопросами и ответами
    public By secondAccordionBlock = By.xpath("//div[@id='accordion__heading-1']");
    // Локатор accordionBlock_2 с вопросами и ответами
    public By thirdAccordionBlock = By.xpath("//div[@id='accordion__heading-2']");
    // Локатор accordionBlock_3 с вопросами и ответами
    public By forthAccordionBlock = By.xpath("//div[@id='accordion__heading-3']");
    // Локатор accordionBlock_4 с вопросами и ответами
   public By fifthAccordionBlock = By.xpath("//div[@id='accordion__heading-4']");
    // Локатор accordionBlock_5 с вопросами и ответами
    public By sixthAccordionBlock = By.xpath("//div[@id='accordion__heading-5']");
    // Локатор accordionBlock_7 с вопросами и ответами
    public By seventhAccordionBlock = By.xpath("//div[@id='accordion__heading-6']");
    // Локатор accordionBlock_8 с вопросами и ответами
    public By eighthAccordionBlock = By.xpath("//div[@id='accordion__heading-7']");
    //Локатор ответа
    public By openAnswerText = By.xpath("//div[@aria-expanded='true']/parent :: div/parent::div/div[@class='accordion__panel']/p");
    //Локатор верхней кнопки "Заказать"
    public By orderUpButton = By.xpath("//div/button[@class='Button_Button__ra12g']");
    //Локатор нижней кнопки "Заказать"
    public By orderDownButton = By.xpath("//div/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");
    // Конструктор класса page object
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //  Кликнуть по кнопке «Куки»
    public void clickSignInButton() {
        driver.findElement(cookiesButton).click();
    }

    //Скролл до текста "Вопросы о важном"
    public void scrollToMainQuestion() {
        WebElement element = driver.findElement(mainQwestionText);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Метод получения текста ответа
    public String getOpenAnswerText() {
        String textElement = driver.findElement(openAnswerText).getText();
        return textElement;
    }
}
