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
import ru.mail.example.steps.HoroNumberPageSteps;
import ru.mail.example.steps.elements.FilterHoroMonthElementSteps;
import ru.mail.example.steps.elements.FilterHoroNumberElementSteps;

import java.util.Arrays;
import java.util.List;

@DisplayName("Проверяем  на странице проекта \"Числовая вибрация имен\"")
public class HoroNumber_Test {

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

        String testString = "Тест";

        HoroNumberPageSteps horoNumberPageSteps = new HoroNumberPageSteps(driverProvider.getDriver());
        FilterHoroNumberElementSteps filterHoroNumberElementSteps = new FilterHoroNumberElementSteps(driverProvider.getDriver());

        //открываем страницу
        horoNumberPageSteps.open("Числовая вибрация имени");

        //Проверяем что имя ввода пустое
        filterHoroNumberElementSteps.isEmpty();

        //Берем название всех статей
        List<String> titles = horoNumberPageSteps.getAllArticlesTitles();

        //Вводим "Тест"
        filterHoroNumberElementSteps.writeName(testString);

        //Нажимаем на кнопку "Вычислить"
        filterHoroNumberElementSteps.clickFilterNumberTab();


        //Проверяем, что статьи изменились
        horoNumberPageSteps.articlesTitlesShouldBeChanged(titles);
    }
}
























/*        //Проверяем что заголовок изменился
        horoNumberPageSteps.isEqual("Число взаимодействия с миром");
*/