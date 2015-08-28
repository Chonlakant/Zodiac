package co.co.aq.testnoti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ZodiacActivity extends AppCompatActivity {
    TextView titleTv;
    TextView characterTitleTv;
    TextView characterMainTv;

    String data;
    String title;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);

        titleTv = (TextView) findViewById(R.id.title);
        characterTitleTv = (TextView) findViewById(R.id.character_title);
        characterMainTv = (TextView) findViewById(R.id.character_main);

        title = getIntent().getStringExtra("title");
        data = getIntent().getStringExtra("data");
        number = getIntent().getIntExtra("number", 0);

        titleTv.setText(title);


        characterTitleTv.setText(getStringResourceByName(data + "_character_title"));
        characterMainTv.setText(getStringResourceByName(data + "_main"));
    }

    private String getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);
    }

    private String[] getStringArrayResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "array", packageName);
        return getResources().getStringArray(resId);
    }

}
