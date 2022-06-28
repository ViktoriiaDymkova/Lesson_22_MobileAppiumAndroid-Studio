package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:resources/config/androidStudio.properties")

public interface LocalConfig extends Config {
    @DefaultValue("android")
    String platformName();

    @DefaultValue("Pixel 4 API 30")
    String device();

    @DefaultValue("11.0")
    String os_version();

    @DefaultValue("http://localhost:4723/wd/hub")
    String localURL();
}
