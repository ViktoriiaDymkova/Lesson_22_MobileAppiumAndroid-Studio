package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/browserstack.properties")

public interface BrowserStackConfig extends Config {

    @DefaultValue("bsuser_zB7OhS")
    String username();

    @Key("access_key")
    @DefaultValue("yjW2gs4QfhiTDpfJZgyk")
    String accessKey();

    @DefaultValue("bs://ee714901a6bef9d1429d8afe111b9342ea5bd996\n")
    String app();

    @DefaultValue("Google Pixel 3")
    String device();

    @DefaultValue("9.0")
    String os_version();
}
