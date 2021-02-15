package ru.appline.sberFramework.managers;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverMngr {
    private static WebDriver driver;
    private static DriverMngr instance = null;


    private DriverMngr() {
        PropMngr props = PropMngr.GetPropMngr();
        switch (props.getProperty("type.browser")) {
            case "edge":
                System.setProperty("webdriver.edge.driver", props.getProperty("path.edge.driver.windows"));
                driver = new EdgeDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", props.getProperty("path.chrome.driver.windows"));
                driver = new ChromeDriver();
                break;
            case "remote":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                switch (props.getProperty("remoteBrowser")) {
                    case "chrome":
                        capabilities.setBrowserName("chrome");
                        capabilities.setVersion("73.0");
                        capabilities.setCapability("enableVNC", true);
                        capabilities.setCapability("enableVideo", false);
                        try {
                            driver = new RemoteWebDriver(URI.create("http://selenoid.appline.ru:4445/wd/hub/").toURL(), capabilities);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "firefox":
                        capabilities.setBrowserName("firefox");
                        capabilities.setVersion("65.0");
                        capabilities.setCapability("enableVNC", true);
                        capabilities.setCapability("enableVideo", false);

                        try {
                            driver = new RemoteWebDriver(URI.create("http://selenoid.appline.ru:4445/wd/hub/").toURL(), capabilities);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "opera":
                        capabilities.setBrowserName("opera");
                        capabilities.setVersion("58.0");
                        capabilities.setCapability("enableVNC", true);
                        capabilities.setCapability("enableVideo", false);

                        try {
                            driver = new RemoteWebDriver(URI.create("http://selenoid.appline.ru:4445/wd/hub/").toURL(), capabilities);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        Assertions.fail("Браузер '" + props.getProperty("type.remoteBrowser") + "' не поддерживается на сервере");
                }
            default:
                Assertions.fail("Типа браузера '" + props.getProperty("type.browser") + "' не существует во фреймворке");
        }
    }

    public static WebDriver getDriver(){
        if(instance == null){
            instance = new DriverMngr();
        }
        return driver;
    }
    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
