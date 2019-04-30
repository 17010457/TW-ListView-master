package com.myapplicationdev.android.tw_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvYear;
    ArrayAdapter adapter;
    ArrayList<Modules> module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = this.findViewById(R.id.lvModules);
        tvYear = this.findViewById(R.id.tvYear);

        Intent i = getIntent();
        String year = i.getStringExtra("year");
        tvYear.setText(year);

        module = new ArrayList<Modules>();
        module.add(new Modules("C208", true));
        module.add(new Modules("C200", false));
        module.add(new Modules("C346", true));

        adapter = new ModuleAdapter(this, R.layout.rows, module);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Modules selectedModule = module.get(position);

                if (selectedModule.isProg() == true){
                    Toast.makeText(SecondActivity.this, selectedModule.getName() + " is a Programming module", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SecondActivity.this, selectedModule.getName() + " is not a Programming module", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }



}
