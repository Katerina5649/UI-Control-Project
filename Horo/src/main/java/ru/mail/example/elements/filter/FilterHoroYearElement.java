package ru.mail.example.elements.filter;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.example.data.MonthData;
import ru.mail.example.elements.Component;
import ru.mail.example.elements.ComponentObject;

@Component(xpath = "//*[contains(@class, 'cols__inner')]")
public class FilterHoroYearElement extends ComponentObject {

    public FilterHoroYearElement(WebDriver driver) {
        super(driver);
    }

    private final String horoFilterYearTabLocator = "//*[contains(@class, 'link_col_3')][.//span[@class='link__text'][text()='%s']]";

    /**
     * Проверяет, что вкладка в фильтре активна
     *
     * @return boolean
     */
    public boolean isFilterTabActive (String name) {
        String locator = String.format(horoFilterYearTabLocator, name);
        return waitTools.waitForCondition(ExpectedConditions.attributeContains(By.xpath(locator), "class", "link_active"));
    }

    /**
     * Проверяет, что вкладка в фильтре не активна
     *
     * @return boolean
     */
    public boolean isFilterTabNotActive(String horoData) {
        String locator = String.format(horoFilterYearTabLocator, horoData);
        return waitTools.waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains(By.xpath(locator), "class", "link_active")));
    }

    /**
     * Кликает на вкладку кнопку
     *
     */
    public void clickFilterTab(String name) {
        String locator = String.format(horoFilterYearTabLocator, name);
        getDriver().findElement(By.xpath(locator)).click();
    }

}
