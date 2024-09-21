package ru.yandex.praktikum;

import org.junit.Test;

public class EnterAnIncorrectOrderNumber extends BaseTest {

    private String number = "ТакогоЗаказаНет";

    @Test
    public void enterAnIncorrectOrderNumberTest() {
        objHomePage.goToNoSuchOrderScreen(number);
    }
}