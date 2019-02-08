package ru.mail.example.elements.filter;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.example.data.MonthData;
import ru.mail.example.elements.Component;
import ru.mail.example.elements.ComponentObject;

@Component(xpath = "//*[contains(@class, 'filter__list')]")
public class FilterHoroNumberElement extends ComponentObject {

    public FilterHoroNumberElement(WebDriver driver) {
        super(driver);
    }
//как??
    private final String horoFilterNumberTabLocator = "//div[contains(@class, 'p-tabs__item_active')]//button[contains(@class, 'button')]";
    private final String horoFilterNumberNameLocator ="//div[contains(@class, 'p-tabs__item_active')]//input[@name='v1']";
    /**
     * Проверяет, что вкладка в фильтре активна
     *
     * @return boolean
     */
    public boolean isFilterNumberTabActive () {
        String locator = horoFilterNumberTabLocator;
        return waitTools.waitForCondition(ExpectedConditions.attributeContains(By.xpath(locator), "class", "filter__item_active"));
    }

    /**
     * Кликает на вкладку фильтра
     */
    public void clickFilterTab() {
        String locator = String.format(horoFilterNumberTabLocator);
        getDriver().findElement(By.xpath(locator)).click();
    }

    /**
     * Вводим имя
     *
     * @param name
     */
    public void writeName(String name){
        getDriver().findElement(By.xpath(horoFilterNumberNameLocator)).sendKeys(name);

    }

    /**
     * Получаем имя
     *
     */

    //todo
    public String getName(){
    return    getDriver().findElement(By.xpath(horoFilterNumberNameLocator)).getText();
    }

}
