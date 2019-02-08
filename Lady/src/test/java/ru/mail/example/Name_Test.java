package ru.mail.example;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.example.driver.DriverProvider;
import ru.mail.example.steps.LadyPageSteps;
import ru.mail.example.steps.elements.FilterLadyElementSteps;
import ru.mail.example.tools.WaitTools;

public class Name_Test {

    private DriverProvider driverProvider = null;


    @Before
    public void initDriver() {
        driverProvider = new DriverProvider();
    }

    @After
    public void closeDriver() {
        driverProvider.closeDriver();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void IsItThisName() {
        WaitTools wait = new WaitTools(driverProvider.getDriver());
        String testString = "паста";

        LadyPageSteps ladyPageSteps = new LadyPageSteps(driverProvider.getDriver());
        FilterLadyElementSteps filterLadyElementSteps = new FilterLadyElementSteps(driverProvider.getDriver());
        //Открытие страницы
        ladyPageSteps.open();
        //вводим testString
        filterLadyElementSteps.writeName(testString);
        //кликаем
        filterLadyElementSteps.clickFilterTab();

        //Проверяем, что названия совпадают
        filterLadyElementSteps.isEqual(testString);
    }

}
