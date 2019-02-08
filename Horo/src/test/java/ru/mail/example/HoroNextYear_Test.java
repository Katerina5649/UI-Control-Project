package ru.mail.example;


import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.example.data.MonthData;
import ru.mail.example.driver.DriverProvider;
import ru.mail.example.elements.filter.FilterHoroYearElement;
import ru.mail.example.steps.HoroMonthPageSteps;
import ru.mail.example.steps.HoroNumberPageSteps;
import ru.mail.example.steps.HoroYearPageSteps;
import ru.mail.example.steps.elements.FilterHoroMonthElementSteps;
import ru.mail.example.steps.elements.FilterHoroNumberElementSteps;
import ru.mail.example.steps.elements.FilterHoroYearElementSteps;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@DisplayName("Проверяем переключение года на странице проекта \"Гороскоп\"")
public class HoroNextYear_Test {
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
    public void click_horo_filter_tab() {

        FilterHoroYearElementSteps filterHoroYearElementSteps = new FilterHoroYearElementSteps(driverProvider.getDriver());
        HoroYearPageSteps horoPageSteps = new HoroYearPageSteps(driverProvider.getDriver());
//Открываем страницу
        horoPageSteps.open("Лунно-солнечный прогноз на месяц");

        //Берем название всех статей
        List<String> titles = horoPageSteps.getAllArticlesTitles();
        //Проверяем, что таб активен
        filterHoroYearElementSteps.filterTabShouldBeActive("октябрь 2017");

//Кликаем на таб январь
        filterHoroYearElementSteps.clickFilterYearTab("январь 2018");
//Проверяем, что январь активен
        filterHoroYearElementSteps.filterTabShouldBeActive("январь 2018");
//Проверяем, что статьи изменились
        horoPageSteps.articlesTitlesShouldBeChanged(titles);


    }
}
