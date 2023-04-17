package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondOrderPage {
    //Локатор "Когда привезти самокат"
    private By dateField = By.xpath("//div/input[@placeholder='* Когда привезти самокат']");
    //Локатор "Срок аренды"
    private By orderArrowTimeField = By.xpath("//div/span[@class='Dropdown-arrow']");
    //Локатор "Срок аренды drop down menu"
    private By orderDropTimeField = By.xpath("//div[contains(text(),'двое суток')]"); ///div[contains(text(),'двое суток')'//div[@class='Dropdown-menu']/div[2]
    //Локатор чек-бокс цвет
    private By colorScooterChek = By.xpath("//label[contains(text(),'чёрный жемчуг')]");
    //Локатор Комментраий
    public By orderComment = By.xpath("//div/input[@placeholder='Комментарий для курьера']");
    //Локатор кнопки Заказать
    private By orderBook = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[contains(text(),'Заказать')]");
    //Локатор подтверждения заказа
    private By orderConfirmation = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[contains(text(), 'Да')]");
    //Локатор текста подтверждения заказа
    private By orderSocsessText = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");
    private WebDriver driver;
    public SecondOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод указывающий Дату заказа
    public void setDateOrdier(String dataFields) {
        driver.findElement(dateField).sendKeys(dataFields);
    }

    //Метод выбора срока аренды
    public void setOrderArrowTimeField() {
        driver.findElement(orderArrowTimeField).click();
    }

    //Метод выбора срока аренды2
    public void setOrderDropTimeField() {
        driver.findElement(orderDropTimeField).click();
    }

    //Метод выбор цвета самоката
    public void setColorScooterChek() {
        driver.findElement(colorScooterChek).click();
    }

    //Метод добавления коментария
    public void setOrderComments(String commentField) {
        driver.findElement(orderComment).sendKeys(commentField);
    }

    //Метод нажатия кнопки заказать
    public void clickOrderBook() {
        driver.findElement(orderBook).click();
    }

    // Добавили метод нажатия кнопки подтверждения заказа
    public void setOrderConfirmation() {
        driver.findElement(orderConfirmation).click();
    }

    // Добавили метод получения текста из подтверждения заказа
    public String getOrderSocsessText() {
        String orderText = driver.findElement(orderSocsessText).getText();
        return orderText;
    }

    //Создаем шаг зполнение страницы 2
    public void fillSecondPage(String dataFields, String commentField) {
        setDateOrdier(dataFields);
        setOrderArrowTimeField();
        setOrderDropTimeField();
        setColorScooterChek();
        setOrderComments(commentField);
    }
}

