package co.co.aq.testnoti.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.ui.ParseLoginBuilder;

import java.util.ArrayList;
import java.util.List;

import co.co.aq.testnoti.R;


public class ActivityDate extends AppCompatActivity {

    private static final int LOGIN_REQUEST = 0;
    private static final String[] CONTENT = new String[]{"ARIES", "TAURUS", "GEMINI", "CANCER",
            "LEO", "VIRGO", "LIBRA", "SCORPIO", "SAGITTARIUS", "CAPRICORN", "AQUARIUS",
            "PISCES"};
    private ParseUser currentUser;

    private Button loginOrLogoutButton;
    ParseObject Zodiac;
    private Spinner spinner1;
    int v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        final EditText etDate = (EditText) findViewById(R.id.editText);

        Button btn = (Button) findViewById(R.id.button);
        loginOrLogoutButton = (Button) findViewById(R.id.login_or_logout_button);


        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>
                (getApplicationContext(), android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                v = (int) spinner1.getItemAtPosition(i);
                Log.e("1111",v+"");
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Zodiac = new ParseObject("Zodiac");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String stringDay = etDate.getText().toString();
                final int day = Integer.parseInt(stringDay);

            //ตอนเรียกใช้Fucntion แต่ไม่รู้ว่าส่งไปถูกหรือป่าวครับ แต่ข้อมูลก็ขึ้นไปนะครับ
                getZodiac(day, v);
                Zodiac.put("ZodiacTitle", getZodiac(day, v));
                Zodiac.saveInBackground();

                Intent i = new Intent(getApplication(),MainActivityZodiac.class);
                startActivity(i);

            }
        });

        loginOrLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentUser != null) {
                    // User clicked to log out.
                    ParseUser.logOut();
                    currentUser = null;
                    ParseLoginBuilder loginBuilder = new ParseLoginBuilder(ActivityDate.this);
                    startActivityForResult(loginBuilder.build(), LOGIN_REQUEST);
                    showProfileLoggedOut();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {

        } else {
            showProfileLoggedOut();
        }
    }

    public String getZodiac(int day,int month) {
        if ((month == 11) && (day >= 22) || (month == 0) && (day <= 19)) {
            return CONTENT[0];
        } else if ((month == 0) && (day >= 20) || (month == 1) && (day <= 18)) {
            Log.e("555", "111");
            return CONTENT[1];
        } else if ((month == 1) && (day >= 19) || (month == 2) && (day <= 20)) {
            Log.e("555", "222");
            return CONTENT[2];
        } else if ((month == 2) && (day >= 21) || (month == 3) && (day <= 19)) {
            Log.e("555", "333");
            return CONTENT[3];
        } else if ((month == 3) && (day >= 20) || (month == 4) && (day <= 20)) {
            Log.e("555", "444");
            return CONTENT[4];
        } else if ((month == 4) && (day >= 21) || (month == 5) && (day <= 20)) {
            Log.e("555", "555");
            return CONTENT[5];
        } else if ((month == 5) && (day >= 21) || (month == 6) && (day <= 22)) {
            Log.e("555", "666");
            return CONTENT[6];
        } else if ((month == 6) && (day >= 23) || (month == 7) && (day <= 22)) {
            Log.e("555", "777");
            return CONTENT[7];
        } else if ((month == 7) && (day >= 23) || (month == 8) && (day <= 21)) {
            Log.e("555", "888");
            return CONTENT[8];
        } else if ((month == 8) && (day >= 22) || (month == 9) && (day <= 21)) {
            Log.e("555", "999");
            return CONTENT[9];
        } else if ((month == 9) && (day >= 24) || (month == 10) && (day <= 22)) {
            Log.e("555", "1010");
            return CONTENT[10];
        } else if ((month == 10) && (day >= 23) || (month == 11) && (day <= 21)) {
            Log.e("555", "11111");
            return CONTENT[11];
        } else {
            return null;

        }
    }
    private void showProfileLoggedOut() {
        loginOrLogoutButton.setText("Log out");
    }
}