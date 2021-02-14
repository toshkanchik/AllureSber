package ru.appline.sberFramework.baseClasses;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.appline.sberFramework.managers.PageMngr;
import ru.appline.sberFramework.managers.PropMngr;
import ru.appline.sberFramework.utils.MyListener;

import static ru.appline.sberFramework.managers.DriverMngr.getDriver;
import static ru.appline.sberFramework.managers.InitMngr.InitAll;
import static ru.appline.sberFramework.managers.InitMngr.closeAll;
import static ru.appline.sberFramework.managers.PageMngr.getPageMngr;

@ExtendWith(MyListener.class)
public class BaseTest {
    protected PageMngr pages = getPageMngr();

    @BeforeAll
    static void beforeAll() {
        InitAll();
    }

    @BeforeEach
    void beforeEach() {
        getDriver().get(PropMngr.GetPropMngr().getProperty("app.url"));
    }

    @AfterAll
    static void after() {
        closeAll();
    }
}
