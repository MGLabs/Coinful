package com.mglabs.digitalgain;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AddCoinsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CoinStore store;
    private AddCoinsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coins);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Initialize RecyclerView
        mRecyclerView = findViewById(R.id.add_coins_recyclerview);
        initRecyclerView();
        CoinStore.initializeData();
    }

    private void initRecyclerView() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(
                mRecyclerView.getContext(),
                mLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(mDividerItemDecoration);

        //Initialize the store
        store = new CoinStore(this);
        mAdapter = new AddCoinsAdapter(this, store);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);  //all the items list have same size avoiding possible resizing
    }
}
