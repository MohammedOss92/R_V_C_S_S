package com.example.myr_v_c_s;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myr_v_c_s.Data.DataBase;
import com.example.myr_v_c_s.utils.CommonUtils;
import com.example.myr_v_c_s.utils.DividerItemDecoration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    S_Adapter mSportAdapter;
    LinearLayoutManager mLayoutManager;
    ArrayList<Sport> mSports = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_drawable);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        mSportAdapter = new S_Adapter(this,mSports);

        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });
        prepareDemoContent();

//        getResources().getStringArray(R.array.sports_titles);
    }

    private void prepareDemoContent() {
//        CommonUtils.showLoading(MainActivity.this);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                //prepare data and show loading
//                CommonUtils.hideLoading();
                ArrayList<Sport> mSports = new ArrayList<>();
                String [] sportsList = getResources().getStringArray(R.array.sports_info);
                //no data base
//            mSportList.add(new MsgTypes(name[0]));
//            mSportList.add(new MsgTypes(name[1]));
                //in data base

                DataBase.getInstance(MainActivity.this).addNewRow(sportsList[0]);
                DataBase.getInstance(MainActivity.this).addNewRow(sportsList[1]);
                DataBase.getInstance(MainActivity.this).addNewRow(sportsList[2]);
                DataBase.getInstance(MainActivity.this).addNewRow(sportsList[3]);
//                DataBase.getInstance(MainActivity.this).addNewRow(sportsList[2]);
//                DataBase.getInstance(MainActivity.this).addNewRow(sportsList[3]);
//                DataBase.getInstance(MainActivity.this).addNewRow(sportsList[4]);



//            DataBase.getInstance(this).addNewRow();
//            for (int i = 0; i < sportsList.length; i++) {
//                DataBase.getInstance(this).addNewRow(sportsList[i]);
//            }

                ArrayList<Sport> contactList = DataBase.getInstance(MainActivity.this).getAllPrayer();
                Log.e("contactList", contactList.size() + " size");

                DataBase db = new DataBase(MainActivity.this);
                mSports.addAll(DataBase.getInstance(MainActivity.this).getAllPrayer());


                mSportAdapter.addItems(mSports);
                mRecyclerView.setAdapter(mSportAdapter);
//            }
//        }, 2000);


    }
}
