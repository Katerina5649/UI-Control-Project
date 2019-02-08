package ru.mail.example.steps.elements;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.example.data.MonthData;
import ru.mail.example.elements.filter.FilterHoroMonthElement;
import ru.mail.example.elements.filter.FilterHoroNumberElement;
import ru.mail.example.steps.AbstractSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DisplayName("Test steps")
public class FilterHoroNumberElementSteps extends AbstractSteps {

    public FilterHoroNumberElementSteps(WebDriver driver) {
        super(driver);
    }

    private FilterHoroNumberElement filterHoroElement;

    private FilterHoroNumberElement getFilterHoroElement() {
        filterHoroElement = PageFactory.initElements(getDriver(), FilterHoroNumberElement.class);
        return filterHoroElement;
    }

    @Step("Проверяем, что вкладка  активна в фильтре")
    public void filterTabShouldBeActive() {
        assertTrue(String.format("Вкладка фильтра %s должна быть активна"),
                getFilterHoroElement().isFilterNumberTabActive());
    }


    @Step("Кликаем на вкладку ")
    public void clickFilterNumberTab() {
        getFilterHoroElement().clickFilterTab();
    }

    @Step("Вводим имя")
    public void writeName(String name) {
        getFilterHoroElement().writeName(name);
    }


    @Step("Проверяем, что поле пусто")
    public void isEmpty() {

        assertEquals("", getFilterHoroElement().getName());
        }

    }







