package com.benedek.listview;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView listView;
    private CustomAdapter customAdapter;

    private ArrayList<Row> rows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initArrayList();

        listView = (ListView) findViewById(R.id.listView);
        customAdapter = new CustomAdapter(rows, getBaseContext());
        listView.setAdapter(customAdapter);

    }

    private void initArrayList() {
        rows = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Row row1 = new Row(R.drawable.settings, "this is a text " + i);
            rows.add(row1);
        }
    }

    private class CustomAdapter extends BaseAdapter{

        private ArrayList<Row> rows;
        private Context context;

        public CustomAdapter(ArrayList<Row> rows, Context context) {
            this.rows = rows;
            this.context = context;
        }

        @Override
        public int getCount() {
            return rows.size();
        }

        @Override
        public Object getItem(int position) {
            return rows.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listviewrow, parent, false);
            }

            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            imageView.setBackgroundResource(rows.get(position).getDrawableId());

            TextView textView = (TextView) convertView.findViewById(R.id.textView);
            textView.setText(rows.get(position).getText());

            return convertView;
        }
    }


}
