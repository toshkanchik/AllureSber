package ru.appline.sberFramework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static ru.appline.sberFramework.managers.DriverMngr.getDriver;
import static ru.appline.sberFramework.utils.MyLogger.getLog;

public class MortgageCalcPage extends BasePage {

    /**
     * Функция перевода фокуса на окно калькулятора
     *
     *
     * @return MortgageSubwindow
     */
    @Step("Переключиться на окно калькулятора")
    public MortgageSubwindow switchToSubwindow() {
        getLog().fine("Switching to subwindow");
        scrollToElementJs(getDriver().findElement(By.xpath("//h2[@class='t-header-big' and . ='​Рассчитайте ипотеку']")));
        getDriver().switchTo().frame("iFrameResizer0");
//        getDriver().findElement(By.xpath("//span[. ='Ежемесячный платеж']"));
        return pages.getMortgageSubwindow();
    }
}
