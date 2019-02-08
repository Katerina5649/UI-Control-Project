package ru.mail.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.mail.example.navigation.Page;
import ru.mail.example.navigation.UrlPattern;

import java.util.List;
import java.util.stream.Collectors;

import static java.awt.SystemColor.menu;


@Page("/moon_calendar/october-2017/")
@UrlPattern("moon_calendar/\\w+-\\d+/")

public class HoroYearPage extends AbstractPage{


    public HoroYearPage(WebDriver driver) {
        super(driver);
    }

    //todo
    @FindBy(css = ".p-content-menu margin_top_30")
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
