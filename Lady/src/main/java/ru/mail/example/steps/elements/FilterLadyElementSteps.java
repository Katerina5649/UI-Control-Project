package ru.mail.example.steps.elements;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.example.elements.filter.FilterLadyElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 * Компонент фильтра на странице. Паттерн Component Object.
 */
@DisplayName("Test steps")
public class FilterLadyElementSteps extends AbstractSteps {

    public FilterLadyElementSteps(WebDriver driver) {
        super(driver);
    }

    private FilterLadyElement filterElement;

    private FilterLadyElement getFilterElement() {
      filterElement = PageFactory.initElements(getDriver(), FilterLadyElement.class);
        return filterElement;
    }




    @Step("Кликаем на вкладку {horoData.getName}")
    public void clickFilterTab() {
        getFilterElement().clickFilterTab();
    }

    @Step("Проверяем, что поиск по имени name")
    public void isEqual(String name) {
        assertEquals(getFilterElement().getName(), name);
    }

    @Step("вводим имя")
    public void writeName(String name){
        getFilterElement().writeName(name);
    }
}