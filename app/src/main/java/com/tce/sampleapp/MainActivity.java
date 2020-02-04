package com.tce.sampleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);

        ArrayList<FeedModel> feedModels = new ArrayList<FeedModel>();

        feedModels.add(new FeedModel("Android Activity","class 1",R.drawable.ic_launcher_background));
        feedModels.add(new FeedModel("Thiagrajar College of Engineering","Department of Information Technology",R.drawable.ic_launcher_foreground));

        listView.setAdapter(new MyAdapter(feedModels,MainActivity.this));
    }

    private class MyAdapter extends ArrayAdapter<FeedModel> {

        //my adapter fits the data to our custom view
        private List<FeedModel> feedModels;
        private Context context;

        public MyAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<FeedModel> objects) {
            super(context, resource, textViewResourceId, objects);
            this.context = context;
            feedModels = objects;
            //adapter intiated with the list of objects and context

        }

        public MyAdapter(ArrayList<FeedModel> data, Context context) {
            super(context, R.layout.layout_list, data);
            this.feedModels = data;
            this.context=context;

        }

        // override other abstract methods here

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.layout_list, container, false);
            }

            //data is loaded from the list of custom objects to the individual views
            ((TextView) convertView.findViewById(R.id.title)).setText(getItem(position).getTitle());
            ((TextView) convertView.findViewById(R.id.subtitle)).setText(getItem(position).getSubtitle());
            ((ImageView) convertView.findViewById(R.id.image)).setImageResource(getItem(position).getImage());
            return convertView;
        }
    }
}
