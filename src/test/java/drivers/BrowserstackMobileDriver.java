package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackConfig;
import config.Credentials;
import config.LocalConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {


    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        // Set your access credentials // это компантный способ спрятать переменные в owner через Credentials
        mutableCapabilities.setCapability("username", Credentials.configBrowserstack.username());
        mutableCapabilities.setCapability("access_key", Credentials.configBrowserstack.accessKey());
        mutableCapabilities.setCapability("app", Credentials.configBrowserstack.app());

        // Set URL of the application under test
//        mutableCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        //  mutableCapabilities.setCapability("app", app);

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", Credentials.configBrowserstack.device());
        mutableCapabilities.setCapability("os_version", Credentials.configBrowserstack.os_version());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "QA.GURU lesson 22");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "selenide android test");
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}