package com.example.myr_v_c_s;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.myr_v_c_s.utils.DividerItemDecoration;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    S_Adapter mSportAdapter;
    LinearLayoutManager mLayoutManager;
    ArrayList<Sport> mSports = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getResources().getStringArray(R.array.ghh);
        int index = getIntent().getIntExtra("index", 0);

        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_drawable);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        mSportAdapter = new S_Adapter(this,mSports);

        switch(index) {
            case 0:
                //get the first array
//                ArrayList<Sport> mSports = new ArrayList<>();
//                String [] sportsList = getResources().getStringArray(R.array.aa);
//                mSports.add(new Sport(sportsList[0]));
                break;
            case 1:
                //get the second array
                break;
        }

    }
}
