package com.example.ke.ibetatesting.view;

/**
 * Created by ke on 12/7/17.
 */

import com.example.ke.ibetatesting.util.DatabaseHelper;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import com.example.ke.ibetatesting.R;

    public class ShowListActivity extends Activity {
    private ListView listView;
    DatabaseHelper databaseHelper;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showlist);
        databaseHelper = new DatabaseHelper(this);

        listView = (ListView) this.findViewById(R.id.testRecord_listview);
        listView.setOnItemClickListener(new ItemClickListener());

        // get the sql string delivered from the QueryActivity
        Intent intent = this.getIntent();
        String sql = intent.getStringExtra("sql");
        // execute the sql
        //Cursor cursor = DatabaseHelper.getInstance().execQuery(sql);
        Cursor cursor = databaseHelper.execQuery(sql);
        // bind the data to list
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                getApplicationContext(), R.layout.listitem, cursor,
                new String[] { "_id", "Tester_ID", "Call_actDateTime" }, new int[] {
                R.id.devicesn, R.id.testerid, R.id.actitime },
                SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);
        listView.setAdapter(adapter);
    }

    private class ItemClickListener implements OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
            Cursor cursor = (Cursor) listView.getItemAtPosition(position);
            String cid = cursor.getString(0);
            String bclat = cursor.getString(1);
            String bclon = cursor.getString(2);
            String gglat = cursor.getString(3);
            String gglon = cursor.getString(4);
            String locdesc = cursor.getString(5);
            String loctype = cursor.getString(6);
            String deviceSN = cursor.getString(7);
            String tid= cursor.getString(8);
            String acttime = cursor.getString(9);
            String contime = cursor.getString(10);
            String acttype = cursor.getString(11);
            String actcity = cursor.getString(12);

            Toast.makeText(getApplicationContext(),"Case No: " + cid + "\nDevice Lat: " + bclon+ "\nDevice Lon: " + bclat + "\nGoogle Lat: "+ gglat + "\nGoogle Lon: " + gglon+ "\nLocation Description" + locdesc+ "\nLocation Type" + loctype+ "\nDevice SN" +deviceSN+ "\nTester ID" +tid + "\nTest Time" +acttime + "\nConnected Time" +contime + "\nActivation Type" +acttype + "\nTest City" +actcity, Toast.LENGTH_LONG).show();
        }
    }
}

