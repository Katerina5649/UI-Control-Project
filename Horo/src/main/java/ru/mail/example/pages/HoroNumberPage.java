package ru.mail.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.mail.example.navigation.Page;
import ru.mail.example.navigation.UrlPattern;

import java.util.List;
import java.util.stream.Collectors;

@Page("/numerology/chislovaya-vibraciya-imen/")
@UrlPattern("numerology/chislovaya-vibraciya-imen/")
public class HoroNumberPage extends AbstractPage {

    public HoroNumberPage(WebDriver driver) {
        super(driver);
    }

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
}