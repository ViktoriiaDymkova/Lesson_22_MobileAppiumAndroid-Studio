package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {

    String username();
    String access_key();
    String app();

    //@DefaultValue("Google Pixel 3")
    String device();
    //@DefaultValue("9.0")
    String os_version();
}