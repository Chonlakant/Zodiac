package co.co.aq.testnoti;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseInstallation;



public class MainApplication extends Application {

    private final String APPLICATION_ID = "sawbvcVxXPx4f6WFew9GLECNjBllw5QdlRpyBY3M";
    private final String CLIENT_KEY = "AwLWpH3Dckw8KXsiRMkiS56WzdUEAODxgOecEwk3";
    private final String FACEBOOK_APP_ID = "823198451133006";

    @Override
    public void onCreate() {
        super.onCreate();
        // Add your initialization code here
        Parse.initialize(this);

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        ParseFacebookUtils.initialize(this);

    }
}
