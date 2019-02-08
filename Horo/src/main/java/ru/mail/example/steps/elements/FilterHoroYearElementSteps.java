package ru.mail.example.steps.elements;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.example.driver.DriverProvider;
import ru.mail.example.elements.filter.FilterHoroYearElement;
import ru.mail.example.steps.AbstractSteps;

import static org.junit.Assert.assertTrue;

/**
 * Компонент фильтра на странице. Паттерн Component Object.
 */
@DisplayName("Test steps")
public class FilterHoroYearElementSteps extends AbstractSteps {

    public FilterHoroYearElementSteps(WebDriver driver) {
        super(driver);
    }


    FilterHoroYearElement filterHoroElement = null;

    private FilterHoroYearElement getFilterHoroElement() {
        if (filterHoroElement == null)
            filterHoroElement = PageFactory.initElements(getDriver(), FilterHoroYearElement.class);
        return filterHoroElement;
    }



    @Step("Проверяем, что вкладка активна в фильтре")
    public void filterTabShouldBeActive(String horoData) {
        assertTrue(String.format("Вкладка фильтра %s должна быть активна", horoData),
                getFilterHoroElement().isFilterTabActive(horoData));
    }

//    private FilterHoroYearElement filterHoroElement() {
//        return null;
//    }

    @Step("Проверяем, что вкладка  не активна в фильтре")
    public void filterTabShouldNotBePresent(String horoData) {
        assertTrue(String.format("Вкладка фильтра %s не должна быть активна", horoData),
                getFilterHoroElement().isFilterTabNotActive(horoData));
    }

    @Step("Кликаем на вкладку ")
    public void clickFilterYearTab(String horoData) {
        getFilterHoroElement().clickFilterTab(horoData);
    }


}


