package com.gzeinnumer.adapteronclicklistener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

//todo 14 implement
public class MainActivity extends AppCompatActivity implements AdapterRv.onItemClick{

    //todo 3
    String[] data ={"M","Fadli","Zein"};

    //todo 16
    AdapterRv adapterRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo 17
        adapterRv = new AdapterRv(this, data);

        //todo 18
        adapterRv.setOnClickListener2(MainActivity.this);


        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setAdapter(adapterRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    //todo 15
    @Override
    public void onItemClick(int position, String data) {
        Toast.makeText(this, "Position : " + position, Toast.LENGTH_SHORT).show();
    }
}
