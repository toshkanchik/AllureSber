package ru.appline.sberFramework.baseClasses;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.sberFramework.managers.PageMngr;
import ru.appline.sberFramework.managers.PropMngr;

import static ru.appline.sberFramework.managers.DriverMngr.getDriver;
import static ru.appline.sberFramework.managers.InitMngr.InitAll;
import static ru.appline.sberFramework.managers.InitMngr.closeAll;
import static ru.appline.sberFramework.managers.PageMngr.getPageMngr;

public class BaseTest {
    protected PageMngr pages = getPageMngr();
    @BeforeAll
    static void beforeAll(){
        InitAll();
    }
    @BeforeEach
    void beforeEach(){
        getDriver().get(PropMngr.GetPropMngr().getProperty("app.url"));
    }
    @AfterEach
    void afterEach(){
        addScreenshot();
    }
    @AfterAll
    static void after()
    {
        closeAll();

    }
    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
