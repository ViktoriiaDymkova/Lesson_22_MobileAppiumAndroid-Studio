package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config/browserstack.properties")

public interface BrowserstackConfig extends Config {

    String username();
    String access_key();
    String app();
    String device();
    String os_version();
}
