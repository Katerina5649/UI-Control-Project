package ru.mail.example;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.example.driver.DriverProvider;
import ru.mail.example.steps.LadyPageSteps;
import ru.mail.example.steps.elements.FilterLadyElementSteps;

@DisplayName("Проверяем клил по плитке месяцев на странице проекта \"Гороскоп\"")
public class IsDifferent_Test {

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

    public void isDifferent() {
        LadyPageSteps ladyPageSteps = new LadyPageSteps(driverProvider.getDriver());
        FilterLadyElementSteps filterLadyElementSteps  = new FilterLadyElementSteps(driverProvider.getDriver());

       String testStrig = "паста";
        //Открытие страницы
        ladyPageSteps.open();
        //вводим паста

        filterLadyElementSteps.writeName(testStrig);
       //нажимаем на кнопку
       filterLadyElementSteps.clickFilterTab();
        //Проверка, что статьи различны
        ladyPageSteps.isTitlesDifferent(ladyPageSteps.getAllArticlesTitles());





    }
}