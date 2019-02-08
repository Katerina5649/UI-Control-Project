package ru.mail.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.mail.example.navigation.Page;
import ru.mail.example.navigation.UrlPattern;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Страница "Милота" с реализацией PageObject паттерна
 */
@Page("/search/?\n")
@UrlPattern("search/?\n")
public class LadyPage extends AbstractPage {

    public LadyPage(WebDriver driver) {
        super(driver);
    }
//todo что это   и нужен ли FindBy  ???
    @FindBy(css = ".pypo-item__title")
    private List<WebElement> articlesTitles;

    /**
     * Возвращает названия статей на странице
     * @return названия статей
     */
    public List<String> getAllArticlesTitles() {
        return articlesTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    /**
     * Проверяет, что список статей на странице изменился
     * @param titles - названия статей
     * @return boolean
     */
    public boolean isArticlesTitlesChanged(List<String> titles) {
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return getAllArticlesTitles() != titles;
            }
        };
        return waitTools.waitForCondition(condition);
    }


    //todo   проверка, что заголовки различны
    public boolean IsArticlesDifferent(List<String> titles) {
        int k = 0;
        return false;
    }
}