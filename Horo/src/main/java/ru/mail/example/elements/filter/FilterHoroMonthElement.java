package ru.mail.example.elements.filter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.example.data.MonthData;
import ru.mail.example.elements.Component;
import ru.mail.example.elements.ComponentObject;


@Component(xpath = "//*[contains(@class, 'filter__list')]")
public class FilterHoroMonthElement extends ComponentObject {

    public FilterHoroMonthElement(WebDriver driver) {
        super(driver);
    }

    private final String horoFilterMonthTabLocator = "//a[contains(@class, 'filter__item')][.//span[@class='filter__text'][text()='%s']]";

    /**
     * Проверяет, что вкладка в фильтре активна
     *
     * @return boolean
     */
    public boolean isFilterTabActive (MonthData horoData) {
        String locator = String.format(horoFilterMonthTabLocator, horoData.getName());
        return waitTools.waitForCondition(ExpectedConditions.attributeContains(By.xpath(locator), "class", "filter__item_active"));
    }

    /**
     * Проверяет, что вкладка в фильтре не активна
     * @param horoData - вкладка
     * @return boolean
     */
    public boolean isFilterTabNotActive(MonthData horoData) {
        String locator = String.format(horoFilterMonthTabLocator, horoData.getName());
        return waitTools.waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains(By.xpath(locator), "class", "filter__item_active")));
    }

    /**
     * Кликает на вкладку фильтра
     * @param horoData - вкладка
     */
    public void clickFilterTab(MonthData horoData) {
        String locator = String.format(horoFilterMonthTabLocator, horoData.getName());
        getDriver().findElement(By.xpath(locator)).click();
    }
}
