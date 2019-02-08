package ru.mail.example;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.example.data.MonthData;
import ru.mail.example.driver.DriverProvider;
import ru.mail.example.steps.HoroMonthPageSteps;
import ru.mail.example.steps.elements.FilterHoroMonthElementSteps;

import java.util.Arrays;
import java.util.List;

/**
 * Проверяем клил по плитке месяцев проекта "Гороскоп"
 */
@DisplayName("Проверяем клил по плитке месяцев на странице проекта \"Гороскоп\"")
public class HoroMonth_Test {

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

    public void click_horo_filter_tab(){
        //Открываем страницу
        HoroMonthPageSteps horoPageSteps = new HoroMonthPageSteps(driverProvider.getDriver());
        horoPageSteps.open("Лунно-солнечный прогноз на месяц");

        //Получаем название всех статей на странице
        List<String> titles = horoPageSteps.getAllArticlesTitles();

        //Проверяем, что вкладка активна
        FilterHoroMonthElementSteps filterHoroMonthElementSteps = new FilterHoroMonthElementSteps(driverProvider.getDriver());
//        filterHoroElement.clickFilterTab(MonthData.April);

        //Проверяем, что апрель активен
        filterHoroMonthElementSteps.filterTabShouldBeActive(MonthData.April);
        //Кликаем на "март"
        filterHoroMonthElementSteps.clickFilterMonthTab(MonthData.March);

        //Проверяем, что март активный
        filterHoroMonthElementSteps.filterTabShouldBeActive(MonthData.March);


        //Проверяем, что остальные не активны
        Arrays.stream(MonthData.values())
                .filter(horoMonth->horoMonth != MonthData.March)
                .forEach(horoMonth -> filterHoroMonthElementSteps.filterTabShouldNotBePresent(horoMonth));

        //Проверяем, что список статей изменился
        horoPageSteps.articlesTitlesShouldBeChanged(titles);

    }
}











