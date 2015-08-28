package co.co.aq.testnoti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.meetme.android.horizontallistview.HorizontalListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.co.aq.testnoti.adapter.BadAdapter;
import co.co.aq.testnoti.adapter.CelebsEnAdapter;
import co.co.aq.testnoti.adapter.CelebsTnAdapter;
import co.co.aq.testnoti.adapter.CompatAdapter;
import co.co.aq.testnoti.adapter.GoodAdapter;
import co.co.aq.testnoti.model.Zodiac;


public class two extends AppCompatActivity {

    ImageView icon;
    TextView titleTv;
    TextView characterTitleTv;
    TextView characterMainTv;
    TextView compatTitleTv;
    TextView goodTitleTv;
    TextView badTitleTv;
    TextView celesThTv;
    TextView celesEnTv;
    TextView characterDateTv;


    String data;
    String title;
    int number;

    String[] compatArray;
    String[] goodTitleMain;
    String[] badTitleMain;
    String[] celebsEn;
    String[] celebsTh;

    String compatTitle;
    String goodTitle;
    String badTitle;
    String celebsThTitle;
    String celebsEnTitle;
    String characterDateTtitle;
    //ListView
    HorizontalListView hlvCompat;
    ListView hlvGood;
    ListView hlvBad;
    ListView hlvCelesTH;
    HorizontalListView hlvCelesEn;
    //Adapter
    CompatAdapter compatAdapter;
    GoodAdapter goodAdapter;
    BadAdapter badAdapter;
    CelebsTnAdapter celebsTnAdapter;
    CelebsEnAdapter celebsEnAdapter;

    ArrayList<Zodiac> compatList = new ArrayList<>();

    private static final String[] CONTENT2 = new String[]{"aries", "taurus", "gemini", "cancer",
            "leo", "virgo", "libra", "scorpio", "sagittarius", "capricorn", "aquarius",
            "pisces"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);

        titleTv = (TextView) findViewById(R.id.title);
        characterTitleTv = (TextView) findViewById(R.id.character_title);
        characterMainTv = (TextView) findViewById(R.id.character_main);

        compatTitleTv = (TextView) findViewById(R.id.compat_title);
        characterDateTv = (TextView) findViewById(R.id.character_date);
        goodTitleTv = (TextView) findViewById(R.id.good_title);
        badTitleTv = (TextView) findViewById(R.id.bad_title);
        celesThTv = (TextView) findViewById(R.id.celes_th);
        celesEnTv = (TextView) findViewById(R.id.celes_en);


        hlvCompat = (HorizontalListView) findViewById(R.id.hlvCompat);
        hlvGood = (ListView) findViewById(R.id.hlvGood);
        hlvBad = (ListView) findViewById(R.id.hlvBad);
        hlvCelesTH = (ListView) findViewById(R.id.hlvCelesTH);
        hlvCelesEn = (HorizontalListView) findViewById(R.id.hlvCelesEn);

        title = getIntent().getStringExtra("title");
        data = getIntent().getStringExtra("data");
        number = getIntent().getIntExtra("number", 0);

        titleTv.setText(title);


        characterTitleTv.setText(getStringResourceByName(data + "_character_title"));
        characterMainTv.setText(getStringResourceByName(data + "_main"));


        compatArray = getStringArrayResourceByName(data + "_compat_array");
        compatTitle = getStringResourceByName(data + "_compat_title");
        characterDateTtitle = getStringResourceByName(data+"_date");
        goodTitle = getStringResourceByName(data + "_good_title");
        badTitle = getStringResourceByName(data + "_bad_title");
        celebsThTitle = getStringResourceByName(data + "_thai");
        celebsEnTitle = getStringResourceByName(data + "_wold");

        goodTitleMain = getStringArrayResourceByName(data + "_good_main_array");
        badTitleMain = getStringArrayResourceByName(data + "_bad_main_array");
        celebsEn = getStringArrayResourceByName(data + "_world_celeb_array");
        celebsTh = getStringArrayResourceByName(data + "_thai_celeb_array");

        Log.e("56780", compatTitle + "");

        for(int i = 0; i< compatArray.length ; i++) {
            String[] parts = compatArray[i].split(",");
            Zodiac zodiac = null;

            if(parts.length == 4) {
                zodiac = new Zodiac(Integer.parseInt(parts[0]),parts[1],parts[2],parts[3]);
                compatList.add(zodiac);
            }
        }

        compatAdapter = new CompatAdapter(getApplicationContext(), compatList);
        goodAdapter = new GoodAdapter(getApplicationContext(), goodTitleMain);
        badAdapter = new BadAdapter(getApplicationContext(), badTitleMain);
        celebsTnAdapter = new CelebsTnAdapter(getApplicationContext(), celebsTh);
        celebsEnAdapter = new CelebsEnAdapter(getApplicationContext(), celebsEn);

        hlvCompat.setAdapter(compatAdapter);
        hlvGood.setAdapter(goodAdapter);
        hlvBad.setAdapter(badAdapter);
        hlvCelesTH.setAdapter(celebsTnAdapter);
        hlvCelesEn.setAdapter(celebsEnAdapter);

        setListViewHeightBasedOnItems(hlvGood);
        setListViewHeightBasedOnItems(hlvBad);
        setListViewHeightBasedOnItems(hlvCelesTH);

        compatTitleTv.setText(compatTitle);
        goodTitleTv.setText(goodTitle);
        badTitleTv.setText(badTitle);
        celesThTv.setText(celebsThTitle);
        celesEnTv.setText(celebsEnTitle);
        characterDateTv.setText(characterDateTtitle);

        ImageView ava = (ImageView)findViewById(R.id.avatra);
        Picasso.with(getApplicationContext())
                .load("http://www.deeja.net/uploads/img/horoscop/chinese/05-dragon.gif")
                .centerCrop()
                .resize(200, 200)
                .transform(new RoundedTransformation(100, 4))
                .into(ava);

        String packageName = getPackageName();
        //String a = getResources().getIdentifier("taurus_world_celeb_array", "string", packageName);
        String[] a = getResources().getStringArray(R.array.taurus_world_celeb_array);

        hlvCompat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), two.class);
                intent.putExtra("title", compatList.get(i).nameEn);
                intent.putExtra("data", compatList.get(i).codeName);
                intent.putExtra("number", compatList.get(i).id);
                startActivity(intent);
            }
        });

    }

    public static boolean setListViewHeightBasedOnItems(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, listView);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = listView.getDividerHeight() *
                    (numberOfItems - 1);

            // Set list height.
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight;
            listView.setLayoutParams(params);
            listView.requestLayout();

            return true;

        } else {
            return false;
        }

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
