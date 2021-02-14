package ru.appline.sberFramework.utils;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static ru.appline.sberFramework.managers.DriverMngr.getDriver;

public class MyListener implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        addScreenshot1();
    }

    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
    public byte[] addScreenshot1() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
