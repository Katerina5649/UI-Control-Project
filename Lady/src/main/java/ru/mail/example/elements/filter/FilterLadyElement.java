package ru.mail.example.elements.filter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.example.elements.Component;
import ru.mail.example.elements.ComponentObject;

@Component(xpath = "//*[contains(@class, 'bigsearch_lady')]")
public class FilterLadyElement extends ComponentObject {

    public FilterLadyElement(WebDriver driver) {
        super(driver);
    }
    //как??
    private final String ladyFilterTabLocator = "//form[contains(@class, 'js-formvalidate__form')]//button[contains(@class, 'button')]";
    private final String ladyFilterNameLocator ="//form[contains(@class, 'js-formvalidate__form')]//input[contains(@class, 'input__field')]";
    /**
     * Проверяет, что вкладка в фильтре активна
     *
     * @return boolean
     */
    public boolean isFilterLadyTabActive () {
        String locator = ladyFilterTabLocator;
        return waitTools.waitForCondition(ExpectedConditions.attributeContains(By.xpath(locator), "class", "filter__item_active"));
    }

    /**
     * Кликает на вкладку фильтра
     */
    public void clickFilterTab() {
        String locator = String.format(ladyFilterTabLocator);
        getDriver().findElement(By.xpath(locator)).click();
    }

    /**
     * Вводим имя
     *
     * @param name
     */
    public void writeName(String name){
        getDriver().findElement(By.xpath(ladyFilterNameLocator)).sendKeys(name);

    }

    /**
     * Получаем имя
     *
     */


    public String getName(){
        return    getDriver().findElement(By.xpath(ladyFilterNameLocator)).getAttribute("value");
    }

}
