package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    ///это я добвила из класса BrowserstackMobileDriver, чтобы скрыть лог/пасс в хелперах
    static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);
    static String username = browserstackConfig.username();
    static String access_key = browserstackConfig.access_key();

    public static String videoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(username, access_key)
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
