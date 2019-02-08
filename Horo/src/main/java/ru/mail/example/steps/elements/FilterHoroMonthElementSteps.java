package ru.mail.example.steps.elements;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.example.data.MonthData;
import ru.mail.example.elements.filter.FilterHoroMonthElement;
import ru.mail.example.steps.AbstractSteps;

import static org.junit.Assert.assertTrue;

/**
 * Компонент фильтра на странице. Паттерн Component Object.
 */
@DisplayName("Test steps")
public class FilterHoroMonthElementSteps extends AbstractSteps {

    public FilterHoroMonthElementSteps(WebDriver driver) {
        super(driver);
    }

    private FilterHoroMonthElement filterHoroElement = null;

    private FilterHoroMonthElement getFilterHoroElement() {
        if(filterHoroElement == null) filterHoroElement = PageFactory.initElements(getDriver(), FilterHoroMonthElement.class);
        return filterHoroElement;
    }

    @Step("Проверяем, что вкладка {petsData.getName} активна в фильтре")
    public void filterTabShouldBeActive(MonthData horoData) {
        assertTrue(String.format("Вкладка фильтра %s должна быть активна", horoData.getName()),
                getFilterHoroElement().isFilterTabActive(horoData));
    }

    @Step("Проверяем, что вкладка {horoData.getName} не активна в фильтре")
    public void filterTabShouldNotBePresent(MonthData horoData) {
        assertTrue(String.format("Вкладка фильтра %s не должна быть активна", horoData.getName()),
                getFilterHoroElement().isFilterTabNotActive(horoData));
    }

    @Step("Кликаем на вкладку {horoData.getName}")
    public void clickFilterMonthTab(MonthData horoData) {
        getFilterHoroElement().clickFilterTab(horoData);
    }




}