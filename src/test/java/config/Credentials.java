package config;

import org.aeonbits.owner.ConfigFactory;

public class Credentials {

    public static BrowserStackConfig configBrowserstack = ConfigFactory.create(BrowserStackConfig.class);
    public static LocalConfig configLocal = ConfigFactory.create(LocalConfig.class);

}
// это компантный способ спрятать переменные в owner
