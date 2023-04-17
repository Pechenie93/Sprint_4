package qa_scooter;

import pages.MainPage;
import pages.SecondOrderPage;
import pages.FirstOrderPage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class TestOrderPage {

    private final String orderButtonLocator;
    private final String firstName;
    private final String secondName;
    private final String streetName;
    private final String metroStation;
    private final String phoneNumber;
    private final String dataFields;
    private final String commentField;

    WebDriver driver;

    public TestOrderPage(String orderButtonLocator, String firstName, String secondName, String streetName, String metroStation, String phoneNumber, String dataFields, String commentField) {
        this.orderButtonLocator = orderButtonLocator;
        this.firstName = firstName;
        this.secondName = secondName;
        this.streetName = streetName;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.dataFields = dataFields;
        this.commentField = commentField;
    }

    @Parameterized.Parameters
    public static Object[][] getCostumersData() {
        return new Object[][]{
                //Проверям каждое поле формы для Chrome и FireFox на допустимость внесения кирилицы и латиницы
                {"//div/button[@class='Button_Button__ra12g']", "Сергей", "Иванович", "Ломоносова 7", "Чистые пруды", "89001234567", "31.12.2022", "Хорошо"},
                {"//div/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']", "Сергей", "Ианович", "Ломоносова 7", "Чистые пруды", "89001234567", "31.12.2022", "Хорошо"},
        };
    }

    @Before
    public void startDriver() {
        //Драйвер
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        // Разернули окно
        driver.manage().window().maximize();
        // Переход на главную страницу
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        // Закрыть окно про куки
        objMainPage.clickSignInButton();
    }

    @Test
    public void testUpOrderButton() {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        driver.findElement(By.xpath(orderButtonLocator)).click();
        // создать объект класса 2 страницы заказа;
        FirstOrderPage firstOrderPage = new FirstOrderPage(driver);
        // Заполнить форму 1
        firstOrderPage.fillFirstPage(firstName, secondName, streetName, metroStation, phoneNumber);
        // Нажать кнопку Далее
        firstOrderPage.setNextButton();
        // создаем объект класса 3 страницы заказа
        SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
        // Заполнили форму 2
        secondOrderPage.fillSecondPage(dataFields, commentField);
        //Нажали кнопку заказать
        secondOrderPage.clickOrderBook();
        // нажатия кнопки подтверждения заказа
        secondOrderPage.setOrderConfirmation();
        //получение текста из подтверждения заказа
        String orderText = secondOrderPage.getOrderSocsessText();
        MatcherAssert.assertThat(orderText, containsString("Заказ оформлен"));
    }

    @After
    public void quit() {
        driver.quit();
    }
}
