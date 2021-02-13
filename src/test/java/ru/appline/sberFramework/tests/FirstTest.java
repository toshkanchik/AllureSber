package ru.appline.sberFramework.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.appline.sberFramework.baseClasses.BaseTest;

public class FirstTest extends BaseTest {
    @Test()
    @DisplayName("Оформление ипотеки")
    @Description("Оформление ипотеки")
    public void testStart(){
        pages.getStartPage()
                .selectBaseMenu("Ипотека")
                .selectSubMenu("Ипотека на готовое жильё")
                .switchToSubwindow()
                .inputField("Стоимость недвижимости", "5180000")
                .inputField("Первоначальный взнос", "3058000")
                .inputField("Срок кредита", "30")
                .setButtonsByName("Страхование жизни и здоровья", false)
                .setButtonsByName("Молодая семья", true)
                .checkIfFieldEquals("Ежемесячный платеж","16 017 ₽")
                .checkIfFieldEquals("Сумма кредита","2 122 000 ₽")
                .checkIfFieldEquals("Необходимый доход","20 618 ₽")
                .checkIfFieldEquals("Процентная ставка","11%")
        ;


    }
}
