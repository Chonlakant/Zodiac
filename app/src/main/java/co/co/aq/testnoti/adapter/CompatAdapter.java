package co.co.aq.testnoti.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.co.aq.testnoti.R;
import co.co.aq.testnoti.RoundedTransformation;
import co.co.aq.testnoti.model.Zodiac;


public class CompatAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Zodiac> compatList;
    //String[] avatar;


    public CompatAdapter(Context context, ArrayList<Zodiac> compatList) {
        this.mContext= context;
        this.compatList = compatList;
       // this.avatar = avatar;

    }

    public int getCount() {
        return compatList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Zodiac zodiac = null;

        if(view == null)
            view = mInflater.inflate(R.layout.item_array, parent, false);

        TextView textView = (TextView)view.findViewById(R.id.compat_main);
        textView.setText(compatList.get(position).nameTh);

        ImageView ava = (ImageView) view.findViewById(R.id.avatra);


//        Picasso.with(mContext)
//                .load("https://jobbkk.com/upload/variety/horo/20150217_1030.png")
//                .into(ava);

        Picasso.with(mContext)
                .load("https://jobbkk.com/upload/variety/horo/20150217_1030.png")
                .centerCrop()
                .resize(200, 200)
                .transform(new RoundedTransformation(100, 4))
                .into(ava);

        return view;
    }
}