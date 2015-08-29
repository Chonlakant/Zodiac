package co.co.aq.testnoti.activity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import co.co.aq.testnoti.R;
import co.co.aq.testnoti.adapter.ImageAdapter;


public class MainActivityZodiac extends AppCompatActivity {

    private static final String[] CONTENT = new String[]{"ARIES", "TAURUS", "GEMINI", "CANCER",
            "LEO", "VIRGO", "LIBRA", "SCORPIO", "SAGITTARIUS", "CAPRICORN", "AQUARIUS",
            "PISCES"};

    private static final String[] CONTENT2 = new String[]{"aries", "taurus", "gemini", "cancer",
            "leo", "virgo", "libra", "scorpio", "sagittarius", "capricorn", "aquarius",
            "pisces"};

    private static final String[] CONTENT3 = new String[]{"ราศีเมษ", "ราศีพฤษภ", "ราศีเมถุน", "ราศีกรกฎ",
            "ราศีสิงห์", "ราศีกันย์", "ราศีตุลย์", "ราศีพิจิก", "ราศีธนู", "ราศีมังกร", "ราศีกุมภ์",
            "ราศีมีน"};

    private static final int[] ICONS = new int[]{R.drawable.aries001, R.drawable.taurus001,
            R.drawable.gemini001, R.drawable.cancer_001, R.drawable.leo_001, R.drawable.virgo001,
            R.drawable.libra_001, R.drawable.scorpio001, R.drawable.sagittarius_001, R.drawable.capricorn_001,
            R.drawable.aquarius_001, R.drawable.pisces_001 };

    ImageAdapter imageAdapter;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_zodiac);

        gridView = (GridView) findViewById(R.id.gridview);


//        final String mystring2 = getResources().getString(R.string.aquarius_title);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x / 4;
        int height = size.y / 4;

        imageAdapter = new ImageAdapter(getApplicationContext(), CONTENT, ICONS, height);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplication(),two.class);
                intent.putExtra("title", CONTENT3[i]);
                intent.putExtra("data", CONTENT2[i]);
                intent.putExtra("number",i);
                startActivity(intent);
            }
        });


        Log.e("height", height + "");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
