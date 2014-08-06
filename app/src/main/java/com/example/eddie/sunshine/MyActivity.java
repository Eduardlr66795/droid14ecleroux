package com.example.eddie.sunshine;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MyActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private ArrayAdapter<String> forecast;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);

            String forecastArray[] = {
                    "Today - Sunny - 88/63",
                    "Tomorrow - Sunny - 88/63",
                    "Wednesday - Sunny - 88/63",
                    "Thursday - Sunny - 88/63",
                    "Friday - Sunny - 88/63"
            };

            ArrayList<String> forecastList = new ArrayList<String>(Arrays.asList(forecastArray));

            forecast = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item_forecast,
                R.id.list_item_forecast_textview,
                forecastList);


            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(forecast);


//            Calendar cal = Calendar.getInstance();
//            Intent intent = new Intent(Intent.ACTION_EDIT);
//            intent.setType("vnd.android.cursor.item/event");
//            intent.putExtra("beginTime", cal.getTimeInMillis());
//            intent.putExtra("allDay", true);
//            intent.putExtra("rrule", "FREQ=YEARLY");
//            intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
//            intent.putExtra("title", "A Test Event from android app");
//            startActivity(intent);


            return rootView;
        }






    }
}
