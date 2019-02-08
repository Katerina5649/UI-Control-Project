package ru.mail.example.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.example.pages.LadyPage;
import ru.mail.example.steps.elements.AbstractSteps;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Набор шагов для взаимодействия со страницей "Милота"
 */
public class LadyPageSteps extends AbstractSteps {

    private LadyPage ladyPage = null;

    public LadyPageSteps(WebDriver driver) {
        super(driver);
        ladyPage = PageFactory.initElements(driver, LadyPage.class);
    }

    @Step("Получаем заголовок страницы")
    private void pageHeaderShouldBeSameAs(String header) {
        assertEquals("На странице отображается неверный заголовок",
                header,
                ladyPage.getPageHeader());
    }

    @Step("Открываем страницу {header}")
    public void open() {
        ladyPage.open();
        //ladyPage.pageValidate();
        //pageHeaderShouldBeSameAs(header);
    }

    @Step("Получаем названия всех статей на странице")
    public List<String> getAllArticlesTitles() {
        return ladyPage.getAllArticlesTitles();
    }

    @Step("Проверяем, что список статей на странице изменился и не соответствует списку {titles}")
    public void articlesTitlesShouldBeChanged(List<String> titles) {
        assertTrue("Список статей на странице должен измениться",
                ladyPage.isArticlesTitlesChanged(titles));
    }

   @Step("Проверяет, что названия статей различны")
    public void isTitlesDifferent(List <String> titles){
       Set<String> set = new HashSet<String>(titles);
       assertEquals(set.size(),titles.size());
   }
}
