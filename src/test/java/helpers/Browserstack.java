package helpers;

import config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    // это еще один способ спрятать переменные в owner через статик Стринги
    static BrowserStackConfig browserstackConfig = ConfigFactory.create(BrowserStackConfig.class);
    static String username = browserstackConfig.username();
    static String access_key = browserstackConfig.access_key();

    public static String videoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(username, access_key) // тут я тоже тяну лог/пас из проперти тк каждую сессию ключ меняется
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
