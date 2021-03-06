package ru.mail.example.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.example.pages.HoroMonthAprilPage;
import ru.mail.example.pages.HoroYearPage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HoroYearPageSteps extends AbstractSteps {
    private HoroYearPage horoPage = null;

    public HoroYearPageSteps(WebDriver driver) {
        super(driver);

        horoPage = PageFactory.initElements(driver, HoroYearPage.class);
    }

    @Step("Получаем заголовок страницы")
    private void pageHeaderShouldBeSameAs(String header) {
        assertEquals("На странице отображается неверный заголовок",
                header,
                horoPage.getPageHeader());
    }

    @Step("Открываем страницу {header}")
    public void open(String header) {
        horoPage.open();
        horoPage.pageValidate();
        pageHeaderShouldBeSameAs(header);
    }


    @Step("Получаем названия всех статей на странице")
    public List<String> getAllArticlesTitles() {
        return horoPage.getAllArticlesTitles();
    }

    @Step("Проверяем, что список статей на странице изменился и не соответствует списку {titles}")
    public void articlesTitlesShouldBeChanged(List<String> titles) {
        assertTrue("Список статей на странице должен измениться",
                horoPage.isArticlesTitlesChanged(titles));
    }




}

