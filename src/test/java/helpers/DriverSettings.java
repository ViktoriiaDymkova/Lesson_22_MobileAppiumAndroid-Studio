package helpers;

import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;

public class DriverSettings {

    public static String getDeviceProvider(String deviceProvider) {
        if (deviceProvider.equals("local")) {
            return LocalMobileDriver.class.getName();
        }

        if (deviceProvider.equals("browserstack")) {
            return BrowserstackMobileDriver.class.getName();
        }

        throw new RuntimeException("Didn't select device");
    }
}
