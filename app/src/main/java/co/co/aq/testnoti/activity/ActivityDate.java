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
import android.widget.Toast;

import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.ui.ParseLoginBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import co.co.aq.testnoti.R;


public class ActivityDate extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private static final int LOGIN_REQUEST = 0;
    private static final String[] CONTENT = new String[]{"ARIES", "TAURUS", "GEMINI", "CANCER",
            "LEO", "VIRGO", "LIBRA", "SCORPIO", "SAGITTARIUS", "CAPRICORN", "AQUARIUS",
            "PISCES"};
    private ParseUser currentUser;

    ParseObject Zodiac;

    public static final String DATEPICKER_TAG = "datepicker";
    int daySelect;
    int monthSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);


        Zodiac = new ParseObject("Zodiac");

        final Calendar calendar = Calendar.getInstance();

        final DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), false);


        datePickerDialog.show(getSupportFragmentManager(), DATEPICKER_TAG);

        findViewById(R.id.dateButton).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                datePickerDialog.setYearRange(1985, 2028);
                datePickerDialog.show(getSupportFragmentManager(), DATEPICKER_TAG);
            }
        });

        if (savedInstanceState != null) {
            DatePickerDialog dpd = (DatePickerDialog) getSupportFragmentManager().findFragmentByTag(DATEPICKER_TAG);
            if (dpd != null) {
                dpd.setOnDateSetListener(this);
            }
        }

    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
        Toast.makeText(ActivityDate.this, "new date:" + year + "-" + month + "-" + day, Toast.LENGTH_LONG).show();
        daySelect = day;
        monthSelect = month;
        Log.e("Day",daySelect+"");
        Log.e("Month", monthSelect + "");

        getZodiac(daySelect, monthSelect);

        Zodiac.put("ZodiacTitle", getZodiac(daySelect, monthSelect));
        Zodiac.saveInBackground();

        Intent i =new Intent(getApplication(),ResultZodiac.class);
        i.putExtra("result", getZodiac(daySelect, monthSelect));
        startActivity(i);

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
}