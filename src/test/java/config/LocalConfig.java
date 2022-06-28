package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:resources/config/androidStudio.properties")

public interface LocalConfig extends Config {
    @DefaultValue("android")
    String platformName();

    @DefaultValue("Pixel 4 API 30")
    String device();

    @DefaultValue("11.0")
    @Key("os_version")
    String osVersion();

    @DefaultValue("http://localhost:4723/wd/hub")
    String localURL();
}
