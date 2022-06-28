package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/browserstack.properties")

public interface BrowserStackConfig extends Config {

    String username();
    @Key("access_key")
    String accessKey();
    String app();
    String device();
    String os_version();
}
